/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

public class PrintCoupling {
	Token token;
	Object oc;
	
	public PrintCoupling(Token t, Object o) {
		token = t;
		oc = o;
	}
	
	public void printGrammar() {
		System.out.println("<print_statement> -> print(<arithmetic_expression>)");
		if(oc instanceof ValueCoupling) { // arithmetic expression was a literal integer or an identifier
			System.out.println("<arithmetic_exprssion> -> " + ((ValueCoupling) oc).valueType());
			((ValueCoupling) oc).printGrammar();
		}
		else{ // arithmetic expression was a binary expression (Math)
			System.out.println("<arithmetic_expression> -> <binary_expression>");
			((MathCoupling) oc).printGrammar();
		}
	}
}
