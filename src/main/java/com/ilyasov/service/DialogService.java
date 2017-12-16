package com.ilyasov.service;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.User;

import java.util.List;

public interface DialogService {
    List<Dialog> findByUser(User user);
    Dialog findBySenderAndRecipient(User sender, User recipient);
    void add(Dialog dialog);
}
