package com.ilyasov.service;

import com.ilyasov.model.User;

import java.util.List;


public interface UserService {

    void add(User user);

    List<User> getAll();

    User findOneById(long id);

}
