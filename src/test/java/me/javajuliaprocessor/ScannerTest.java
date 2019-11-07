/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    @Test
    void testSimpleExample() {
        String input = "a = a + 1";

        Scanner scanner = new Scanner();

        TokenList tokens = null;

        try {
            tokens = scanner.scan(Collections.singletonList(input));
        } catch (UnknownTokenException e) {
           fail(e.getMessage());
        }

        assertEquals(5, tokens.size());
    }
}