package fr.isen.teamnougat.sweetquizz.views;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizz;

public class Palette {
    private String name;
    private String hexValue;
    private int intValue;
    private List<Palette> palettesList;

    public Palette(String name, String hexValue, int intValue) {
        this.name = name;
        this.hexValue = hexValue;
        this.intValue = intValue;
    }

    public String getName() {
        return name;
    }

    public List<Palette> getPaletteList() {
        return palettesList;
    }

    public String getHexValue() {
        return hexValue;
    }

    public int getIntValue() {
        return intValue;
    }


}