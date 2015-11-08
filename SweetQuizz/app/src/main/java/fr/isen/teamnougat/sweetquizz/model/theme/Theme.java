package fr.isen.teamnougat.sweetquizz.model.theme;

import android.content.Context;

public class Theme {

  public String name;
  public String imageName;

  public Theme(String name, String imageName) {
    this.name = name;
    this.imageName = imageName;
  }

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
  }

}
