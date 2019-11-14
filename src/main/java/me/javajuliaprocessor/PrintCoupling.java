/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

public class PrintCoupling extends Coupling {
	Token token;
	ValueCoupling vc = null;
	MathCoupling mc = null;
	
	public PrintCoupling(Token t, ValueCoupling v) {
		token = t;
		vc = v;
	}
	public PrintCoupling(Token t, MathCoupling m) {
		token = t;
		mc = m;
	}
	
	public void PrintGrammar() {
		System.out.println("<print_statement> -> print(<arithmetic_expression>)");
		if(vc != null) { // arithmetic expression was a literal integer or an identifier
			System.out.println("<arithmetic_exprssion> -> " + vc.valueType());
			vc.printGrammar();
		}
		else{ // arithmetic expression was a binary expression
			System.out.println("<arithmetic_expression> -> <binary_expression>");
			mc.printGrammar();
		}
	}
}
