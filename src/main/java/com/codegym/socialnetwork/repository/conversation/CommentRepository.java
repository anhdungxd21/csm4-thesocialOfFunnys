package com.codegym.socialnetwork.repository.conversation;

import com.codegym.socialnetwork.model.converstation.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
