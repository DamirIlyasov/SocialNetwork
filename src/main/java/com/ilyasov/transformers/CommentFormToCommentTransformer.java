package com.ilyasov.transformers;

import com.ilyasov.model.Comment;
import com.ilyasov.model.User;
import com.ilyasov.repository.PostRepository;
import com.ilyasov.util.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.function.Function;

public class CommentFormToCommentTransformer implements Function<CommentForm,Comment> {
    private final PostRepository postRepository;
    @Autowired
    public CommentFormToCommentTransformer(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Comment apply(CommentForm commentForm) {
        Comment comment = new Comment();
        comment.setDate(new Date());
        comment.setAuthor((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        comment.setText(commentForm.getText());
        comment.setPost(postRepository.findOne(commentForm.getPostId()));
        return comment;
    }
}
