package com.ilyasov.service;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllByDialog(Dialog dialog);
    void add(Message message);
}
