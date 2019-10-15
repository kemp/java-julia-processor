package me.javajuliaparser;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LexicalAnalyzerTest {

    @Test
    void analyze() {
        String input = "a = a + 1";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer(printStream);
        lexicalAnalyzer.analyze(input);

        // TODO: Change to match actual output
        String output = "Next token is: 1999		Next lexeme is: a\n" +
                "Next token is: 1999		Next lexeme is:  \n" +
                "Next token is: 1999		Next lexeme is: =\n" +
                "Next token is: 1999		Next lexeme is:  \n" +
                "Next token is: 1999		Next lexeme is: a\n" +
                "Next token is: 1999		Next lexeme is:  \n" +
                "Next token is: 1999		Next lexeme is: +\n" +
                "Next token is: 1999		Next lexeme is:  \n" +
                "Next token is: 1999		Next lexeme is: 1\n" +
                "Lexical Analysis Complete!\n";

        assertEquals(output, byteArrayOutputStream.toString());
    }
}