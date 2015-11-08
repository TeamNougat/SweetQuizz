package fr.isen.teamnougat.sweetquizz.JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;

/**
 * Created by piett on 10/16/2015.
 */
public class JsonParsingQuestion {
    private JSONObject quizzObj;

    public JsonParsingQuestion(JSONObject quizz) {
            this.quizzObj = quizz;
    }

    public JsonParsingQuestion(JSONArray quizzes) {
        try{
            this.quizzObj = quizzes.getJSONObject(0);
        }catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    public JsonParsingQuestion(String quizz) {
        try {
            this.quizzObj = new JSONObject(quizz);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    //*
    public Question getQuestion (int index){
        if (index > this.getAmountOfQuestion()-1){
            return null;
        }

        List answersList = new ArrayList();
        for(int i=0; i < this.getAmountOfAnswers(index); ++i){
            answersList.add(this.getAnswer(index, i));
        }

        try {
            return new Question(answersList, new JSONObject(this.quizzObj.getJSONArray("quizz").getString(index)).getString("text"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    //*
    public List<Question> getQuestionList (){
        List questionList = new ArrayList();
        for(int i=0; i < this.getAmountOfQuestion(); ++i){
            questionList.add(this.getQuestion(i));
        }
        return questionList;
    }//*/

    //*
    private Answer getAnswer (int indexQuestion, int indexAnswers){
        Answer myAnswer = new Answer();
        try {
            JSONObject temps = new JSONObject(this.quizzObj.getJSONArray("quizz").getString(indexQuestion)).getJSONArray("answers").getJSONObject(indexAnswers);
            myAnswer.setText(temps.getString("text"));
            myAnswer.setIsTrue(temps.getBoolean("isTrue"));
            return myAnswer;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    //*
    public String getDescription (){
        try{
            return this.quizzObj.getString("desc");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    //*
    public String getNameQuizz (){
        try{
            return this.quizzObj.getString("name");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    private int getAmountOfAnswers (int index){
        try{
            return new JSONObject(this.quizzObj.getJSONArray("quizz").getString(index)).getJSONArray("answers").length();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    //*
    public int getAmountOfQuestion (){
        try{
            return this.quizzObj.getJSONArray("quizz").length();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

    //*
    public int getTime (){
        try{
            return Integer.parseInt(this.quizzObj.getString("time"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }//*/

}
