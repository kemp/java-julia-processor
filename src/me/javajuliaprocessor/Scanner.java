package me.javajuliaprocessor;

import java.io.PrintStream;

class Scanner {
    private PrintStream out;

    Scanner(PrintStream printStream) {
        this.out = printStream;
    }

    void scan(String input) {
        try {
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(out);
            lexicalAnalyzer.analyze(input);
            out.println("Lexical analysis complete!");

//            SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(out);
//            syntaxAnalyzer.analyze(input);
//            out.println("Syntax analysis complete!");
        } catch (UnknownTokenException e) {
            out.println(e.getMessage());
        }
    }
}
