package fr.isen.teamnougat.sweetquizz.model.theme;

import android.util.Log;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;

import java.util.List;
import java.util.logging.Logger;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingTheme;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;

public class Themes {

  //public static String[] placeNameArray = {"Bora Bora", "Canada", "Dubai", "Hong Kong", "Iceland", "India", "Kenya", "London", "Switzerland", "Sydney"};
  private List<Theme> themesList;

  public Themes(List<Theme> themesList) {
    this.themesList = themesList;
  }

  public static void fetchThemes(final ServerListener listener){
    AQuery aq;
    aq = new AQuery(SweetQuizz.getAppContext());
    String url = "http://37.187.108.109:3000/quizzes/theme/";
    aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>() {
      @Override
      public void callback(String url, JSONArray json, AjaxStatus status) {
        List<Theme> tmpthemesList;
        if (json != null) {
          JsonParsingTheme jsonThemes = new JsonParsingTheme(json);
          tmpthemesList = jsonThemes.getThemeList();
          Themes themes = new Themes(tmpthemesList);
          listener.onThemesRetrieved(themes);
        } else {
          //ajax error, show error code
          Toast.makeText(SweetQuizz.getAppContext(), SweetQuizz.getAppContext().getResources().getString(R.string.no_connection_message),Toast.LENGTH_SHORT).show();
          Log.d(Logger.GLOBAL_LOGGER_NAME, "--------------Fail-----------");
        }
      }
    });
  }

  public List<Theme> getThemesList() {
    return themesList;
  }
}
