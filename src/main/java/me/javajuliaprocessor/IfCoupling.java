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
	Token iftoken, elsetoken, endtoken;
	BooleanCoupling bc;
	ArrayList<Token> block1, block2;
	Parser block1parse, block2parse;
	public IfCoupling(Token ift, Token elst, Token endt, BooleanCoupling bc1, ArrayList<Token> b1, ArrayList<Token> b2) {
		iftoken = ift;
		elsetoken = elst;
		endtoken = endt;
		bc = bc1;
		block1 = b1;
		block2 = b2;
	}
	
	private void blockParse() {
		block1parse = new Parser(block1);
		//block1 = parse.parse();
		block2parse = new Parser(block2);
		//block2 = parse.parse();
	}
	
	public void printGrammar() {
		blockParse();
		System.out.println("<if_statement> -> if <boolean_expression> <block> else <block> end");
		System.out.println("if -> if");
		bc.printGrammar();
		block1parse.printGrammar();
		System.out.println("else -> else");
		block2parse.printGrammar();
		System.out.println("end -> end");
	}
}
