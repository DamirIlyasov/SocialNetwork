package com.ilyasov.repository;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByDialog(Dialog dialog);
}
