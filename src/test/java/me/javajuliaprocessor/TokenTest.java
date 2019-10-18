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