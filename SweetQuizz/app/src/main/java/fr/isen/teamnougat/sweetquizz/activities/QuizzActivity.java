package fr.isen.teamnougat.sweetquizz.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import fr.isen.teamnougat.sweetquizz.JsonUtil.JsonParsingQuestion;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.fragments.QuestionFragment;
import fr.isen.teamnougat.sweetquizz.fragments.TimerFragment;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.model.Result;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTime;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;
import fr.isen.teamnougat.sweetquizz.model.timer.obs.TimeListener;

public class QuizzActivity extends AppCompatActivity implements TimeListener,QuestionListener {
    private QuizzTimer timer;
    private Quizz myQuizz;
    private QuestionFragment questionFragment;
    private TimerFragment timerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_quizz);

        /**This is for testing purposes**/
        timer = new QuizzTimer(new QuizzTime(0,1,0));
        timer.getUnderlyingTime().addListener(this);

        /*********************************/

        /**Test parsing Json**/
        String myJson = "{\"quizz\" : [{\"text\":\"Quelle est la couleur du cheval blanc d\'Henri IV ?\",\"answers\":[{\"text\" : \"Bleu\", \"isTrue\" : \"false\"},{\"text\" : \"Blanc\", \"isTrue\" : \"true\"}]},{\"text\":\"Quelle est le sens de la vie ?\",\"answers\":[{\"text\" : \"42\", \"isTrue\" : \"true\"},{\"text\" : \"Aller à l\'ISEN\", \"isTrue\" : \"false\"},{\"text\" : \"Manger de la choucroute\", \"isTrue\" : \"true\"}]}],\"desc\" : \"Ceci est un quizz de test lambda, il est vraiment nul en vrai\",\"name\" : \"first\"}";
        JsonParsingQuestion myJsonParsed = new JsonParsingQuestion(myJson);
        myQuizz = new Quizz(myJsonParsed.getQuestionList(), myJsonParsed.getNameQuizz());

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        /**Start the timer fragment**/
        timerFragment =  TimerFragment.newInstance(timer);
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
        Result result = myQuizz.calculateResult();
        Intent intent = new Intent(this,QuizzFinishedActivity.class);
        intent.putExtra("result",result);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(fr.isen.teamnougat.sweetquizz.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

/*        //noinspection SimplifiableIfStatement
        if (id == fr.isen.teamnougat.sweetquizz.R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTimeChanged() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run()
            {
                TextView quizzTimerView = (TextView) findViewById(R.id.timer_text_view);
                if(quizzTimerView != null){
                    quizzTimerView.setText(timer.getUnderlyingTime().getHumanReadableTime());
                }

            }
        });

    }

    @Override
    public void onTimeEnded() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run() {
                loadEndQuizz();
                timer.stopQuizzTimer();
            }
        });


    }

    @Override
    public void onNextQuestion() {
        myQuizz.incrementAnsweredQuestions();
        loadQuestion();
    }
}
