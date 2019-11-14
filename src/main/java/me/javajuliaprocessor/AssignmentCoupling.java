/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

public class AssignmentCoupling extends Coupling {
	Token token;
	ValueCoupling vc1, vc2 = null;
	MathCoupling mc = null;
	
	public AssignmentCoupling(Token t, ValueCoupling v1, ValueCoupling v2){
		token = t;
		vc1 = v1;
		vc2 = v2;
	}
	public AssignmentCoupling(Token t, ValueCoupling v1, MathCoupling m){
		token = t;
		vc1 = v1;
		mc = m;
	}
	
	public void printGrammar() {
		System.out.println("<assignment_statement> -> id <assignment_operator> <arithmetic_expression>");
		vc1.printGrammar();
		System.out.println(token.getLexeme() + " -> <assignment_operator>");
		if(vc2 != null) { // arithmetic expression is a literal integer or id 
			System.out.println("<arithmetic_expression> ->" + vc2.valueType());
			vc2.printGrammar();
		}
		else { // arithmetic expression is a binary expression
			System.out.println("<arithmetic_expression> -> <binary_expression>");
			mc.printGrammar();
		}
	}
}
