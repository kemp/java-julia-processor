/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor.scanner;

import me.javajuliaprocessor.scanner.TokenType;
import me.javajuliaprocessor.scanner.UnknownTokenTypeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TokenTypeTest {

    @ParameterizedTest
    @CsvSource({
        "INT_CONSTANT, 1",
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
    void testFromCharacter(TokenType tokenType, String string) {
        try {
            TokenType t = TokenType.fromLexeme(string);
            assertEquals(tokenType, t);
        } catch (UnknownTokenTypeException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void unknownTokenTypesThrowAnException() {
        Exception e = assertThrows(UnknownTokenTypeException.class, () -> {
            TokenType.fromLexeme("###INVALID###");
        });
    }
}