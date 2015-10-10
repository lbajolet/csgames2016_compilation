package language_mpire;

import java.util.*;
import java.io.*;

public class Interpret extends Walker {

	private Stack<Integer> interpret_stack = new Stack<Integer>();

	public void caseInt(NInt node) {
		interpret_stack.push(Integer.parseInt(node.getText()));
	}

	public void caseStmt_Print(NStmt_Print node) {
		node.get_Expr().apply(this);
		System.out.println(this.interpret_stack.pop());
	}

	public void caseStmt_Printstr(NStmt_Printstr node) {

		NStr childNode = node.get_Str();
		String str = childNode.getText();
		str = str.substring(1, str.length()-1);

		System.out.print(str);
	}

	public void caseStmt_Stmts(NStmt_Stmts node) {
		defaultCase(node);
	}

	public static void main(String[] args)
		throws Exception {

		Reader in;

		if(args.length > 0) {
			in = new FileReader(args[0]);
		}
		else {
			in = new InputStreamReader(System.in);
		}

		Node syntaxTree = new Parser(in).parse();
		syntaxTree.apply(new Interpret());
	}

}
