package com.machineCoding.repository;

import com.machineCoding.model.Token;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TokenRepository {
    private Map<String, Token> tokens;

    public TokenRepository() {
        this.tokens = new Map<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Token get(Object key) {
                return null;
            }

            @Override
            public Token put(String key, Token value) {
                return null;
            }

            @Override
            public Token remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Token> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Token> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Token>> entrySet() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
    }

    public Token save(Token token){
        tokens.put(token.getId(), token);
        return token;
    }

    public Token findById(String id){
        return tokens.get(id);
    }

    public void deleteById(String id){
        tokens.remove(id);
    }

    public Collection<Token> findAll(){
        return tokens.values();
    }
}
