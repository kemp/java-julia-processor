/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    @Test
    void testSimpleExample() {
        String input = "a = a + 1";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        Scanner scanner = new Scanner(printStream);
        scanner.scan(Collections.singletonList(input));

        String output = byteArrayOutputStream.toString();

        assertTrue(output.contains("Lexical analysis complete!"));
    }
}