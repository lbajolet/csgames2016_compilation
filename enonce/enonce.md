# Compétition de compilation

## Auteurs
 * Julien Zakaib (VP-Compétitions)
 * Lucas Bajolet (VP-Compétitions)
 * Philippe Pépos Petitclerc (VP-Président)
 * Romain Chanoir (VP-Lore)
 * Jean Privat (Professeur Collaborateur)

## Mise en contexte

TODO

## Description

Vous devrez développer un interpreteur de Mpire. Les specifications du langage
vous sont fournies ainsi que plusieurs outils (Parseur, Lexeur) selon les langages.
L'on vous founis aussi le code de certains programmes écris en Mpire ainsi que leur
sortie attendue. Ceux-ci vous permettront de tester votre interpreteur. Par contre rien
ne vous empêche d'écrire vous même des tests additionnels.

## Langage

### Syntaxe

Les fichiers de programmes sont en ASCII sur 7 bits.

Toutes les caractères <= 32 sont ignorés et considérés comme des séparateurs valides.

Les mots clés: `print`, `byte`, `println`, `while`, `if`, `read` et `not`.
Ils sont sensibles à la case, réservés et inutilisables comme identifiants (nom 
de variables)
Toutes les autres sequences de lettres (a-z, A-Z, _) sont considérés valides comme 
identifiants. Pas de chiffres.

Les séquences de chiffres sont considérés comme des nombbre littéraux.

### Programmes et [instructions|statement]
Un programme est constitué d'une séquence d'instruction.

#### Assignations

Syntaxe: `*identifiant* = *valeur*`

Exemples:

~~~
a = 5
foo = a + 5
~~~

#### Affichage

Syntaxes: `print *chaine*` ou `print [byte] valeur` ou `println`

exemples:

~~~
print "hello"
print 42
print byte 42
println
~~~

#### Séquences

Les séquences d'instructions sont exécutés en ordre.

Exemples:

~~~
a = 1 print "a=" print a println
a=1print"a="print a println
~~~

Plusieurs instructions peuvent être groupées avec des parentèses

~~~
(a = 1 print "a=" print a println)
~~~

#### Tant que

Syntaxe: `while *condition* *instruction*`

Exemple:

~~~
a = 5
while a>0 (print "*" a = a - 1)
~~~

#### Si

Syntaxe: `if *condition* *instruction* [else *instruction*]`

Exemple:

~~~
a = 5
if a > 0 print "ok"
if a < 0 print "fail"
if a = 5 print "ok" else print "fail"
~~~

### Valeurs

Les valeurs sont des entiers signés avec au moins 16 bits de précision.

#### Littéraux

Représentation habituelle en décimaux oubien en caractères ASCII 7 bits (avec 
le code ASCII)

#### Variables

La portée des variables est globale.
Le comportement de l'utilisation d'une variable non-définie est non-défini.

#### Opérations arithmétiques de base

* Opérateurs binaires infix + - * /
* Opérateur unaire - pour la négation
* Parantèses pour le groupement et la priorité
* Priorité des opérations habituelle

#### Lecture

Syntaxe `read` et `read byte`

### Conditions

#### Comparaison

Syntaxe: `*valeur* [*op* *valeur*]+`

Où op est un des symboles de comparaison suivant: `= != < <= > >=`

Exemples:

~~~
a = 1
b = 2
if a = 1 != b < 4 print "ok"
if a = 1 != b = 4 print "fail"
~~~

#### Boolean operations

Les trois opérateurs booléens `||`, `&&` et `not` peuvent être utilisés.
`||` étant le moins prioritaire et `not` etant le plus prioritaire.
Les parentèses peuvent être utilisés pour le groupement et la priorité.

Exemples:

~~~
a = 5
if a > 2 && a < 7 print "ok"
if not (a < 2 || a > 7) print "ok"
~~~

## Spécificitées techniques

Vous pouvez faire votre interpreteur en Java, en Python ou en Ruby. Referez-vous à la sous-section correspondante pour
connaître les détails techniques à suivre pour le développement.

### Java

