package fr.isen.teamnougat.sweetquizz.model.quizz;

import java.util.ArrayList;

import fr.isen.teamnougat.sweetquizz.model.theme.Place;

public class ListQuizz {

    public static String[] listQuizzArray = {"Geography", "Movies", "History", "Music"};

    public static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < listQuizzArray.length; i++) {
            Place place = new Place();
            place.name = listQuizzArray[i];
            place.imageName = listQuizzArray[i].replaceAll("\\s+", "").toLowerCase();
            list.add(place);
        }
        return (list);
    }
}
