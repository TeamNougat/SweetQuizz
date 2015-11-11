package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.adapters.AnswerAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;
import fr.isen.teamnougat.sweetquizz.views.MyAnswerButton;

/**
 * Created by dhawo on 24-Oct-15.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener{
    private Question question;
    AnswerAdapter adapter;
    ListView view;
    private RoundCornerProgressBar progress_bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.question_fragment_layout,container,false);
        /**Setup the question text**/
        TextView questionView = (TextView)rootView.findViewById(R.id.question);
        questionView.setText(question.getText());


        progress_bar = (RoundCornerProgressBar) rootView.findViewById(R.id.progress_bar_question);
        progress_bar.setProgressColor(Color.parseColor("#3c56ca"));
        progress_bar.setBackgroundColor(Color.WHITE);
        progress_bar.setMax(Constants.QuestionFragmentConstants.MAX_PROGRESS_BAR);
        progress_bar.setProgress(question.getQuestionsNumbers() * Constants.QuestionFragmentConstants.PROGRESS_BAR_SET);




        /*****************************/

        ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.answers_layout);
        view = (ListView)insertPoint;

        FloatingActionButton imageButton = (FloatingActionButton)rootView.findViewById(R.id.checked_button);
        adapter = new AnswerAdapter(question.getAnswers());
        adapter.setImageButton(imageButton);
        view.setAdapter(adapter);


        /***Add Listener on Validate Button***/
        Button button = (Button)rootView.findViewById(R.id.validate);
        button.setOnClickListener(this);
        return rootView;
    }



    public static QuestionFragment newInstance(Question question){
        QuestionFragment newFragment = new QuestionFragment();
        newFragment.setQuestion(question);
        return newFragment;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void saveCheckedAnswers(){
        for(int i=0;i<adapter.getCount();i++){
            MyAnswerButton but = (MyAnswerButton)view.getChildAt(i);
            Answer answer = (Answer)adapter.getItem(i);
            answer.setIsChecked(but.isChecked());
        }
    }

    public void goToNextQuestion(){
        saveCheckedAnswers();
        QuestionListener listener = (QuestionListener)getActivity();
        listener.onNextQuestion();
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            goToNextQuestion();
        }
    }
}
