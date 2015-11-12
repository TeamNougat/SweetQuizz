package fr.isen.teamnougat.sweetquizz.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.model.quizz.Question;

/**
 * Created by dhawo on 25-Oct-15.
 */
@Table(name = "results")
public class Result extends Model implements Parcelable {
    @Column
    private int nbAnsweredQuestion;
    @Column
    private int goodAnswers;
    @Column
    private int nbQuestions;
    @Column(name = "quizz_name" ,unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private String quizz_name;


    public Result() {
    }


    public Result(int nbAnsweredQuestion, int goodAnswers, int nbQuestions, String quizz) {
        this.nbAnsweredQuestion = nbAnsweredQuestion;
        this.goodAnswers = goodAnswers;
        this.nbQuestions = nbQuestions;
        this.quizz_name = quizz;
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
