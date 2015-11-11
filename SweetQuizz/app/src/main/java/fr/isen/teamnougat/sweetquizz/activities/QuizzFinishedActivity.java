package fr.isen.teamnougat.sweetquizz.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


import com.criapp.circleprogresscustomview.CircleProgressView;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.fragments.Constants;
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
        TextView pourcentageTextView = (TextView)findViewById(R.id.pourcentTextView);
        resultTextView.setText(String.format("You have %d good answers out of %d", result.getGoodAnswers(), result.getNbQuestions()));
        String pourcentage = result.getGoodAnswers() * 100 / result.getNbAnsweredQuestion() + " %";
        pourcentageTextView.setText(pourcentage);
        CircleProgressView iv = (CircleProgressView) findViewById(R.id.circleProgressBarResults);
        int scoreResult = (result.getGoodAnswers() * 100 / result.getNbQuestions()) * 360 / 100;
        iv.setProgress(scoreResult);
        iv.setColorProgress(Color.parseColor("#3c56ca"));
        iv.setStrokeWidth(10);
    }
}
