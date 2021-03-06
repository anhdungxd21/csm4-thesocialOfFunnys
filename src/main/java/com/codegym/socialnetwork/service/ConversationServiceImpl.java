package com.codegym.socialnetwork.service;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.repository.conversation.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Iterable<Conversation> findAll() {
        return conversationRepository.findAll();
    }

    @Override
    public Optional<Conversation> findById(Long id) {
        return conversationRepository.findById(id);
    }

    @Override
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public void remove(Long id) {
        conversationRepository.deleteById(id);
    }

    @Override
    public Iterable<Conversation> findAllNewestRecord() {
        List<Conversation> conversations = (List<Conversation>) conversationRepository.findAll();
        Stack<Conversation> stacks = new Stack();
        List<Conversation> conversationList = new ArrayList<Conversation>();
        for (int i = 0; i < conversations.size(); i++) {
            stacks.push(conversations.get(i));
        }
        while(stacks.isEmpty() == false){
            conversationList.add(stacks.pop());
        }
        return conversationList;
    }
}
