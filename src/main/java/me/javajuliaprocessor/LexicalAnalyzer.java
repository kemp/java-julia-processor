package me.javajuliaprocessor;

import java.io.PrintStream;

class LexicalAnalyzer {
    private PrintStream out;

    LexicalAnalyzer(PrintStream printStream) {
        this.out = printStream;
    }

    void analyze(String input) throws UnknownTokenException {
        input = input.trim();

        if (input.length() > 0) {
            // Get the next token...
            Token token = Token.fromString(input);

            out.println("Next token is: " + token.getType().getId() + "\t\tNext lexeme is: " + token.getLexeme());

            // Analyze the next token
            analyze(input.substring(token.getLexeme().length()));
        }
    }
}
