package fr.isen.teamnougat.sweetquizz.listeners;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.quizz.Question;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;

/**
 * Created by dhawo on 24-Oct-15.
 */
public interface QuestionListener {
    public void onNextQuestion();
    public int getNumberOfQuestion();
    public void onResultQuizz(List<Question> questions, Boolean score_result);
}
