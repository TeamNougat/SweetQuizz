package fr.isen.teamnougat.sweetquizz.model.quizz;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Quizz {
    private List<Question> questions;
    private QuizzTimer timer;
    private int nbAnsweredQuestions;


    public Quizz(List<Question> questions, QuizzTimer timer) {
        this.questions = questions;
        this.timer = timer;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
