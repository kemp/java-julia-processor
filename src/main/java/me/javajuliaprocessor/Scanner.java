/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package main.java.me.javajuliaprocessor;

import java.util.List;

class Scanner {

    TokenList scan(List<String> lines) throws UnknownTokenException {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        int lineNum = 1;

        try {
            TokenList tokens = new TokenList();

            for (String line : lines) {
                // Add all of the analyzed tokens to the list.
                tokens.addAll(lexicalAnalyzer.analyzeLine(line));

                lineNum++;
            }

            // Scanning complete!
            return tokens;
        } catch (UnknownTokenException e) {
            throw new UnknownTokenException(e.getMessage() + " at line #" + lineNum);
        }
    }
}
