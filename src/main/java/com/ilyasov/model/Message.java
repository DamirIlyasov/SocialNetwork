package com.ilyasov.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dialog_id")
    private Dialog dialog;

    private String text;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public User getAuthor() {
        return author;
    }
}
