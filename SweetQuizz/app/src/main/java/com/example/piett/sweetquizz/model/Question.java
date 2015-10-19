package com.example.piett.sweetquizz.model;

import java.util.List;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Question {
    private String text;
    private List<Answer> answers;
    private int goodAnswerCount;

    public Question(List<Answer> answers, String text) {
        this.answers = answers;
        this.text = text;
        goodAnswerCount = 0;
        for(Answer element : answers){
            if(element.isTrue()){
                goodAnswerCount++;
            }
        }
    }

    public String getText() {
        return text;
    }

    public Answer getAnswer(int i){
        return answers.get(i);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getGoodAnswerCount() {
        return goodAnswerCount;
    }
}
