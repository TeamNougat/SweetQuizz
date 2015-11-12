package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.R;
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
    private Context context;
    private LayoutInflater layoutInflater;

    public void setImageButton(FloatingActionButton imageButton) {
        this.imageButton = imageButton;
    }

    public ResultAdapter(List<Question> myList) {
        this.question = myList;
        layoutInflater = LayoutInflater.from(SweetQuizz.getAppContext());
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
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.result_layout,null);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }


        for (Answer a : question.get(position).getAnswers()) {
            if (a.isChecked()) {
                mViewHolder.answerB.setText(a.getText());
            }
        }
        if (question.get(position).checkAnswer()) {

            mViewHolder.answerB.setBackgroundColor(Color.GREEN);
        }
        else {

            mViewHolder.answerB.setBackgroundColor(Color.RED);
        }

        mViewHolder.answerB.setTextColor(Color.BLACK);

        return convertView;
        /*convertView= (View) layoutInflater.inflate(R.layout.result_layout);
        /*Button questions = (Button) convertView.findViewById(R.id.result_layout_question_button);
        Button answer = (Button) convertView.findViewById(R.id.result_layout_button_answer_button);
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
        return questions;*/
    }

    private class MyViewHolder {
        Button answerB;


        public MyViewHolder(View item) {
            answerB = (Button) item.findViewById(R.id.result_layout_button_answer_button);

        }
    }

}
