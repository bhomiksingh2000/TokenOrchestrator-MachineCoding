package com.machineCoding.repository;

import com.machineCoding.model.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TokenRepository {
    private final ConcurrentHashMap<String, Token> tokens = new ConcurrentHashMap<>();

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

        return tokens.values() != null ? tokens.values() : new ArrayList<>();

    }
}
