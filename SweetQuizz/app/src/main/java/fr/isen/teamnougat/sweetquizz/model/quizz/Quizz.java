package fr.isen.teamnougat.sweetquizz.model.quizz;

import android.util.Log;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.logging.Logger;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuestion;
import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuizz;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.database.DatabaseHelper;
import fr.isen.teamnougat.sweetquizz.listeners.QuizzRetrievedListener;
import fr.isen.teamnougat.sweetquizz.model.Result;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTime;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Quizz {
    private String name;
    private List<Question> questions;
    private int nbAnsweredQuestions = 0;
    private QuizzTimer timer;

    public Quizz() {
    }

    public static void fetchQuestions(String quizzName,final QuizzRetrievedListener listener){
        AQuery aq;
        aq = new AQuery(SweetQuizz.getAppContext());
        String url = String.format("http://37.187.108.109:3000/quizzes/quizz/name:%s",quizzName);
        aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                Quizz tmpQuizz;
                if (json != null) {
                    JsonParsingQuestion myJsonParsed = new JsonParsingQuestion(json);
                    QuizzTimer timer = new QuizzTimer(new QuizzTime(myJsonParsed.getTime()));
                    Quizz myQuizz = new Quizz(myJsonParsed.getQuestionList(), myJsonParsed.getNameQuizz(), timer);
                    listener.onQuizzRetrieved(myQuizz);

                } else {
                    //ajax error, show error code
                    Toast.makeText(SweetQuizz.getAppContext(), SweetQuizz.getAppContext().getResources().getString(R.string.no_connection_message), Toast.LENGTH_SHORT).show();
                    Log.d(Logger.GLOBAL_LOGGER_NAME, "--------------Fail-----------");
                }
            }
        });
    }

    public Quizz(List<Question> questions, String name, QuizzTimer timer) {
        this.questions = questions;
        this.name = name;
        this.timer = timer;
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

    public QuizzTimer getTimer() {
        return timer;
    }
}
