package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class LexicalAnalyzerTest {

    @Test
    void analyzeCompleteStatement() throws UnknownTokenException {
        String input = "a = a + 1";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer(printStream);
        lexicalAnalyzer.analyzeLine(input);

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
        lexicalAnalyzer.analyzeLine(input);

        assertEquals(output, byteArrayOutputStream.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1.jl.txt", "test2.jl.txt", "test3.jl.txt", "test4.jl.txt",
            "test5.jl.txt", "test6.jl.txt", "test7.jl.txt", "test8.jl.txt", "test9.jl.txt",
            "test10.jl.txt", "test11.jl.txt", "test12.jl.txt"})
    void testTest (String fileName) throws IOException {
        InputStream inputStream = LexicalAnalyzerTest.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer(new PrintStream(byteArrayOutputStream));

        for (String line; (line = reader.readLine()) != null;) {
            // Process line
            try {
                lexicalAnalyzer.analyzeLine(line);
            } catch (UnknownTokenException e) {
                fail(e.getMessage());
            }
        }

    }
}