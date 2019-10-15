package me.javajuliaparser;

import java.io.PrintStream;

class LexicalAnalyzer {
    private PrintStream out;

    LexicalAnalyzer(PrintStream printStream) {
        this.out = printStream;
    }

    void analyze(String input) {
        if (input.length() == 0)
            out.println("Lexical Analysis Complete!");
        else {
            char i = input.charAt(0);

            // TODO: Actual Lexical analysis
            out.println("Next token is: " + 1999 + "\t\tNext lexeme is: " + i);

            analyze(input.substring(1));
        }
    }
}
