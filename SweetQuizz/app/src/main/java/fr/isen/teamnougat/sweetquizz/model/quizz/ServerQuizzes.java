package fr.isen.teamnougat.sweetquizz.model.quizz;

import android.util.Log;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;

import java.util.List;
import java.util.logging.Logger;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuizz;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class ServerQuizzes {
    private List<ServerQuizz> quizzesList;

    public ServerQuizzes(List<ServerQuizz> quizzesList) {
        this.quizzesList = quizzesList;
    }

    public List<ServerQuizz> getQuizzesList() {
        return quizzesList;
    }

    public static void fetchQuizzes(String theme, final ServerListener listener){
        AQuery aq;
        aq = new AQuery(SweetQuizz.getAppContext());
        String url = String.format("http://37.187.108.109:3000/quizzes/theme/name:%s",theme);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>() {
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                List<ServerQuizz> tmpQuizzesList;
                if (json != null) {
                    JsonParsingQuizz jsonQuizzes = new JsonParsingQuizz(json);
                    tmpQuizzesList = jsonQuizzes.getQuizzesList();
                    ServerQuizzes serverQuizzes = new ServerQuizzes(tmpQuizzesList);
                    listener.onQuizzesRetrieved(serverQuizzes);

                } else {
                    //ajax error, show error code
                    Toast.makeText(SweetQuizz.getAppContext(), SweetQuizz.getAppContext().getResources().getString(R.string.no_connection_message), Toast.LENGTH_SHORT).show();
                    Log.d(Logger.GLOBAL_LOGGER_NAME, "--------------Fail-----------");
                }
            }
        });
    }
}
