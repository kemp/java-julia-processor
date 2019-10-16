package me.javajuliaprocessor;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenType {
    INT_CONSTANT (5001, "[0-9]+"),
//    R_CONSTANT (5002, ""), // TODO: This was found in Garrido's assignment PDF?
    ASSIGN_OP (5003, "="),
    IF_OP (5004, "if"),
    ELSE_SK (5005, "else"),
    PLUS_OP (5006, "\\+"),
//    UNARY_MINUS (5007, "-"), // TODO: This was found in Garrido's assignment PDF?
    MINUS_OP (5008, "-"),
    MULT_OP (5009, "\\*"),
    DIV_OP (5010, "\\/"),
    ENDIF_SK (5011, "endif"),
    IDENTIFIER (5012, "[a-zA-Z]+");

    private final int id;
    private final String lexemeRegex;

    TokenType(int id, String lexemeRegex) {
        this.id = id;
        this.lexemeRegex = lexemeRegex;
    }

    public int getId() {
        return id;
    }

    public static TokenType fromLexeme(String lexeme) throws UnknownTokenTypeException {
        for (TokenType tokenType : TokenType.values()) {
            if (lexeme.matches(tokenType.lexemeRegex)) {
                return tokenType;
            }
        }

        throw new UnknownTokenTypeException();
    }
}
