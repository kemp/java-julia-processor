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

public class MathCoupling {
	Token token;
	Object oc1, oc2;

	public MathCoupling(Token t, Object o1, Object o2) {
		token = t;
		oc1 = o1;
		oc2 = o2;
	}
	
	public void printGrammar() {
		System.out.println("<binary_expression> -> <arithmetic_op> <arithmetic_expression> <arithmetic_expression>");
		if (token.getType() == TokenType.EXP_OP) {
			System.out.println("<arithmetic_op> -> exp_operator");
		} 
		else if (token.getType() == TokenType.MUL_OP) {
			System.out.println("<arithmetic_op> -> mul_operator");
		} 
		else if (token.getType() == TokenType.DIV_OP) {
			System.out.println("<arithmetic_op> -> div_operator");
		} 
		else if (token.getType() ==TokenType.ADD_OP) {
			System.out.println("<arithmetic_op> -> add_operator");
		} 
		else if (token.getType() == TokenType.SUB_OP) {
			System.out.println("<arithmetic_op> -> sub_operator");
		} 
		else if (token.getType() == TokenType.REV_DIV_OP) {
			System.out.println("<arithmetic_op> -> rev_div_operator");
		} 
		else if (token.getType() == TokenType.MOD_OP) {
			System.out.println("<arithmetic_op> -> mod_operator");
		}
		
		if(oc1 instanceof ValueCoupling && oc2 instanceof ValueCoupling) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() + "\n<arithmetic_expression> -> " 
					+ ((ValueCoupling) oc2).valueType());
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			((ValueCoupling) oc1).printGrammar();
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof MathCoupling && oc2 instanceof ValueCoupling) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " 
					+ ((ValueCoupling) oc2).valueType());
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			((MathCoupling) oc1).printGrammar();
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof ValueCoupling && oc2 instanceof MathCoupling) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() 
					+ "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			((ValueCoupling) oc1).printGrammar();
			((MathCoupling) oc2).printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			((MathCoupling) oc1).printGrammar();
			((MathCoupling) oc2).printGrammar();
		}
	}
}
