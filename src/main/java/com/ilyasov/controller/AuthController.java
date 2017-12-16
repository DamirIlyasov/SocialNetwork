package com.ilyasov.controller;

import com.ilyasov.model.User;
import com.ilyasov.model.enums.Sex;
import com.ilyasov.util.AuthForm;
import com.ilyasov.service.UserService;
import com.ilyasov.util.UserForm;
import com.ilyasov.transformers.UserFormToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.function.Function;


@Controller
public class AuthController {

    private final UserService userService;
    private final Function<UserForm, User> transformer;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
        transformer = new UserFormToUserTransformer();
    }

    @RequestMapping("/sign_in")
    public String getSignIn(@RequestParam(value = "error", required = false) Boolean error,
                            Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("authForm", new AuthForm());
        return "sign_in";
    }

    @RequestMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserForm());
        model.addAttribute("sex", Sex.values());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") @Valid UserForm userForm,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sex", Sex.values());
            return "sign_up";
        }
        userService.add(transformer.apply(userForm));
        return "redirect:/home";
    }


}
