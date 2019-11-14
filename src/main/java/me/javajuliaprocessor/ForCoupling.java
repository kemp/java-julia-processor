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

public class ForCoupling extends Coupling {
	Token forToken, equalToken, endToken;
	ValueCoupling id;
	IterCoupling iter;
	ArrayList<Token> block;
	Parser blockParse;
	public ForCoupling(Token ft, Token eqt, Token et, ValueCoupling vc, IterCoupling ic, ArrayList<Token> b) {
		forToken = ft;
		equalToken = eqt;
		endToken = et;
		id = vc;
		iter = ic;
		block = b;
	}
	
	private void blockParse() {
		blockParse = new Parser(block);
		//block = blockParse.parse();
	}
	
	public void printGrammar() {
		blockParse();
		System.out.println("<for_statement> -> for id = <iter> <block> end");
		System.out.println("for -> for");
		id.printGrammar();
		System.out.println("= -> <assignment_operator>");
		iter.printGrammar();
		blockParse.printGrammar();
		System.out.println("end -> end");
	}
}
