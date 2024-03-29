/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor.scanner;

public class Token {
    private TokenType type;
    private String lexeme;
    private int lineNumber;

    protected Token(TokenType type, String lexeme, int lineNumber) {
        this.type = type;
        this.lexeme = lexeme;
        this.lineNumber = lineNumber;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (! (object instanceof Token)) return false;

        Token token = (Token)object;

        if (! token.getLexeme().equals(this.getLexeme())) return false;
        if (! token.getType().equals(this.getType())) return false;

        return true;
    }

    protected static Token fromString(String input, int lineNumber) throws UnknownTokenException {
        try {
            TokenType tokenType = TokenType.fromLexeme(input);

            return new Token(tokenType, input, lineNumber);
        } catch (UnknownTokenTypeException e) {
            if (input.length() <= 1) {
                throw new UnknownTokenException("Token \"" + input + "\" invalid");
            } else {
                return fromString(input.substring(0, input.length() - 1), lineNumber);
            }
        }
    }
}
