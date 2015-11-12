package fr.isen.teamnougat.sweetquizz.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


import com.criapp.circleprogresscustomview.CircleProgressView;
import com.filippudak.ProgressPieView.ProgressPieView;
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
        int scoreResult = (result.getGoodAnswers() * 100 / result.getNbQuestions());

        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        resultTextView.setText(String.format("You have %d good answers out of %d", result.getGoodAnswers(), result.getNbQuestions()));
        String pourcentage = result.getGoodAnswers() * 100 / result.getNbAnsweredQuestion() + " %";

        ProgressPieView progressPieView = (ProgressPieView) findViewById(R.id.progress_pie_view);
        progressPieView.setTextSize(60);
        progressPieView.setText(pourcentage);
        progressPieView.setProgressColor(Color.parseColor("#3c56ca"));
        progressPieView.setProgress(scoreResult);
        progressPieView.setBackgroundColor(Color.WHITE);
        progressPieView.setStrokeColor(Color.WHITE);
    }
}
