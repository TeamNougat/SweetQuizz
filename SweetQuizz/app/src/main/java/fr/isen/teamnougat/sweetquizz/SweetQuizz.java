package fr.isen.teamnougat.sweetquizz;

import android.app.Application;
import android.content.Context;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class SweetQuizz extends Application {
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        SweetQuizz.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
