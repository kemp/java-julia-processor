/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

public class WhileCoupling {
	Token whileToken, endToken;
	BooleanCoupling bc;
	TokenOrCouplingList block;
	Parser blockParse;
	public WhileCoupling(Token wt, Token et, BooleanCoupling bc1, TokenOrCouplingList b) {
		whileToken = wt;
		endToken = et;
		bc = bc1;
		block = b;
	}
	
	private void blockParse() {
		blockParse = new Parser(block);
		//block = blockParse.parse();
	}
	
	public void printGrammar() {
		blockParse();
		System.out.println("<while_statement> -> while <boolean_expression> <block> end");
		System.out.println("while -> while");
		bc.printGrammar();
		blockParse.printGrammar();
		System.out.println("end -> end");
	}
}
