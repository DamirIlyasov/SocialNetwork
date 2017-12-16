package com.ilyasov.model;

import javax.persistence.*;

@Entity
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient")
    private User recipient;

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public Long getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }
}
