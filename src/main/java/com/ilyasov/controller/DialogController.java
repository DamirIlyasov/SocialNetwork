package com.ilyasov.controller;

import com.ilyasov.model.Dialog;
import com.ilyasov.model.User;
import com.ilyasov.service.MessageService;
import com.ilyasov.model.Message;
import com.ilyasov.service.DialogService;
import com.ilyasov.service.UserService;
import com.ilyasov.util.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class DialogController {

    private final MessageService messageService;
    private final DialogService dialogService;
    private final UserService userService;

    @Autowired
    public DialogController(DialogService dialogService, MessageService messageService, UserService userService){
        this.userService = userService;
        this.messageService = messageService;
        this.dialogService = dialogService;
    }

    @RequestMapping(value = "/dialogs", method = RequestMethod.GET)
    public String getDialogList(Model model){
        model.addAttribute("dialogs", dialogService.findByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return "dialoglist";
    }

    @RequestMapping(value = "/dialogwith{userId}", method = RequestMethod.GET)
    public String getDialog(@PathVariable long userId, Model model){
        model.addAttribute("messageForm", new MessageForm());
        model.addAttribute("recipientId", userId);
        User sender = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User recipient = userService.findOneById(userId);
        Dialog dialog = dialogService.findBySenderAndRecipient(sender,recipient);
        model.addAttribute("messages", messageService.findAllByDialog(dialog));
        return "dialog";
    }

    @RequestMapping(value = "/sendmessageto{recipientId}", method = RequestMethod.POST)
    public String addMessage(@PathVariable long recipientId, @ModelAttribute("messageForm") @Valid MessageForm messageForm){
        Message message = new Message();
        message.setAuthor((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        message.setText(messageForm.getText());
        message.setDialog(dialogService.findBySenderAndRecipient(userService.findOneById(recipientId),(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        message.setDate(new Date());
        messageService.add(message);
        return "redirect:/dialogwith"+recipientId;
    }
}
