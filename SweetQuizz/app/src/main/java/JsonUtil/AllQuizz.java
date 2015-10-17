package JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by piett on 10/17/2015.
 */
public class AllQuizz {
    private JSONArray listQuizzObj;

    public AllQuizz(String listQuizz) {
        try {
            this.listQuizzObj = new JSONArray(listQuizz);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getQuizz(int index){
        try {
            return this.listQuizzObj.getString(index);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
