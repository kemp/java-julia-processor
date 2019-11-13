/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package main.java.me.javajuliaprocessor;

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
			if(token.getType().getId() == 5001 || token.getType().getId() == 5012) { // Literal Int or Identifier
				ValueCoupling value = new ValueCoupling(token.getType().getId(), token.getLexeme());
				// Create a value coupling object and replace the original in the arraylist with the coupling
			}
		}
		// Finding all the math operations
		for(Token token : tokens) {
			if(token.getType().getId() == 5021) { // Exponent op
				/* Create a MathCoupling using the operator and two following operands then replace in arraylist
				 * Also ensure that the following operands are valid options for exponentiation and if not
				 * output an error to the console and stop parsing.
				 */
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5009) {
				//multiply op
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5010) {
				//divide op
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5024) {
				// reverse divide op
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5020) {
				// modulo op
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5006) {
				//add op
			}
		}
		for(Token token : tokens) {
			if(token.getType().getId() == 5008) {
				//subtract op
			}
		}
		
		// Additional for each for boolean expressions
		for(Token token : tokens) {
			switch (token.getType().getId()) {
			case 5015 : // LT OP
				break;
			case 5016 : // GT OP
				break;
			case 5017 : // Not_EQ_OP
				break;
			}
		}
		// For each for assignment and print statements
		
		// For each for loops and if statements
	}
	
	public void printGrammar() {
		// Method for printing the grammar of the program.
	}
}
