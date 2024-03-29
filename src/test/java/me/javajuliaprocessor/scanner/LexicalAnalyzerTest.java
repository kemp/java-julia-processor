/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor.scanner;

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

        expectedOutput.add(new Token(TokenType.IDENTIFIER, "a", 0));
        expectedOutput.add(new Token(TokenType.ASSIGN_OP, "=", 0));
        expectedOutput.add(new Token(TokenType.IDENTIFIER, "a", 0));
        expectedOutput.add(new Token(TokenType.ADD_OP, "+", 0));
        expectedOutput.add(new Token(TokenType.INT_CONSTANT, "1", 0));

        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer();
        TokenList actualOutput = lexicalAnalyzer.analyzeLine(input, 0);

        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1.jl", "test2.jl", "test3.jl", "test4.jl"})
    void testItScansAllTestFiles (String fileName) throws IOException {
        InputStream inputStream = LexicalAnalyzerTest.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        for (String line; (line = reader.readLine()) != null;) {
            // Process line
            try {
                lexicalAnalyzer.analyzeLine(line, 0);
            } catch (UnknownTokenException e) {
                fail(e.getMessage());
            }
        }

    }
}