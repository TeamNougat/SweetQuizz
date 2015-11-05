package fr.isen.teamnougat.sweetquizz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.Result;

/**
 * Created by dhawo on 25-Oct-15.
 */
public class QuizzFinishedActivity extends AppCompatActivity {
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.placeholder_endquizz);
        result = getIntent().getParcelableExtra("result");
        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("You have %d good answers out of %d",result.getGoodAnswers(),result.getNbQuestions()));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,QuizzActivity.class);
        startActivity(intent);
    }

}
