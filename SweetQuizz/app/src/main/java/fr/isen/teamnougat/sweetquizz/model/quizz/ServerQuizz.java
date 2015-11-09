package fr.isen.teamnougat.sweetquizz.model.quizz;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class ServerQuizz {
    private String name;
    private String screenName;

    public ServerQuizz(String name, String desc) {
        this.name = name;
        this.screenName = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
