package com.machineCoding.controller;

import com.machineCoding.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.machineCoding.service.TokenService;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    private final TokenService service;
    @Autowired
    public TokenController(TokenService service){
        this.service = service;
    }


    /*
    ENDPOINT TO CREATE A NEW API KEY
    */
    @PostMapping
    public Token generateKey(){
        return service.createToken();
    }

    /*
    ENDPOINT TO RETRIEVE A  API KEY
    */
    @GetMapping
    public Token getKey(){
        Token token = service.getToken();
        if(token == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return token;
    }

    /*
    ENDPOINT TO RETRIEVE A SPECIFIC API KEY
    */
    @GetMapping("/{id}")
    public Token getTokenById(@PathVariable String id){
        Token token = service.findById(id);
        if(token == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return token;
    }

    /*
    ENDPOINT TO DELETE A SPECIFIC API KEY

    */

    @DeleteMapping("/{id}")
    public void deleteToken(@PathVariable String id){
        if(!service.deleteTokenById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

      /*
    ENDPOINT TO UNBLOCK A SPECIFIC API KEY for RE USE

    */

    @PutMapping("/{id}/unblock")
    public Token unblockToken(@PathVariable String id){
        Token token  = service.unblockTokenById(id);
        if(token == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return token;
    }


    /*
   ENDPOINT TO SIGNAL THE SERVER TO KEEP  THE SPECIFIED KEY FROM BEING DELETED

   */
    @PutMapping("/{id}/keep-alive")
    public Token keepAlive(@PathVariable String id){
        Token token  = service.keepAlive(id);
        if(token == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return token;
    }


}
