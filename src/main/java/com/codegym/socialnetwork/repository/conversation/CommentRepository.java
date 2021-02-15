package com.codegym.socialnetwork.repository.conversation;

import com.codegym.socialnetwork.model.converstation.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
