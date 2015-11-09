package fr.isen.teamnougat.sweetquizz.JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizz;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class JsonParsingQuizz {
    private JSONArray quizzes;

    public JsonParsingQuizz(JSONArray quizzes) {
        this.quizzes = quizzes;
    }

    public JsonParsingQuizz(String quizzes) {
        try {
            this.quizzes = new JSONArray(quizzes);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ServerQuizz> getQuizzesList (){
        try{
            int size = this.quizzes.length();
            List<ServerQuizz> returnList = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                JSONObject jsonObject = this.quizzes.getJSONObject(i);
                String name = jsonObject.getString("name");
                String screenName = jsonObject.getString("screenName");
                returnList.add(new ServerQuizz(name,screenName));
            }
            return returnList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
