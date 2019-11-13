/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

public class MathCoupling {
	Token token;
	ValueCoupling vc1 = null, vc2 = null;
	MathCoupling mc1 = null, mc2 = null;
	// Overloaded Constructors for all four possibilities of math coupling.
	public MathCoupling(Token t, ValueCoupling o1, ValueCoupling o2) {
		token = t;
		vc1 = o1;
		vc2 = o2;
	}
	public MathCoupling(Token t, MathCoupling o1, ValueCoupling o2) {
		token = t;
		mc1 = o1;
		vc2 = o2;
	}
	public MathCoupling(Token t, ValueCoupling o1, MathCoupling o2) {
		token = t;
		vc1 = o1;
		mc2 = o2;
	}
	public MathCoupling(Token t, MathCoupling o1, MathCoupling o2) {
		token = t;
		mc1 = o1;
		mc2 = o2;
	}
	
	public void printGrammar() {
		System.out.println("<binary_expression> -> <arithmetic_op> <arithmetic_expression> <arithmetic_expression>");
		switch(token.getType().getId()) {
		case 5021: // Exponent
			System.out.println("<arithmetic_op> -> exp_operator"); break;
		case 5009: // Multiply
			System.out.println("<arithmetic_op> -> mul_operator"); break;
		case 5010: // Divide
			System.out.println("<arithmetic_op> -> div_operator"); break;
		case 5006: // Add
			System.out.println("<arithmetic_op> -> add_operator"); break;
		case 5008: // Subtract
			System.out.println("<arithmetic_op> -> sub_operator"); break;
		case 5024: // Reverse Divide
			System.out.println("<arithmetic_op> -> rev_div_operator"); break;
		case 5020: // Modulo
			System.out.println("<arithmetic_op> -> mod_operator"); break;
		}
		if(vc1 != null && vc2 != null) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> " + vc2.valueType());
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			vc1.printGrammar();
			vc2.printGrammar();
		}
		else if(mc1 != null && vc2 != null) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " + vc2.valueType());
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			mc1.printGrammar();
			vc2.printGrammar();
		}
		else if(vc1 != null && mc2 != null) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			vc1.printGrammar();
			mc2.printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(token.getLexeme() + " -> <arithmetic_op>");
			mc1.printGrammar();
			mc2.printGrammar();
		}
	}
}
