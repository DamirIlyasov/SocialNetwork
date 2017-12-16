package com.ilyasov.service.impl;

import com.ilyasov.model.User;
import com.ilyasov.model.Post;
import com.ilyasov.repository.PostRepository;
import com.ilyasov.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAllByRecipient(User recipient) {
        return postRepository.findAllByRecipient(recipient);
    }

    @Override
    public Post findOne(long id) {
        return postRepository.findOne(id);
    }

}
