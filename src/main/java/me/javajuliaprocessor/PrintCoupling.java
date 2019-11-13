/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

public class PrintCoupling {
	int token;
	String lexeme;
	ValueCoupling vc = null;
	MathCoupling mc = null;
	
	public PrintCoupling(int t, String s, ValueCoupling v) {
		token = t;
		lexeme = s;
		vc = v;
	}
	public PrintCoupling(int t, String s, MathCoupling m) {
		token = t;
		lexeme = s;
		mc = m;
	}
	
	public void PrintGrammar() {
		System.out.println("<print_statement> -> print(<arithmetic_expression>)");
		if(vc != null) {
			System.out.println("<arithmetic_exprssion> -> " + vc.valueType());
			vc.printGrammar();
		}
		else{
			System.out.println("<arithmetic_expression> -> <binary_expression>");
			mc.printGrammar();
		}
	}
}
