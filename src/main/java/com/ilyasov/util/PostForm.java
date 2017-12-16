package com.ilyasov.util;

import org.hibernate.validator.constraints.NotBlank;

public class PostForm {

    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private long recipientId;

    public long getRecipientId() {
        return recipientId;
    }
}
