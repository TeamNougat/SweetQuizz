package fr.isen.teamnougat.sweetquizz.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.criapp.circleprogresscustomview.CircleProgressView;
import com.filippudak.ProgressPieView.ProgressPieView;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.fragments.Constants;
import fr.isen.teamnougat.sweetquizz.fragments.FragmentResults;
import fr.isen.teamnougat.sweetquizz.fragments.QuestionFragment;
import fr.isen.teamnougat.sweetquizz.model.Result;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;

/**
 * Created by dhawo on 25-Oct-15.
 */
public class QuizzFinishedActivity extends AppCompatActivity implements View.OnClickListener{
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeholder_endquizz);
        result = getIntent().getParcelableExtra("result");
        int scoreResult = (result.getGoodAnswers() * 100 / result.getNbQuestions());

        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("Your success rate :"));
        String pourcentage = result.getGoodAnswers() * 100 / result.getNbAnsweredQuestion() + " %";
        ProgressPieView progressPieView = (ProgressPieView) findViewById(R.id.progress_pie_view);
        progressPieView.setTextSize(60);
        progressPieView.setText(pourcentage);
        progressPieView.setProgressColor(Color.parseColor("#3c56ca"));
        progressPieView.setProgress(scoreResult);
        progressPieView.setBackgroundColor(Color.WHITE);
        progressPieView.setStrokeColor(Color.WHITE);
        Button button = (Button) findViewById(R.id.answer_button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       /* FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        /**Start the first question fragment**/
        //FragmentResults fragmentResults = FragmentResults.newInstance(Constants.QuestionFragmentConstants.ACTUAL_QUESTIONS);
       // transaction.add(R.id.answer_fragment_layout, fragmentResults);
       // transaction.commit();
    }
}
