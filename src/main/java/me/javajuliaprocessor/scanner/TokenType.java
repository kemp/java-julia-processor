/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor.scanner;

public enum TokenType {
    // Letter and number identifiers
    IDENTIFIER (4000, "[A-Za-z]"),
    INT_CONSTANT (4001, "[0-9]+"),

    // Operators
    ASSIGN_OP (5000, "="),
    LT_OP (5001, "<"),
    GT_OP (5002, ">"),
    LE_OP (5003, "<="),
    GE_OP (5004, ">="),
    EQ_OP (5005, "=="),
    NE_OP (5006, "!="),
    ADD_OP (5007, "\\+"),
    SUB_OP (5008, "-"),
    MUL_OP (5009, "\\*"),
    DIV_OP (5010, "/"),
    MOD_OP (5011, "%"),
    REV_DIV_OP (5012, "\\\\"),
    EXP_OP (5013, "\\^"),

    // Control structures
    IF (6000, "if"),
    ELSE (6001, "else"),

    WHILE (6002, "while"),

    FOR (6003, "for"),

    END (6004, "end"),

    // Parenthesis
    LEFT_PAREN (7000, "\\("),
    RIGHT_PAREN (7001, "\\)"),

    // Miscellaneous token types
    ITERATOR (8000, ":"),
    PRINT (8001, "print");

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
