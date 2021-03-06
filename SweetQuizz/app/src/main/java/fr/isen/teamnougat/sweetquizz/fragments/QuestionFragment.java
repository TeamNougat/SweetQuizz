package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.activities.QuizzActivity;
import fr.isen.teamnougat.sweetquizz.adapters.AnswerAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.QuestionListener;
import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;
import fr.isen.teamnougat.sweetquizz.model.quizz.Quizz;
import fr.isen.teamnougat.sweetquizz.views.MyAnswerButton;

/**
 * Created by dhawo on 24-Oct-15.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {
    private Question question;
    AnswerAdapter adapter;
    ListView view;
    private ImageButton fab;
    private Animation fabTrue, fabFalse;
    private TextRoundCornerProgressBar progress_bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.question_fragment_layout, container, false);

        /**Setup the question text**/
        TextView questionView = (TextView) rootView.findViewById(R.id.question);
        questionView.setText(question.getText());


        /*****************************/

        ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.answers_layout);
        view = (ListView) insertPoint;

        adapter = new AnswerAdapter(question.getAnswers());
        view.setAdapter(adapter);
        ImageButton test = (ImageButton) rootView.findViewById(R.id.fab);
        fab = test;
        fabTrue = AnimationUtils.loadAnimation(SweetQuizz.getAppContext(), R.anim.rotate_true);
        fabFalse = AnimationUtils.loadAnimation(SweetQuizz.getAppContext(), R.anim.rotate_false);
        fab.setOnClickListener(this);

        progress_bar = (TextRoundCornerProgressBar) rootView.findViewById(R.id.progress_bar_question);
        progress_bar.setProgressColor(Color.parseColor("#3c56ca"));
        progress_bar.setBackgroundColor(Color.WHITE);
        progress_bar.setMax(Constants.QuestionFragmentConstants.MAX_PROGRESS_BAR);
        QuestionListener questionListener = (QuestionListener)getActivity();
        QuizzActivity activity = (QuizzActivity)getActivity();
        String where_I_Am = (activity.getMyQuizz().getNbAnsweredQuestions()+1) + " / " + activity.getMyQuizz().getQuestions().size();
        progress_bar.setProgressText(where_I_Am);
        progress_bar.setProgress((activity.getMyQuizz().getNbAnsweredQuestions() +1 ) * Constants.QuestionFragmentConstants.PROGRESS_BAR_SET);
        return rootView;
    }

    public static QuestionFragment newInstance(Question question) {
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

    public void saveCheckedAnswers() {
        for (int i = 0; i < adapter.getCount(); i++) {
            MyAnswerButton but = (MyAnswerButton) view.getChildAt(i);
            Answer answer = (Answer) adapter.getItem(i);
            answer.setIsChecked(but.isChecked());
        }
    }

    public void goToNextQuestion() {
        QuestionListener listener = (QuestionListener) getActivity();
        listener.onNextQuestion();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(fab)){
            saveCheckedAnswers();
            if(question.checkAnswer() == true){
                startFabAnimation(fab, true);
            }
            else {
                startFabAnimation(fab, false);
            }
        }
    }

    public void startFabAnimation(ImageButton btn, boolean bool){
        Animation rotate;
        if(bool == false){
            btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.fabColorFalse)));
            btn.setImageResource(R.drawable.ic_clear_white_24dp);
            rotate = AnimationUtils.loadAnimation(SweetQuizz.getAppContext(), R.anim.rotate_false);
        }
        else{
            btn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.fabColorTrue)));
            rotate = AnimationUtils.loadAnimation(SweetQuizz.getAppContext(), R.anim.rotate_true);
        }
        btn.setAnimation(rotate);
        btn.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goToNextQuestion();
            }
        });
    }
}
