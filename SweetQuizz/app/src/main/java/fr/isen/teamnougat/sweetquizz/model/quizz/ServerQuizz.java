package fr.isen.teamnougat.sweetquizz.model.quizz;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class ServerQuizz {
    private String name;
    private String desc;

    public ServerQuizz(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
