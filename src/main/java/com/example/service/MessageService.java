package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.InvalidInputException;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AccountRepository accountRepository;
    public MessageService(MessageRepository messageRepository){
        this.messageRepository =messageRepository;
    }
    public static Message addMessage(Message message) {
        return null;
    }

    public List<Message> getAllMessages() {

        return messageRepository.findAll();
    }
    public Message createMessage(Message message)throws InvalidInputException {
        if(message.getMessage_text().length() <1 ||message.getMessage_text().length()>255){
            throw new InvalidInputException("Invalid message");
        }
        /*
        if(messageRepository.findById(message.getPosted_by())== null){
            throw new InvalidInputException("User doesnt exist");
        }
        */
        return messageRepository.save(message);
    }
    public Message getMessageById(Integer id) {
        return messageRepository.findById(id).get();
    }
    public int deleteMessageById(int id) {
        Optional<Message> m = messageRepository.findById(id);
        if (m.isPresent()){
            Message message = m.get();
            messageRepository.delete(message);
            return 1;
        }
        return 0;
    }
    public int updateMessage(String text, int id) {
        /*if(text.length() <1 ||text.length()>255){
            throw new InvalidInputException("Invalid message");
        }
        int rows = messageRepository.updateMessageText(id, text);
        if(rows == 0){
            throw new InvalidInputException("not valid input");
        }
        return rows;*/
        return (Integer) null;
    }
}
