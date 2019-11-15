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

public class BooleanCoupling {
	Token token;
	Object oc1, oc2;
	public BooleanCoupling(Token t, Object o1, Object o2) {
		token = t;
		oc1 = o1;
		oc2 = o2;
	}
	
	public void printGrammar(){
		System.out.println("<boolean_expression> -> <relative_op> <arithmetic_expression> <arithmetic_expression>");
		if (token.getType() == TokenType.LT_OP) {
			System.out.println("<relative_op> -> lt_operator");
		} 
		else if (token.getType() == TokenType.GT_OP) {
			System.out.println("<relative_op> -> gt_operator");
		} 
		else if (token.getType() == TokenType.NE_OP) {
			System.out.println("<relative_op> -> ne_operator");
		}
		else if (token.getType() == TokenType.EQ_OP) {
			System.out.println("<relative_op> -> eq_operator");
		}
		else if (token.getType() == TokenType.GE_OP) {
			System.out.println("<relative_op> -> ge_operator");
		}
		else if (token.getType() == TokenType.LE_OP) {
			System.out.println("<relative_op> -> le_operator");
		}
		
		if(oc1 instanceof ValueCoupling && oc2 instanceof ValueCoupling) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() + "\n<arithmetic_expression> -> "
					+ ((ValueCoupling) oc2).valueType());
			System.out.println(token.getLexeme() + " -> <relative_op>");
			((ValueCoupling) oc1).printGrammar();
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof MathCoupling && oc2 instanceof ValueCoupling) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " 
					+ ((ValueCoupling) oc2).valueType());
			System.out.println(token.getLexeme() + " -> <relative_op>");
			((MathCoupling) oc1).printGrammar();
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof ValueCoupling && oc2 instanceof MathCoupling) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() 
					+ "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <reletive_op>");
			((ValueCoupling) oc1).printGrammar();
			((MathCoupling) oc2).printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <reletive_op>");
			((MathCoupling) oc1).printGrammar();
			((MathCoupling) oc2).printGrammar();
		}
	}
}
