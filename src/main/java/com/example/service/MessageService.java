package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository =messageRepository;
    }
    public static Message addMessage(Message message) {
        return null;
    }

    public List<Message> getAllMessages() {
        
        return messageRepository.findAll();
    }
}
