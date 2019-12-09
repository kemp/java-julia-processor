/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Steven Kemp, Cody Ziegler
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 1 Scanner - Java
 */

package me.javajuliaprocessor;

import java.io.PrintStream;

class LexicalAnalyzer {
    private PrintStream out;

    LexicalAnalyzer(PrintStream printStream) {
        this.out = printStream;
    }

    void analyzeLine(String input) throws UnknownTokenException {
        input = input.trim();

        if (input.length() > 0 && !input.startsWith("#")) {
            // Get the next token...
            Token token = Token.fromString(input);

            out.println("Next token is: " + token.getType().getId() + "\t\tNext lexeme is: " + token.getLexeme());

            // Analyze the next token
            analyzeLine(input.substring(token.getLexeme().length()));
        }
    }
}
