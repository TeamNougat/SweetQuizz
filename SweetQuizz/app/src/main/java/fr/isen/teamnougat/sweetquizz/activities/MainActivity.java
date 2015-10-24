package fr.isen.teamnougat.sweetquizz.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import JsonUtil.JsonParsingQuestion;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTime;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;
import fr.isen.teamnougat.sweetquizz.model.timer.obs.TimeListener;

public class MainActivity extends AppCompatActivity implements TimeListener {
    private QuizzTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fr.isen.teamnougat.sweetquizz.R.layout.activity_main);

        /**This is for testing purposes**/
        timer = new QuizzTimer(new QuizzTime(0,0,20));
        timer.getUnderlyingTime().addListener(this);

        /*********************************/

        /**Test parsing Json**/
        String myJson = "{\"quizz\" : [{\"text\":\"Quelle est la couleur du cheval blanc d\'Henri IV ?\",\"answers\":[{\"text\" : \"Bleu\", \"isTrue\" : \"false\"},{\"text\" : \"Blanc\", \"isTrue\" : \"true\"}]},{\"text\":\"Quelle est le sens de la vie ?\",\"answers\":[{\"text\" : \"42\", \"isTrue\" : \"true\"},{\"text\" : \"Aller à l\'ISEN\", \"isTrue\" : \"false\"},{\"text\" : \"Manger de la choucroute\", \"isTrue\" : \"true\"}]}],\"desc\" : \"Ceci est un quizz de test lambda, il est vraiment nul en vrai\"}";
        JsonParsingQuestion myJsonParsed = new JsonParsingQuestion(myJson);
        /*********************/

        /**Test instantiate Quizz**/
        Quizz myQuizz = new Quizz(myJsonParsed.getQuestionList(), timer);
        /**************************/

        timer.startQuizzTimer();


    }

    @Override
    protected void onStart() {
        super.onStart();


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

        //noinspection SimplifiableIfStatement
        if (id == fr.isen.teamnougat.sweetquizz.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTimeChanged() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run()
            {
                TextView quizzTimerView = (TextView) findViewById(R.id.timer_text_view);
                quizzTimerView.setText(timer.getUnderlyingTime().getHumanReadableTime());
            }
        });

    }

    @Override
    public void onTimeEnded() {
        runOnUiThread(new Runnable() { //We need to run on UI thread to touch the views
            public void run() {
                TextView quizzTimerView = (TextView) findViewById(R.id.timer_text_view);
                quizzTimerView.setText(getString(R.string.quizz_ended));
            }
        });

        this.timer.stopQuizzTimer();
    }
}
