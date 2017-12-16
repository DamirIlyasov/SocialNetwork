package com.ilyasov.repository;

import com.ilyasov.model.User;
import com.ilyasov.model.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DialogRepository extends JpaRepository<Dialog, Long> {

    @Query("select d from Dialog d where d.recipient =:user or d.sender =:user")
    List<Dialog> findByUser(@Param("user") User user);


    @Query("select d from Dialog d where d.sender = :sender and d.recipient = :recipient or " +
            "d.sender = :recipient and d.recipient = :sender")
    Dialog findOneByUsers(@Param("sender") User sender, @Param("recipient") User recipient);
}
