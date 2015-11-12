package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.adapters.ResultAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;

/**
 * Created by Nathan on 12/11/2015.
 */
public class FragmentResults extends Fragment implements View.OnClickListener {
    private ListView view;
    private ResultAdapter adapter;
    private List<Question> listQuestion;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.result_answer_fragment,container,false);
        ListView insertPoint = (ListView) rootView.findViewById(R.id.result_answer_layout);
        Button myButton = (Button) rootView.findViewById(R.id.back_to_result);
        myButton.setOnClickListener(this);
        view = insertPoint;
        adapter = new ResultAdapter(listQuestion );
        view.setAdapter(adapter);
        return rootView;
    }

    public static FragmentResults newInstance(List<Question> list){
        FragmentResults newFragment = new FragmentResults();
        newFragment.setQuestion(list);
        return newFragment;
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
        questionListener.onResultQuizz(listQuestion, false);

    }
}
