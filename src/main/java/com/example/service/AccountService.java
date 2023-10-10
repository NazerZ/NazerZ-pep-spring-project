package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    //login
    //register
    
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public Account persistAccount(Account account){
        return accountRepository.save(account);
    }
    public Account login(Account account){
        //invalid loginexception
        return accountRepository.getLogin(account.getUsername(),account.getPassword());
    }
    public Account register(Account account){
        //invalid acount exception
        return accountRepository.save(account);
    }
    /*        
    public Account Register(Account account){
        Optional<Account> optionalAccount = accountRepository.getUsername(null);
        if(optionalAccount.isEmpty(){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if(optionalAccount.get().getAccount_id() == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK.body(optionalAccount.get()));

    }
    //*/



    public Account getAccountById(Integer account_id) {
        Optional<Account> optional=accountRepository.findById(account_id);
        if(optional.isPresent()){
            Account account = optional.get();
            return account;
        }
        return null;
    }
    public Account getUsername(String username){
        Optional<Account> optional = accountRepository.getUsername(username);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
