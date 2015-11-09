package fr.isen.teamnougat.sweetquizz.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuestion;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.fragments.QuestionFragment;
import fr.isen.teamnougat.sweetquizz.fragments.TimerFragment;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.listeners.QuizzRetrievedListener;
import fr.isen.teamnougat.sweetquizz.model.Result;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTime;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;
import fr.isen.teamnougat.sweetquizz.model.timer.obs.TimeListener;

public class QuizzActivity extends AppCompatActivity implements TimeListener,QuestionListener,QuizzRetrievedListener {
    private Quizz myQuizz;
    private QuestionFragment questionFragment;
    private TimerFragment timerFragment;
    private ImageButton btn_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_quizz);

        TextView view = (TextView)this.findViewById(R.id.quizz_title);
        view.setText(getIntent().getStringExtra("name"));
        Quizz.fetchQuestions(getIntent().getStringExtra("name"), this);
    }

    @Override
    public void onQuizzRetrieved(Quizz quizz) {
        myQuizz = quizz;
        myQuizz.getTimer().getUnderlyingTime().addListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        /**Start the timer fragment**/
        timerFragment =  TimerFragment.newInstance(myQuizz.getTimer());
        transaction.add(R.id.timerfragment_layout, timerFragment);

        /**Start the first question fragment**/
        questionFragment = QuestionFragment.newInstance(myQuizz.getQuestion(0));
        transaction.add(R.id.questionfragment_layout, questionFragment);
        transaction.commit();

        loadQuestion();
    }

    private void loadQuestion(){
        if(myQuizz.getNbAnsweredQuestions() < myQuizz.getQuestions().size()){
            Question question = myQuizz.getQuestions().get(myQuizz.getNbAnsweredQuestions());

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            /**Start the first question fragment**/
            QuestionFragment questionFragment = QuestionFragment.newInstance(question);
            transaction.replace(R.id.questionfragment_layout, questionFragment);
            transaction.commit();
        }else{
            loadEndQuizz();
        }
    }

    public void loadEndQuizz(){
        myQuizz.getTimer().stopQuizzTimer();
        Result result = myQuizz.calculateResult();
        Intent intent = new Intent(this,QuizzFinishedActivity.class);
        intent.putExtra("result",result);
        startActivity(intent);
    }


    @Override
    public void onTimeChanged() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run()
            {
                TextView quizzTimerView = (TextView) findViewById(R.id.timer_text_view);
                if(quizzTimerView != null){
                    quizzTimerView.setText(myQuizz.getTimer().getUnderlyingTime().getHumanReadableTime());
                }
            }
        });
    }

    @Override
    public void onTimeEnded() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run() {
                loadEndQuizz();
                myQuizz.getTimer().stopQuizzTimer();
            }
        });
    }

    @Override
    public void onNextQuestion() {
        myQuizz.incrementAnsweredQuestions();
        loadQuestion();
    }

    @Override
    public void onBackPressed() {
        myQuizz.getTimer().stopQuizzTimer();
        super.onBackPressed();
    }
}
