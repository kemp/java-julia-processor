/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package main.java.me.javajuliaprocessor;

public class BooleanCoupling {
	int token;
	String lexeme;
	ValueCoupling vc1 = null, vc2 = null;
	MathCoupling mc1 = null, mc2 = null;
	
	// Overloaded Constructors for all four possibilities of boolean coupling.
	public BooleanCoupling(int t, String s, ValueCoupling o1, ValueCoupling o2) {
		token = t;
		lexeme = s;
		vc1 = o1;
		vc2 = o2;
	}
	public BooleanCoupling(int t, String s, MathCoupling o1, ValueCoupling o2) {
		token = t;
		lexeme = s;
		mc1 = o1;
		vc2 = o2;
	}
	public BooleanCoupling(int t, String s, ValueCoupling o1, MathCoupling o2) {
		token = t;
		lexeme = s;
		vc1 = o1;
		mc2 = o2;
	}
	public BooleanCoupling(int t, String s, MathCoupling o1, MathCoupling o2) {
		token = t;
		lexeme = s;
		mc1 = o1;
		mc2 = o2;
	}
	
	public void printGrammar(){
		System.out.println("<boolean_expression> -> <relative_op> <arithmetic_expression> <arithmetic_expression>");
		switch(token) {
		case 5015: // Less Than op
			System.out.println("<relative_op> -> lt_operator"); break;
		case 5016: // Greater Than op
			System.out.println("<relative_op> -> gt_operator"); break;
		case 5017: // Not Equal op
			System.out.println("<relative_op> -> ne_operator"); break;
		}
		if(vc1 != null && vc2 != null) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> " + vc2.valueType());
			System.out.println(lexeme + " -> <relative_op>");
			vc1.printGrammar();
			vc2.printGrammar();
		}
		else if(mc1 != null && vc2 != null) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " + vc2.valueType());
			System.out.println(lexeme + " -> <relative_op>");
			mc1.printGrammar();
			vc2.printGrammar();
		}
		else if(vc1 != null && mc2 != null) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(lexeme + " -> <reletive_op>");
			vc1.printGrammar();
			mc2.printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			System.out.println(lexeme + " -> <reletive_op>");
			mc1.printGrammar();
			mc2.printGrammar();
		}
	}
}