SableCC Lit une grammaire `*.sablecc` et vous génère un squelette dans `language_*`.
Pour l'utiliser:

```
sablecc mpire.sablecc
```

Vous aurez alors une série de classes de générées dans `language_mpire`.

#### Grammaire

Le fichier `mpire.sablecc` est ce qui défini la grammaire de votre langage. Un squelette de départ vous est fourni. Il
suffit d'y introduire les nouveaux éléments de votre grammaire et de relancer SableCC. Il vous génèrera la version
mise-à-jour de vos classes representant votre langage.

Voici une version commentée du squelette de départ:
```
/* Grammar of a mini procedural programming language */
Language mpire; // Le nom de votre langage est défini ici

Lexer

/* Ici, on definit les types de jetons qui pourront etre utilises. 
 * Ils sont définis à l'aide d'expressions regulières de base.
 * Ils peuvent etre recursifs.
 * Vous pouvez en definir d'autres.
 * Les caracteres de controle (\n) sont definis avec leur valeur ascii: \n == #10
 */

l = 'a'..'z'|'A'..'Z'|'_';
d = '0'..'9';
id = l (l|d)*;
int = d+;
char = '\'' Any;
str = '"' (Any - '"')* '"';
comment = '//' (Any - #10)* #10?;
blank = ' ' | #10 | #9 | comment;

Ignored blank; // On s'assure que les espaces blancs ne sont pas transformés en jetons

Parser

/*
 * Un noeud `prog` est consitué d'un noeud `stmt` suivi d'un noeud `prog` oubien
 * tout simplement un seul noeud `stmt`
 */

prog = stmt prog | stmt; 

/*
 * Pour nommer un type de noeud stmt, on peut le specifier manuellement avec {nom:}
 * Ceci rendra plus simple la tâche de trouver quel noeud de votre AST correspond à
 * quel élément de votre grammaire.
 *
 * On peut spécifier la composition des noeuds avec soit d'autres noeuds ou des littéraux
 * Exemple: Ìci le noeud stmt_print est composé de la chaîne de caractères 'print' 
 *          suivi d'un noeud expr
 */

stmt = 
	{print:} 'print' expr |
	{printstr:} 'print' str |
	{stmts:} '(' prog ')' ;


/*
 * C'est également dans la partie Parser que vous faites référence à vos différents jetons
 * définis dans la parti Lexer.
 * 
 * NB: À titre d'exemple, un noeud `expr` peut être un token `int` oubien rien.
 */

expr = 
	{int:} int |
	;

```

#### Interpreteur

Ce n'est pas tout de spécifier comment parser un langage, il faut aussi faire quelque 
chose avec. SableCC vous construit automatiquement un générateur d'arbre syntaxique 
abstrait (AST). Il vous fourni aussi un visiteur de base pour parcourir cet arbre.
Bien sûr, il ne fait rien à part parcourir l'arbre. Vous devrez donc implémenter 
les différents comportements de votre visiteur sur chaque noeud de l'AST de vos programmes.

Nous vous avons fourni une classe Interpret. Elle est une sous-classe de Walker 
(générée par SableCC). C'est dans cette classe qu'il faudra surcharger les méthodes de base
du visiteur de votre AST. Les méthodes à surcharger sont les methodes `case*` de `Walker`. Elles définissent le comportement dans le cas où votre visiteur rencontre un noeud de 
ce type.

