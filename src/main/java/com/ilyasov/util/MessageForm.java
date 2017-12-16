package com.ilyasov.util;

import org.hibernate.validator.constraints.NotBlank;

public class MessageForm {
    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    private String text;

    public String getText() {
        return text;
    }

    private long authorId;

    public long getAuthorId() {
        return authorId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
