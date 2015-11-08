package fr.isen.teamnougat.sweetquizz.model.theme;

import java.util.ArrayList;

public class ListTheme {

  public static String[] placeNameArray = {"Music", "History", "Movies", "Geography"};

  public static ArrayList<Place> placeList() {
    ArrayList<Place> list = new ArrayList<>();
    for (int i = 0; i < placeNameArray.length; i++) {
      Place place = new Place();
      place.name = placeNameArray[i];
      place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
      list.add(place);
    }
    return (list);
  }
}
