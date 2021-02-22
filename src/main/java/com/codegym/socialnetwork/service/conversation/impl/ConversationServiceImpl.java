package com.codegym.socialnetwork.service.conversation.impl;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.repository.conversation.ConversationRepository;
import com.codegym.socialnetwork.service.conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
