package com.ilyasov.transformers;

import com.ilyasov.model.User;
import com.ilyasov.util.UserForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Function;


public class UserFormToUserTransformer implements Function<UserForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setSex(userForm.getSex());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        return user;
    }

}
