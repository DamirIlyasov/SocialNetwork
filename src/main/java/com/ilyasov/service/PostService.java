package com.ilyasov.service;

import com.ilyasov.model.Post;
import com.ilyasov.model.User;

import java.util.List;


public interface PostService {

    void add(Post post);
    List<Post> findAllByRecipient(User recipient);
    Post findOne(long id);
}
