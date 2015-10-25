package fr.isen.teamnougat.sweetquizz.model.quizz;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.Result;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Quizz {
    private List<Question> questions;
    private int nbAnsweredQuestions = 0;


    public Quizz(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Result calculateResult(){
        int goodAnswers = 0;
        for(Question element : questions){
            if(element.checkAnswer()){
                goodAnswers++;
            }
        }
        return new Result(nbAnsweredQuestions,goodAnswers,questions.size());
    }

    public Question getQuestion(int position){
        return questions.get(position);
    }

    public void incrementAnsweredQuestions(){
        this.nbAnsweredQuestions++;
    }

    public int getNbAnsweredQuestions() {
        return nbAnsweredQuestions;
    }
}
