package fr.isen.teamnougat.sweetquizz.database;

import com.activeandroid.query.Select;

import fr.isen.teamnougat.sweetquizz.model.Result;


/**
 * Created by dhawo on 04-Nov-15.
 */
public class DatabaseHelper {

    public static Result getQuizzResults(String name){
        return new Select()
                .from(Result.class)
                .where("quizz_name = ?",name)
                .executeSingle();
    }
}
