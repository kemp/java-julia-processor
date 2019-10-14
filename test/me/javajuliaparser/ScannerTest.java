package me.javajuliaparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    // TODO Test the Scanner module (by providing input and checking the output)

    @Test
    public void testSimpleExample() {
        Scanner s = new Scanner();
        assertTrue(s.scan());
    }
}