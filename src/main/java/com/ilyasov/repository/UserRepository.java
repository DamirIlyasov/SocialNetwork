package com.ilyasov.repository;

import com.ilyasov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
    User findOneById(long id);

}
