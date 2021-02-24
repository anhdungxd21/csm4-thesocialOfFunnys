package com.codegym.socialnetwork.repository.conversation;

import com.codegym.socialnetwork.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findAllByConversationId(Long id);
}
