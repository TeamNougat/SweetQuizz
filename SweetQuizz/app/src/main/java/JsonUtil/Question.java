package JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by piett on 10/16/2015.
 */
public class Question {
    private JSONArray quizzObj;

    public Question(String quizz) {
        try {
            this.quizzObj = new JSONArray(quizz);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getQuestion (int index){
        try {
            return this.quizzObj.getJSONObject(index).getString("question");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getAnswers (int index){
        try {
            JSONArray newArray =  this.quizzObj.getJSONObject(index).getJSONArray("answer");
            String[] stingArray;
            stingArray = new String[newArray.length()-1];
            for (int i = 0; i < newArray.length()-1; ++i) {
                stingArray[i] = newArray.getString(i);
            }

            return stingArray;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
