package com.codegym.socialnetwork.repository.conversation;

import com.codegym.socialnetwork.model.Conversation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long> {

}
