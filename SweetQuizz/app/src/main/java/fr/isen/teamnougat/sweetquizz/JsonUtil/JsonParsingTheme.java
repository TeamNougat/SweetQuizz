package fr.isen.teamnougat.sweetquizz.JsonUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.theme.Theme;

/**
 * Created by dhawo on 06/11/2015.
 */
public class JsonParsingTheme {
    private JSONArray themes;

    public JsonParsingTheme(JSONArray themes) {
        this.themes = themes;
    }

    public JsonParsingTheme(String themes) {
        try {
            this.themes = new JSONArray(themes);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Theme> getThemeList (){
        try{
            int size = this.themes.length();
            List<Theme> returnList = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                String name = this.themes.getString(i);
                returnList.add(new Theme(name,name));
            }
            return returnList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
