package main.java.me.javajuliaprocessor;

public class ValueCoupling {
	int token;
	String lexeme;
	public ValueCoupling(int t, String s) {
		token = t;
		lexeme = s;
	}
	
	public void printGrammar() {
		if(token == 5001) {
			System.out.println(lexeme + "-> <literal_integer>");
		}
		else if(token == 5012) {
			System.out.println(lexeme + "-> id");
		}
	}
}
