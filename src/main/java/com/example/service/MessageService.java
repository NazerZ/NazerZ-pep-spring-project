package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.InvalidInputException;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
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
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()){
            return message.get();
        }
        return null;
    }
    public int deleteMessageById(int id) {
        Optional<Message> m = messageRepository.findById(id);
        if (m.isPresent()){
            messageRepository.deleteById(id);
            return 1;
        }
        return 0;
    }
    public int updateMessage(Message text, int id) {
        if(text.getMessage_text().length() <1 ||text.getMessage_text().length()>255){
            throw new InvalidInputException("Invalid message");
        }
        Optional<Message> m = messageRepository.findById(id);
        if (!m.isPresent()){
            throw new InvalidInputException("id not found");
        }
        Message mm = m.get();
        mm.setMessage_text(text.getMessage_text());
        messageRepository.save(mm);
        return 1;
    }
    public List<Message> getAllMessagesByUserId(Integer account_id) {
        return messageRepository.getMessagesByAccountId(account_id);
    }
}
