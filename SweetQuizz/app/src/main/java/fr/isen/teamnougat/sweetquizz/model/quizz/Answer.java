package fr.isen.teamnougat.sweetquizz.model.quizz;

/**
 * Created by dhawo on 19-Oct-15.
 */
public class Answer {
    private String text;
    private boolean isTrue;
    private boolean isChecked;

    public Answer() {
        this.text = "";
        this.isTrue = false;
        this.isChecked = false;
    }

    public Answer(String text, boolean isTrue) {
        this.text = text;
        this.isTrue = isTrue;
        this.isChecked = false;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
