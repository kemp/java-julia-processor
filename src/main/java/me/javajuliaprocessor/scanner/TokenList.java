package me.javajuliaprocessor.scanner;

import me.javajuliaprocessor.TokenOrCouplingList;

import java.util.ArrayList;

public class TokenList extends TokenOrCouplingList {

    @Override
    public boolean equals(Object object) {
        // False if the other object is not a list of tokens
        if (! (object instanceof TokenList)) return false;

        TokenList list = (TokenList)object;

        // False if the lists are not the same size
        if (list.size() != this.size()) return false;

        // False if any element in the list is different
        for (int i = 0; i < this.size(); i++) {
            if (! this.get(i).equals(list.get(i))) return false;
        }

        return true;
    }
}
