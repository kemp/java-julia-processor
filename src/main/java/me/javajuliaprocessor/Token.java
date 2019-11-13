/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package main.java.me.javajuliaprocessor;

class Token {
    private TokenType type;
    private String lexeme;

    Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    TokenType getType() {
        return type;
    }

    String getLexeme() {
        return lexeme;
    }

    @Override
    public boolean equals(Object object) {
        if (! (object instanceof Token)) return false;

        Token token = (Token)object;

        if (! token.getLexeme().equals(this.getLexeme())) return false;
        if (! token.getType().equals(this.getType())) return false;

        return true;
    }

    static Token fromString(String input) throws UnknownTokenException {
        try {
            TokenType tokenType = TokenType.fromLexeme(input);

            return new Token(tokenType, input);
        } catch (UnknownTokenTypeException e) {
            if (input.length() <= 1) {
                throw new UnknownTokenException("Token \"" + input + "\" invalid");
            } else {
                return fromString(input.substring(0, input.length() - 1));
            }
        }
    }
}
