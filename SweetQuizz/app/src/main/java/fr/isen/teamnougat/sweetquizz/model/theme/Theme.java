package fr.isen.teamnougat.sweetquizz.model.theme;

import android.content.Context;
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

public class Theme {

  public String name;
  public String imageName;
  public boolean isFav;

  public Theme(String name, String imageName) {
    this.name = name;
    this.imageName = imageName;
  }

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
  }

}
