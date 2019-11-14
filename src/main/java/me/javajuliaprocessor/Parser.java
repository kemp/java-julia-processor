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

public class Parser {
	private ArrayList<Token> tokens;
	public Parser(ArrayList<Token> t) {
		tokens = t;
	}
	
	/* This method will iterate through the token list and replace all the token with coupled 
	 * values and statements in order to output the proper grammar. This should also
	 * handle some form of error handling in order to make sure that the program will run 
	 * correctly.  
	 */
	public void parse() { // set return type to that of TokenOrCouplingList
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.INT_CONSTANT || ((Token) tokens.get(i)).getType() == TokenType.IDENTIFIER) { // Literal Int or Identifier
					ValueCoupling value = new ValueCoupling((Token) tokens.get(i));
					tokens.set(i, value);
					// Create a value coupling object and replace the original in the arraylist with the coupling
				}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.EXP_OP) { // Exponent op
					/* Create a MathCoupling using the operator and two following operands then replace in arraylist
					 * Also ensure that the following operands are valid options for exponentiation and if not
					 * output an error to the console and stop parsing.
					 */
				}
		}
<<<<<<< HEAD
<<<<<<< HEAD
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.MUL_OP) {
					//multiply op
				}
=======
=======
>>>>>>> parent of 0ebd893... Add generic Coupling, TokenOrCoupling (and list)
		for(Token token : tokens) {
			if(token.getType() == TokenType.MUL_OP) {
				//multiply op
			}
>>>>>>> parent of 0ebd893... Add generic Coupling, TokenOrCoupling (and list)
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.DIV_OP) {
					//divide op
				}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.REV_DIV_OP) {
					// reverse divide op
				}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.MOD_OP) {
					// modulo op
				}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.ADD_OP) {
					//add op
				}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token)
				if(((Token) tokens.get(i)).getType() == TokenType.SUB_OP) {
					//subtract op
				}
		}
		
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.LT_OP) {
					//lt op
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.GT_OP) {
					//gt op
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.NE_OP) {
					//not eq op
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.EQ_OP) {
					//eq op
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.GE_OP) {
					//ge op
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.LE_OP) {
					//le op
				}
			}
		}
		
		// For each for loops and if statements
	}
	
	public void printGrammar() {
		// Method for printing the grammar of the program.
	}
}
