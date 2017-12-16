package com.ilyasov.service;

import com.ilyasov.model.Comment;
import com.ilyasov.model.Post;

import java.util.List;

public interface CommentService {
    void add(Comment comment);
    List<Comment> findAllByPost(Post post);
}
