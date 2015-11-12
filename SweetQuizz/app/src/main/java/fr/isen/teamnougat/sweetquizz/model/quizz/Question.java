package fr.isen.teamnougat.sweetquizz.model.quizz;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Question  {
    private String text;
    private List<Answer> answers;
    private int goodAnswerCount;
    private int questionsNumbers;

    public Question() {
        this.answers = null;
        this.text = null;
        goodAnswerCount = 0;
    }


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

    public int getQuestionsNumbers() {
        return questionsNumbers;
    }

    public void setQuestionsNumbers(int nb) {
        questionsNumbers = nb;
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

    public boolean checkAnswer(){
        for(Answer answer : answers){
            if((answer.isChecked() && !answer.isTrue()) || (!answer.isChecked() && answer.isTrue())){ //Then the answer given is wrong
                return false;
            }
        }
        return true;
    }




}
