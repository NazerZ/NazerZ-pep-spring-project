package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.DuplicateUsernameException;
import com.example.exception.InvalidAccountException;
import com.example.exception.UnauthorizedLoginException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    //login
    //register

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public Account persistAccount(Account account){
        return accountRepository.save(account);
    }
    public Account login(Account account){
       Account acc = accountRepository.findByUsernameAndPassword(account.getUsername(),account.getPassword());
       if(acc == null){
        throw new UnauthorizedLoginException("Login Failed Try again!");
       }
        return acc;
    }


    public Account register(Account account)throws InvalidAccountException,DuplicateUsernameException{
        if(account.getUsername().length()<1  || account.getPassword().length() < 4){
            throw new InvalidAccountException("Invalid username or password");
        }

        Account a = accountRepository.findByUsername(account.getUsername());
        if (a != null){
            throw new DuplicateUsernameException("Username is taken.");
        }
        return accountRepository.save(account);
    }

    public Account getAccountById(Integer account_id) {
        Optional<Account> optional=accountRepository.findById(account_id);
        if(optional.isPresent()){
            Account account = optional.get();
            return account;
        }
        return null;
    }
    
    /*
    public Account getUsername(String username){
        Optional<Account> optional = accountRepository.findByUsername(username);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
        public Account getAccountById(Integer account_id) {
        Optional<Account> optional=accountRepository.findById(account_id);
        if(optional.isPresent()){
            Account account = optional.get();
            return account;
        }
        return null;
    }
    
    */
}
