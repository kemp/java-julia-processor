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
import java.util.ArrayList;

public class Parser {
	private ArrayList<Object> tokens;
	public Parser(ArrayList<Object> t) {
		tokens = t;
	}
	
	/* This method will iterate through the token list and replace all the token with coupled 
	 * values and statements in order to output the proper grammar. This should also
	 * handle some form of error handling in order to make sure that the program will run 
	 * correctly.  
	 */
	public void parse() { // set return type to that of ArrayList<Object> once the parse is "Completed"
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.INT_CONSTANT || ((Token) tokens.get(i)).getType() == TokenType.IDENTIFIER) { // Literal Int or Identifier
					ValueCoupling value = new ValueCoupling((Token) tokens.get(i));
					tokens.set(i, value);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if((tokens.get(i +1) instanceof ValueCoupling || tokens.get(i +1) instanceof MathCoupling)
						&& (tokens.get(i + 2) instanceof ValueCoupling || tokens.get(i + 2) instanceof MathCoupling)) {
					if(((Token) tokens.get(i)).getType() == TokenType.EXP_OP) { // Exponent op
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 2);
						/* Create a MathCoupling using the operator and two following operands then replace in arraylist
						 * Also ensure that the following operands are valid options for exponentiation and if not
						 * output an error to the console and stop parsing.
						 */
					}
				}
				else {
					// make call to errorOutput or directly output error
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.MUL_OP) { //multiply op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.DIV_OP) { //divide op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.REV_DIV_OP) { // reverse divide op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.MOD_OP) { // modulo op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.ADD_OP) { //add op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.SUB_OP) { //subtract op
					MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1), tokens.get(i + 2));
					tokens.set(i, coupling);
					tokens.remove(i + 1);
					tokens.remove(i + 2);
				}
			}
		}
		
		for (int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i) instanceof Token) {
				if(((Token) tokens.get(i)).getType() == TokenType.LT_OP) { //lt op
					
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.GT_OP) { //gt op
					
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.NE_OP) { //not eq op
					
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.EQ_OP) { //eq op
					
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.GE_OP) {//ge op
					
				}
				else if(((Token) tokens.get(i)).getType() == TokenType.LE_OP) { //le op
					
				}
			}
		}
		
		// Assignment and Print statements
		
		// Loops and if statements
		
		//return completed arraylist;
	}
	
	private void errorOutput() {
		// call to this when incorrect syntax is found
	}
	
	public void printGrammar() {
		// Method for printing the grammar of the program.
	}
}
