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
            "IDENTIFIER, A",
            "INT_CONSTANT, 3",

            "ASSIGN_OP, =",
            "LT_OP, <",
            "GT_OP, >",
            "LE_OP, <=",
            "GE_OP, >=",
            "EQ_OP, ==",
            "NE_OP, !=",
            "ADD_OP, +",
            "SUB_OP, -",
            "MUL_OP, *",
            "DIV_OP, /",
            "MOD_OP, %",
            "REV_DIV_OP, \\",
            "EXP_OP, ^",

            "IF, if",
            "ELSE, else",
            "WHILE, while",
            "FOR, for",
            "END, end",
            "LEFT_PAREN, (",
            "RIGHT_PAREN, )",

            "ITERATOR, :",
            "PRINT, print",
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