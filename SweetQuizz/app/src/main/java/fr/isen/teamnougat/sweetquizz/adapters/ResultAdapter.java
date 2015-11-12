package fr.isen.teamnougat.sweetquizz.adapters;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;
import fr.isen.teamnougat.sweetquizz.model.quizz.Question;

/**
 * Created by Nathan on 12/11/2015.
 */
public class ResultAdapter extends BaseAdapter {
    private List<Question> question;
    private ListView listView;
    private FloatingActionButton imageButton;

    public void setImageButton(FloatingActionButton imageButton) {
        this.imageButton = imageButton;
    }



    public ResultAdapter(List<Question> answers) {
        this.question = answers;
    }

    @Override
    public int getCount() {
        return question.size();
    }

    @Override
    public Object getItem(int position) {
        return question.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*Button questions = (Button) convertView.findViewById(R.id.result_layout_question_button);
        Button answer = (Button) convertView.findViewById(R.id.result_layout_button_answer_button);*/
        Button questions = new Button(SweetQuizz.getAppContext());

        questions.setText(question.get(position).getText());
        for (Answer a : question.get(position).getAnswers()) {
            if (a.isChecked()) {
                questions.setText(a.getText());
            }
        }
        if (question.get(position).checkAnswer()) {
            questions.setBackgroundColor(Color.GREEN);
            questions.setBackgroundColor(Color.GREEN);
        }
        else {
            questions.setBackgroundColor(Color.RED);
            questions.setBackgroundColor(Color.RED);
        }
        questions.setTextColor(Color.WHITE);
        questions.setTextColor(Color.BLACK);
        return questions;
    }

}
