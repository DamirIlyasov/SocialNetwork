package com.ilyasov.controller;

import com.ilyasov.model.User;
import com.ilyasov.repository.UserRepository;
import com.ilyasov.util.PostForm;
import com.ilyasov.model.Post;
import com.ilyasov.repository.PostRepository;
import com.ilyasov.service.PostService;
import com.ilyasov.service.UserService;
import com.ilyasov.transformers.PostFormToPostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.function.Function;


@Controller
public class MainController {

    private final PostService postService;
    private final Function<PostForm, Post> transformer;
    private final UserService userService;


    @Autowired
    public MainController(PostService postService, PostRepository postRepository, UserRepository userRepository, UserService userService) {
        this.userService = userService;
        this.postService = postService;
        transformer = new PostFormToPostTransformer();
    }

    @RequestMapping("/home")
    public String home(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.findAllByRecipient(user));
        model.addAttribute("postForm", new PostForm());
        return "home";
    }


    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String allusers(Model model){
        model.addAttribute("users",userService.getAll());
        return "allusers";
    }

//    @RequestMapping(value = "/{userId}")
//    public String userPage(@PathVariable long userId, Model model){
//        User user = userService.findOneById(userId);
//        model.addAttribute("user", user);
//        model.addAttribute("posts",postService.findAllByRecipient(user));
//        model.addAttribute("postForm", new PostForm());
//        return "home";
//    }
}
