package fr.isen.teamnougat.sweetquizz.adapters;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;
import fr.isen.teamnougat.sweetquizz.views.MyAnswerButton;

/**
 * Created by dhawo on 25-Oct-15.
 */
public class AnswerAdapter extends BaseAdapter {
    private List<Answer> answers;
    private ListView listView;
    private FloatingActionButton imageButton;

    public void setImageButton(FloatingActionButton imageButton) {
        this.imageButton =imageButton;
    }

    public AnswerAdapter(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public int getCount() {
        return answers.size();
    }

    @Override
    public Object getItem(int position) {
        return answers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyAnswerButton answerButton = new MyAnswerButton(SweetQuizz.getAppContext());
        answerButton.setText(answers.get(position).getText());
        answerButton.setBackgroundColor(Color.WHITE);
        answerButton.setTextColor(Color.BLACK);
        answerButton.setOnClickListener(answerButton);
        answerButton.setTag(imageButton);
        return answerButton;
    }


}
