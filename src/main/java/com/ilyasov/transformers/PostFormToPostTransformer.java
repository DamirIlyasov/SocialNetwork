package com.ilyasov.transformers;

import com.ilyasov.model.Post;
import com.ilyasov.model.User;
import com.ilyasov.util.PostForm;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.function.Function;

public class PostFormToPostTransformer implements Function<PostForm,Post> {

    @Override
    public Post apply(PostForm postForm) {
        Post post = new Post();
        post.setText(postForm.getText());
        post.setDate(new Date());
        post.setAuthor((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return post;
    }
}
