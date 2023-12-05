package com.CSC340.RMSproj.Engineer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo repo;
    public void deleteAll()
    {
        repo.deleteAll();
    }
    public List<Message> getMessage(){
        return repo.findAll();
    }

    public void sendMessage(Message message) { repo.save(message); }
}
