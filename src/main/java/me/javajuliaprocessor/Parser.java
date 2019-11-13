/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import java.util.ArrayList;

public class Parser {
	private ArrayList<Token> tokens;
	public Parser(TokenList t) {
		tokens = t;
	}
	
	/* This method will iterate through the token list and replace all the token with coupled 
	 * values and statements in order to output the proper grammar. This should also
	 * handle some form of error handling in order to make sure that the program will run 
	 * correctly.  
	 */
	public void parse() {
		// Finding all integers and identifiers and replacing them with a value coupling
		for(Token token : tokens) {
			if(token.getType() == TokenType.INT_CONSTANT || token.getType() == TokenType.IDENTIFIER) { // Literal Int or Identifier
				ValueCoupling value = new ValueCoupling(token);
				// Create a value coupling object and replace the original in the arraylist with the coupling
			}
		}
		// Finding all the math operations !!! Need to add parenthesis !!!
		for(Token token : tokens) {
			if(token.getType() == TokenType.POWER_OP) { // Exponent op
				/* Create a MathCoupling using the operator and two following operands then replace in arraylist
				 * Also ensure that the following operands are valid options for exponentiation and if not
				 * output an error to the console and stop parsing.
				 */
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.MULT_OP) {
				//multiply op
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.DIV_OP) {
				//divide op
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.REV_DIV_OP) {
				// reverse divide op
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.MOD_OP) {
				// modulo op
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.PLUS_OP) {
				//add op
			}
		}
		for(Token token : tokens) {
			if(token.getType() == TokenType.MINUS_OP) {
				//subtract op
			}
		}
		
		// Additional for each for boolean expressions
		for(Token token : tokens) {
			if(token.getType() == TokenType.LT_OP) {
				//lt op
			}
			else if(token.getType() == TokenType.GT_OP) {
				//gt op
			}
			else if(token.getType() == TokenType.NOT_EQ_OP) {
				//not eq op
			}
		}
		// For each for assignment and print statements
		
		// For each for loops and if statements
	}
	
	public void printGrammar() {
		// Method for printing the grammar of the program.
	}
}
