package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@RestController
public class SocialMediaController {

    /**
     * @param account
     * @return
     */
    @Autowired
    private AccountService accountService;

    /**
     * @param account
     */
    @PostMapping("/register/")
    public ResponseEntity<Account> postAccountRegister(@RequestBody Account account){
        if(accountService.getUsername(account.getUsername()) != null){
            return ResponseEntity.status(409).body(null);
        }
        else if(account.getUsername().length() < 1 || account.getPassword().length()< 4){
            return ResponseEntity.status(400).body(null);
        }
        Account added = accountService.register(account);
        return ResponseEntity.status(200).body(added);
        }
    

    @PostMapping("/login")
    public Account postAccountLogin(@RequestBody Account account){
        return account;
    }
    
    @PostMapping("/messages/")
    public Message postMessage(@RequestBody Message message){
        return message;
    }

    @GetMapping("/messages/")
    public List<Message> getAllMessages(){
        return null;
    }

    @GetMapping("/messages/{message_id}")
    public Message getMessageById(@PathVariable int id){
        return null;
    }
    @DeleteMapping("/messages/{message_id}")
    public Message deleteMessageById(@PathVariable int id){
        return null;
    }

    @PatchMapping("/messages/{message_id}")
    public Message patchMessageById(@RequestBody String text, @PathVariable int id ){
        return null;
    }
}
