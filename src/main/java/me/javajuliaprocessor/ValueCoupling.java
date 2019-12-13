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

//Class to hold the literal integer and identifiers found in the code and output their grammar/Interpret
public class ValueCoupling {
	Token token;
	IdentifierTable it;
	public ValueCoupling(Token t, IdentifierTable i) {
		token = t;
		it = i;
	}
	
	public String valueType() {
		if(token.getType() == TokenType.INT_CONSTANT)
			return "<literal_integer>";
		else
			return "<id>";
	}
	
	public String getLexeme() {
		return token.getLexeme();
	}
	
	public void printGrammar() {
		if(token.getType() == TokenType.INT_CONSTANT) {
			System.out.println(token.getLexeme() + " -> <literal_integer>");
		}
		else if(token.getType() == TokenType.IDENTIFIER) {
			System.out.println(token.getLexeme() + " -> <id>");
		}
	}
	
	public int interpret() {
		if(token.getType() == TokenType.INT_CONSTANT)
			return Integer.parseInt(token.getLexeme());
		else
			return it.getValue(token.getLexeme(), token);
	}
}
