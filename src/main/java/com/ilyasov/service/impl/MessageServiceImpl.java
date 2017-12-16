package com.ilyasov.service.impl;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.Message;
import com.ilyasov.repository.MessageRepository;
import com.ilyasov.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }


    @Override
    public List<Message> findAllByDialog(Dialog dialog) {
        return messageRepository.findAllByDialog(dialog);
    }
    public void add(Message message){
        messageRepository.save(message);
    }
}
