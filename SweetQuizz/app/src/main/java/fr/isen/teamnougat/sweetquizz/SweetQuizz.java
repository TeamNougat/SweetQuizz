package fr.isen.teamnougat.sweetquizz;

import android.content.Context;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuestion;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class SweetQuizz extends com.activeandroid.app.Application {
    private static Context context;

    public JsonParsingQuestion tototata;

    @Override
    public void onCreate(){
        super.onCreate();
        SweetQuizz.context = getApplicationContext();

        /*
        aq = new AQuery(this);
        String url = "http://37.187.108.109:3000/quizzes/quizz/name:second";
        aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {

            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                if(json != null){
                    //successful ajax call, show status code and json content
                    System.out.println("-----------Success-----------");
                    JsonParsingQuestion myJson = new JsonParsingQuestion(json);
                    System.out.println(myJson.getDescription());
                    System.out.println("---------------------------");

                }else{
                    //ajax error, show error code
                    System.out.println("--------------Fail-----------");
                }
            }
        });
        */
    }

    public static Context getAppContext(){
        return context;
    }
}
