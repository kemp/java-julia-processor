package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LexicalAnalyzerTest {

    @Test
    void analyzeCompleteStatement() throws UnknownTokenException {
        String input = "a = a + 1";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer(printStream);
        lexicalAnalyzer.analyze(input);

        String output = "Next token is: 5012		Next lexeme is: a\n" +
                "Next token is: 5003		Next lexeme is: =\n" +
                "Next token is: 5012		Next lexeme is: a\n" +
                "Next token is: 5006		Next lexeme is: +\n" +
                "Next token is: 5001		Next lexeme is: 1\n";

        assertEquals(output, byteArrayOutputStream.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "INT_CONSTANT, 3",
        "ASSIGN_OP, =",
        "IF_OP, if",
        "ELSE_SK, else",
        "PLUS_OP, +",
        "MINUS_OP, -",
        "MULT_OP, *",
        "DIV_OP, /",
        "ENDIF_SK, endif",
        "IDENTIFIER, A",
    })
    void analyzeEachTokenType(TokenType tokenType, String input) throws UnknownTokenException {
        String output = "Next token is: " + tokenType.getId() + "		Next lexeme is: " + input + "\n";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer(printStream);
        lexicalAnalyzer.analyze(input);

        assertEquals(output, byteArrayOutputStream.toString());
    }
}