/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    @Test
    void unknownTokensThrowAnException() {
        Exception e = assertThrows(UnknownTokenException.class, () -> {
            Token.fromString("###INVALID###");
        });
        assertEquals("Token \"#\" invalid", e.getMessage());
    }
}