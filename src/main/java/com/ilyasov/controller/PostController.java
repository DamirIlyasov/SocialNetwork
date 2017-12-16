package com.ilyasov.controller;

import com.ilyasov.model.Comment;
import com.ilyasov.model.Post;
import com.ilyasov.model.User;
import com.ilyasov.service.CommentService;
import com.ilyasov.service.PostService;
import com.ilyasov.service.UserService;
import com.ilyasov.transformers.PostFormToPostTransformer;
import com.ilyasov.util.CommentForm;
import com.ilyasov.util.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.function.Function;


@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final Function<PostForm, Post> postTransformer;
    private final CommentService commentService;


    @Autowired
    public PostController(UserService userService,PostService postService, CommentService commentService) {
        this.commentService = commentService;
        this.userService = userService;
        this.postService = postService;
        postTransformer = new PostFormToPostTransformer();
    }

    @RequestMapping(value = "/home/addposttouser{recipientId}", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("postForm") @Valid PostForm postForm, @PathVariable long recipientId){
        Post post = postTransformer.apply(postForm);
        post.setRecipient(userService.findOneById(recipientId));
        postService.add(post);
        return "redirect:/"+recipientId         ;
    }

    @RequestMapping(value = "/home/{postId}")
    public String getPostPage(@PathVariable long postId, Model model){
        Post post = postService.findOne(postId);
        model.addAttribute("post",post);
        model.addAttribute("commentForm", new CommentForm());
        model.addAttribute("comments",commentService.findAllByPost(post));
        return "post";
    }

    @RequestMapping(value = "/home/{postId}", method = RequestMethod.POST)
    public String addCommentToPost(@PathVariable long postId, Model model,@Valid CommentForm commentForm){
        Post post = postService.findOne(postId);
        Comment comment = new Comment();
        comment.setDate(new Date());
        comment.setPost(post);
        comment.setText(commentForm.getText());
        comment.setAuthor((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        commentService.add(comment);
//        model.addAttribute("post",post);
//        model.addAttribute("commentForm", new CommentForm());
//        model.addAttribute("comments",commentService.findAllByPost(post));
        return "redirect:/home/"+postId;
    }


}
