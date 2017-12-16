package com.ilyasov.service.impl;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.User;
import com.ilyasov.repository.DialogRepository;
import com.ilyasov.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DialogServiceImpl implements DialogService {
    private final DialogRepository dialogRepository;

    @Autowired
    DialogServiceImpl(DialogRepository dialogRepository){
        this.dialogRepository = dialogRepository;
    }

    @Override
    public List<Dialog> findByUser(User user) {
        return dialogRepository.findByUser(user);
    }

    @Override
    public Dialog findBySenderAndRecipient(User sender, User recipient) {
        Dialog dialog = dialogRepository.findOneByUsers(sender,recipient);
        if (dialog == null){
            Dialog newDialog = new Dialog();
            newDialog.setSender(sender);
            newDialog.setRecipient(recipient);
            dialogRepository.save(newDialog);
            return newDialog;
        } else {
            return dialog;
        }
    }

    @Override
    public void add(Dialog dialog) {
        dialogRepository.save(dialog);
    }


}
