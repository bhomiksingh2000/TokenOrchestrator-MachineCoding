package com.machineCoding.service;

import com.machineCoding.model.Token;
//import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import com.machineCoding.repository.TokenRepository;
import com.machineCoding.enums.TokenEnum;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//import java.util.concurrent.TimeUnit;

public class TokenService {
    private TokenRepository repository = new TokenRepository();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//    Duration duration = Duration.ofMillis(500);
//    long milliseconds = duration.toMillis();


//    @Autowired
//    public TokenService(TokenRepository KeyRepository){
//        this.repository = KeyRepository;
//        executor.scheduleAtFixedRate(
//                this::removeExpiredTokens, // Runnable task to execute
//                0,                         // Initial delay (start immediately)
//                TokenEnum.MINUTE_IN_MILLISECONDS, TimeUnit.MINUTES);// Delay between executions (in milliseconds));
//    }


    @Autowired
    public TokenService(TokenRepository KeyRepository){
        this.repository = KeyRepository;
    }

    public Token createToken(){
        String id = UUID.randomUUID().toString();
        Token token = new Token(System.currentTimeMillis(), 0, id, false, System.currentTimeMillis());
        return repository.save(token);
    }

    public Token getToken() {
        for(Token token : repository.findAll()){
            if(!token.isBlocked() && System.currentTimeMillis() - token.getLastKeepAlive() < 5 * TokenEnum.MINUTE_IN_MILLISECONDS){
                token.setBlocked(true);
                token.setBlockedAt(System.currentTimeMillis());
                repository.save(token);
                return token;
            }
        }

        return null;
    }

    public Token findById(String id) {
        return repository.findById(id);
    }

    public boolean deleteTokenById(String id) {
        if(repository.findById(id) != null){
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public Token unblockTokenById(String id) {
        Token token = repository.findById(id);
        if(token != null){
            token.setBlocked(false);
            token.setBlockedAt(0);
            repository.save(token);
        }

        return token;
    }

    public Token keepAlive(String id) {
        Token token  = repository.findById(id);
        if(token != null){
            token.setLastKeepAlive(System.currentTimeMillis());
            repository.save(token);
        }

        return token;
    }

    private void removeExpiredTokens(){
        long currentTime = System.currentTimeMillis();
        for(Token token : repository.findAll()){
            if(currentTime - token.getLastKeepAlive() >= 5 * TokenEnum.MINUTE_IN_MILLISECONDS){
                repository.deleteById(token.getId());
            }
        }
    }

}
