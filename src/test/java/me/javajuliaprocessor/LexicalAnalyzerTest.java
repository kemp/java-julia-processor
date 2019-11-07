/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class LexicalAnalyzerTest {

    @Test
    void analyzeCompleteStatement() throws UnknownTokenException {
        String input = "a = a + 1";

        TokenList expectedOutput = new TokenList();

        expectedOutput.add(new Token(TokenType.IDENTIFIER, "a"));
        expectedOutput.add(new Token(TokenType.ASSIGN_OP, "="));
        expectedOutput.add(new Token(TokenType.IDENTIFIER, "a"));
        expectedOutput.add(new Token(TokenType.PLUS_OP, "+"));
        expectedOutput.add(new Token(TokenType.INT_CONSTANT, "1"));

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer();
        TokenList actualOutput = lexicalAnalyzer.analyzeLine(input);

        assertEquals(expectedOutput, actualOutput);
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
        TokenList expectedOutput = new TokenList();

        Token expectedToken = new Token(tokenType, input);

        expectedOutput.add(expectedToken);

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer();
        TokenList actualOutput = lexicalAnalyzer.analyzeLine(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1.jl.txt", "test2.jl.txt", "test3.jl.txt", "test4.jl.txt",
            "test5.jl.txt", "test6.jl.txt", "test7.jl.txt", "test8.jl.txt", "test9.jl.txt",
            "test10.jl.txt", "test11.jl.txt", "test12.jl.txt"})
    void testItScansAllTestFiles (String fileName) throws IOException {
        InputStream inputStream = LexicalAnalyzerTest.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

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