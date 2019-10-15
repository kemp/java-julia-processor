package me.javajuliaparser;

import java.io.PrintStream;

class Scanner {
    private PrintStream out;

    Scanner(PrintStream printStream) {
        this.out = printStream;
    }

    void scan(String input) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(out);
        lexicalAnalyzer.analyze(input);

        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(out);
        syntaxAnalyzer.analyze(input);
    }
}
