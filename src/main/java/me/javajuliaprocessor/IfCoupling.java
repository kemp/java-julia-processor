/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;
import java.util.ArrayList;

public class IfCoupling {
	Token ifToken, elseToken, endToken;
	Object oc;
	ArrayList<Object> block1, block2;
	Parser block1Parse, block2Parse;
	public IfCoupling(Token ift, Token elst, Token endt, Object bc1, ArrayList<Object> b1, ArrayList<Object> b2) {
		ifToken = ift;
		elseToken = elst;
		endToken = endt;
		oc = bc1;
		block1 = b1;
		block2 = b2;
	}
	
	private void blockParse() {
		block1Parse = new Parser(block1);
		block1 = block1Parse.parse();
		block2Parse = new Parser(block2);
		block2 = block2Parse.parse();
	}
	
	public void printGrammar() {
		blockParse();
		System.out.println("<if_statement> -> if <boolean_expression> <block> else <block> end");
		System.out.println("if -> if");
		((BooleanCoupling) oc).printGrammar();
		block1Parse.printGrammar();
		System.out.println("else -> else");
		block2Parse.printGrammar();
		System.out.println("end -> end");
	}
}
