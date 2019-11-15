/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;
import me.javajuliaprocessor.scanner.TokenType;

public class ValueCoupling {
	Token token;
	public ValueCoupling(Token t) {
		token = t;
	}
	
	public String valueType() {
		if(token.getType() == TokenType.INT_CONSTANT)
			return "<literal_integer>";
		else
			return "<id>";
	}
	
	public void printGrammar() {
		if(token.getType() == TokenType.INT_CONSTANT) {
			System.out.println(token.getLexeme() + " -> <literal_integer>");
		}
		else if(token.getType() == TokenType.IDENTIFIER) {
			System.out.println(token.getLexeme() + " -> <id>");
		}
	}
}
