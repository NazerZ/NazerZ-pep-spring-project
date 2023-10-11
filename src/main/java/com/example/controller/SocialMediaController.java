package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.DuplicateUsernameException;
import com.example.exception.InvalidInputException;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import com.example.service.MessageService;

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
    private  AccountService accountService;
    
    @Autowired
    MessageService messageService;

    /**
     * @param account
     * @throws AccountException
     */
    @PostMapping("/register")
    public ResponseEntity<Account> postAccountRegister(@RequestBody Account account) throws DuplicateUsernameException,InvalidInputException{
        return new ResponseEntity<Account>(accountService.register(account),HttpStatus.OK);
        }
    @PostMapping("/login")
    public ResponseEntity<Account> postAccountLogin(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.login(account),HttpStatus.OK);
    }
    
    @PostMapping("/messages")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){
        if(accountService.getAccountById(message.getPosted_by()) == null){
            return new ResponseEntity<Message>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Message>(messageService.createMessage(message),HttpStatus.OK);
    }

    @GetMapping(value ="/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/messages/{message_id}")
    public Message getMessageById(@PathVariable Integer message_id){
        Message message = messageService.getMessageById(message_id);
        return message;
    }

    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable Integer message_id){
        int deletedMessage = messageService.deleteMessageById(message_id);
        if (deletedMessage == 1){
            return new ResponseEntity<Integer>(deletedMessage,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Integer>(0,HttpStatus.OK); 
        }
    }

    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> patchMessageById(@RequestBody Message text, @PathVariable int message_id ){
        return new ResponseEntity<Integer>(messageService.updateMessage(text,message_id),HttpStatus.OK) ;
    }

    @GetMapping("/accounts/{account_id}/messages")
    public List<Message> getAllMessagesByUser(@PathVariable Integer account_id){
        return messageService.getAllMessagesByUserId(account_id);
    }
}
