package com.codegym.socialnetwork.service;

import com.codegym.socialnetwork.model.Conversation;
import com.codegym.socialnetwork.service.GeneralService;

public interface ConversationService extends GeneralService<Conversation> {
    Iterable<Conversation> findAllNewestRecord();
}
