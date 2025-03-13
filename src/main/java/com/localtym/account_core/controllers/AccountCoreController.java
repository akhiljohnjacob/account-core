package com.localtym.account_core.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.localtym.account_core.domain.AccountResponse;



@RestController
public class AccountCoreController {

    @GetMapping("/localtym-api/account-core/v1/default")
    public String dispDefaultMsg() {
        return new String("Welcome to Localtym's Account Core API");
    }
    

    @PostMapping("/localtym-api/account-core/v1/accountInfo")
    public ResponseEntity<AccountResponse> accountInfo(@RequestBody String entity) {
     
        
        return new ResponseEntity<AccountResponse>(null);
    }
    

}
