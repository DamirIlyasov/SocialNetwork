package com.ilyasov.util;

import org.hibernate.validator.constraints.NotBlank;

public class CommentForm {
    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    private String text;
    private long postId;

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getPostId() {
        return postId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
