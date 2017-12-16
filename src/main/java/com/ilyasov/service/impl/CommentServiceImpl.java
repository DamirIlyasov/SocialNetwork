package com.ilyasov.service.impl;

import com.ilyasov.model.Comment;
import com.ilyasov.repository.CommentRepository;
import com.ilyasov.model.Post;
import com.ilyasov.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        return commentRepository.findAllByPost(post);
    }
}
