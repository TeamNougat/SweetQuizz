package fr.isen.teamnougat.sweetquizz.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.filippudak.ProgressPieView.ProgressPieView;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.adapters.ResultAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.model.Result;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;

/**
 * Created by Nathan on 12/11/2015.
 */
public class EndQuizzFragment extends android.app.Fragment implements View.OnClickListener {

    private ListView view;
    private ResultAdapter adapter;
    private Result result;
    private List<Question> listQuestion;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.placeholder_endquizz,container,false);
        int scoreResult = (result.getGoodAnswers() * 100 / result.getNbQuestions());

        TextView resultTextView = (TextView)rootView.findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("Your success rate :"));
        String pourcentage = result.getGoodAnswers() * 100 / result.getNbAnsweredQuestion() + " %";
        ProgressPieView progressPieView = (ProgressPieView) rootView.findViewById(R.id.progress_pie_view);
        progressPieView.setTextSize(60);
        progressPieView.setText(pourcentage);
        progressPieView.setProgressColor(Color.parseColor("#3c56ca"));
        progressPieView.setProgress(scoreResult);
        progressPieView.setBackgroundColor(Color.WHITE);
        progressPieView.setStrokeColor(Color.WHITE);
        Button button = (Button) rootView.findViewById(R.id.answer_button);
        button.setOnClickListener(this);
        //adapter = new ResultAdapter(listQuestion);
        //view.setAdapter(adapter);

        return rootView;
    }

    public static EndQuizzFragment newInstance(List<Question> list, Result result){
        EndQuizzFragment newFragment = new EndQuizzFragment();
        newFragment.setQuestion(list);
        newFragment.setResult(result);
        return newFragment;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void setQuestion(List<Question> list) {
        this.listQuestion = list;
    }

    @Override
    public void onClick(View v) {
        QuestionListener questionListener = (QuestionListener) getActivity();
        questionListener.onResultQuizz(listQuestion, true);
    }
}
