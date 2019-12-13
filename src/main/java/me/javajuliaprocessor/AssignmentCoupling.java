/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

// Class to hold the assignment statements found in the code and output their grammar/Interpret
public class AssignmentCoupling {
	Token token;
	Object oc1, oc2;
	
	public AssignmentCoupling(Token t, Object o1, Object o2){
		token = t;
		oc1 = o1;
		oc2 = o2;
	}
	
	public void printGrammar() {
		System.out.println("<assignment_statement> -> id <assignment_operator> <arithmetic_expression>");
		((ValueCoupling) oc1).printGrammar();
		System.out.println(token.getLexeme() + " -> <assignment_operator>");
		if(oc2 instanceof ValueCoupling) { // arithmetic expression is a literal integer or id 
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc2).valueType());
			((ValueCoupling) oc2).printGrammar();
		}
		else { // arithmetic expression is a binary expression
			System.out.println("<arithmetic_expression> -> <binary_expression>");
			((MathCoupling) oc2).printGrammar();
		}
	}
	
	public Identifier interpret() {
		if(oc2 instanceof ValueCoupling) { // arithmetic expression is a literal integer or id 
			return new Identifier(((ValueCoupling) oc1).getLexeme(), ((ValueCoupling) oc2).interpret());
		}
		else { // arithmetic expression is a binary expression
			return new Identifier(((ValueCoupling) oc1).getLexeme(), ((MathCoupling) oc2).interpret());
		}
	}
}
