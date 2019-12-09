/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Steven Kemp, Cody Ziegler
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 1 Scanner - Java
 */

package me.javajuliaprocessor;

import java.io.PrintStream;
import java.util.List;

class Scanner {
    private PrintStream out;

    Scanner(PrintStream printStream) {
        this.out = printStream;
    }

    void scan(List<String> lines) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(out);

        int lineNum = 1;

        try {
            for (String line : lines) {
                lexicalAnalyzer.analyzeLine(line);

                lineNum++;
            }

            out.println("Lexical analysis complete!");
        } catch (UnknownTokenException e) {
            out.println(e.getMessage() + " at line #" + lineNum);
        }
    }
}