Voici alors une version commentée du squelette Interpret:
``` java
package language_mpire;

import java.util.*;
import java.io.*;

public class Interpret extends Walker {

	// Dans un interpreteur, vous devez émuler la pile d'exécution
	private Stack<Integer> interpret_stack = new Stack<Integer>();

	public void caseInt(NInt node) {
		/*
		 * On lit le texte du jeton int et on le parse en entier.
		 * On le place ensuite sur la pile.
		 */
		interpret_stack.push(Integer.parseInt(node.getText()));
	}

	public void caseStmt_Print(NStmt_Print node) {
		/*
		 * On accède à l'enfant `expr` de node et on le visite.
		 * Voir Note1 pour des détails sur la visite
		 * 
		 * On prend le résultat de l'`expr` de la pile et on l'affiche
		 */
		node.get_Expr().apply(this);
		System.out.println(this.interpret_stack.pop());
	}

	public void caseStmt_Printstr(NStmt_Printstr node) {
		/*
		 * On accède à l'enfant `str` de node
		 * On accède à son contenu texte
		 * On retire les guillemets (sans blague, il faut le faire)
		 * Et on affiche le resultat
		 */
		NStr childNode = node.get_Str();
		String str = childNode.getText();
		str = str.substring(1, str.length()-1);

		System.out.print(str);
	}

	public static void main(String[] args)
		throws Exception {
			/*
			 * Vous ne devriez pas avoir à modifier le `main` à moins d'être spéciaux
			 */

		Reader in;

		if(args.length > 0) {
			in = new FileReader(args[0]);
		}
		else {
			in = new InputStreamReader(System.in);
		}

		// On construit l'AST
		Node syntaxTree = new Parser(in).parse();
		// On lance le visiteur sur l'AST
		syntaxTree.apply(new Interpret());
	}

}

```
##### Note1
La visite se fait par `Double Dispatch`. C'est ce qui permet d'avoir un comportement
différent selon le type de noeud rencontré. Ceci vous permet d'avoir toutes vos méthodes
pour traiter les différents neouds dans votre classe Interpret. Les différentes classes Noeud
savent quelle méthode d'Interpret doit être appellée sur elles-même. C'est ce qui explique
la convention d'appel suivante:
``` java
node.get_ChildX().apply(this);
```
Cette ligne lance simplement la visite sur l'enfant de type `ChildX` de node.

##### Protip1
Il est fortement suggéré de regarder le code des différentes classes de Noeuds générées
par SableCC. Les attributs à l'intérieur de celles-ci sont importants à la réalisation
de votre interpreteur.

### Python

TODO

### Ruby

TODO



## Remise
 * Remettez le repertoire `src` en entier.
 * Assurez-vous que votre grammaire (`mpire.sablecc`) soit à jour puisqu'elle sera recompilée à la correction.
 * Fournissez un `README` expliquant quel fichier est:
	 - Votre choix de langage
   - Votre grammaire
	 - Votre interpreteur


## Annexe
### Patron Visiteur
#### Wikipedia:
##### Principe
Ce modèle de conception permet à une classe externe d'être informée du type exact d'instances d'un ensemble de classes.
Cela permet de mettre en place un traitement adapté aux détails publics des objets en cause. Par exemple un visiteur est
idéal pour réaliser un rapport.

Déporter des opérations contenues dans une classe vers une autre peut sembler mauvais au sens de la POO car l'ajout ou
la modification d'une classe n’entraîne pas l'adaptation des visiteurs existants, ce modèle est utile lorsqu'on a un
ensemble de classes fermées (par exemple fourni par un tiers) et que l'on veut effectuer un nouveau traitement sur ces
classes.

En pratique, le modèle de conception visiteur est réalisé de la façon suivante : chaque classe pouvant être « visitée »
doit mettre à disposition une méthode publique « accepter » prenant comme argument un objet du type « visiteur ». La
méthode « accepter » appellera la méthode « visite » de l'objet du type « visiteur » avec pour argument l'objet visité.
De cette manière, un objet visiteur pourra connaître la référence de l'objet visité et appeler ses méthodes publiques
pour obtenir les données nécessaires au traitement à effectuer (calcul, génération de rapport, etc.).

En pratique un visiteur permet d'obtenir le même effet que d'ajouter une nouvelle méthode virtuelle à un ensemble de
classe qui ne le permet pas.

```
interface MonVisiteur {
	void visit(ObjetPere objet);
}

interface ObjetPere {
	void accept(MonVisiteur v);
}

public class Objet1 implements ObjetPere {	
	public void accept(MonVisiteur v) {
		v.visit(this);
	}
}

public class Objet2 implements ObjetPere {	
	public void accept(MonVisiteur v) {
		v.visit(this);
	}
}

public class Objet3 implements ObjetPere {	
	public void accept(MonVisiteur v) {
		v.visit(this);
	}
}
```
