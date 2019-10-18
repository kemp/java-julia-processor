package me.javajuliaprocessor;

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
