package fr.isen.teamnougat.sweetquizz.model.quizz;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import fr.isen.teamnougat.sweetquizz.database.DatabaseHelper;
import fr.isen.teamnougat.sweetquizz.fragments.Constants;
import fr.isen.teamnougat.sweetquizz.model.Result;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Quizz {
    private String name;
    private static List<Question> questions;
    private int nbAnsweredQuestions = 0;;

    public Quizz() {
    }

    public Quizz(List<Question> questions, String name) {
        this.questions = questions;
        Constants.QuestionFragmentConstants.ACTUAL_QUESTIONS = questions;
        this.name = name;
        int index = 1;
        for(Question quest : questions) {
            quest.setQuestionsNumbers(index);
            index++;
        }

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

        Result result = new Result(nbAnsweredQuestions,goodAnswers,questions.size(),this.getName());
        /****For Testing purposes*****/
        Result previousResult = DatabaseHelper.getQuizzResults(this.getName());
        if(previousResult != null){
            Log.d(Logger.GLOBAL_LOGGER_NAME,String.format("Previous result : %d out of %d",previousResult.getGoodAnswers(),previousResult.getNbQuestions()));
        }

        /*****************************/
        result.save();
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
