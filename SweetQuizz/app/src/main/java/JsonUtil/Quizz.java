package JsonUtil;

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Created by piett on 10/16/2015.
 */
public class Quizz {
    private JSONObject quizzObj;

    public Quizz(String quizz) {
        try {
            this.quizzObj = new JSONObject(quizz);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
