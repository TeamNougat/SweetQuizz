package com.example.piett.sweetquizz.model;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Answer {
    private String text;
    private boolean isTrue;

    public Answer(String text, boolean isTrue) {
        this.text = text;
        this.isTrue = isTrue;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
