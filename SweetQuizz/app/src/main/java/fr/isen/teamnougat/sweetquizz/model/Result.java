package fr.isen.teamnougat.sweetquizz.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dhawo on 25-Oct-15.
 */
public class Result implements Parcelable {
    private int nbAnsweredQuestion;
    private int goodAnswers;
    private int nbQuestions;

    public Result(int nbAnsweredQuestion, int goodAnswers, int nbQuestions) {
        this.nbAnsweredQuestion = nbAnsweredQuestion;
        this.goodAnswers = goodAnswers;
        this.nbQuestions = nbQuestions;
    }

    public Result(Parcel input){
        this.nbAnsweredQuestion = input.readInt();
        this.goodAnswers = input.readInt();
        this.nbQuestions = input.readInt();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public int getNbAnsweredQuestion() {
        return nbAnsweredQuestion;
    }

    public void setNbAnsweredQuestion(int nbAnsweredQuestion) {
        this.nbAnsweredQuestion = nbAnsweredQuestion;
    }

    public int getNbQuestions() {
        return nbQuestions;
    }

    public void setNbQuestions(int nbQuestions) {
        this.nbQuestions = nbQuestions;
    }

    public int getGoodAnswers() {
        return goodAnswers;
    }

    public void setGoodAnswers(int goodAnswers) {
        this.goodAnswers = goodAnswers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nbAnsweredQuestion);
        dest.writeInt(this.goodAnswers);
        dest.writeInt(this.nbQuestions);
    }
}
