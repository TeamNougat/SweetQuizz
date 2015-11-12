package fr.isen.teamnougat.sweetquizz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.LinkedList;
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
    private LayoutInflater layoutInflater;
    private Context context;
    private Boolean isSet;


    public ResultAdapter(List<Question> myList) {
        this.question = myList;
        isSet = false;
        context = SweetQuizz.getAppContext();
        layoutInflater = LayoutInflater.from(context);
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
            convertView = layoutInflater.inflate(R.layout.result_layout, null);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        int index = position + 1;
        mViewHolder.question_button.setText("Question " + index);
        mViewHolder.question_button.setWidth(parent.getWidth());
        mViewHolder.question_button.setVisibility(View.VISIBLE);
        Iterator<Button> it = mViewHolder.listButton.iterator();
        int i = 0;
        for (Answer a : question.get(position).getAnswers()) {
            if (a.isChecked()) {
                mViewHolder.listButton.get(i).setText(a.getText());
                mViewHolder.listButton.get(i).setWidth(parent.getWidth());
                mViewHolder.listButton.get(i).setVisibility(View.VISIBLE);
                if (a.isTrue()) {
                    mViewHolder.listButton.get(i).setBackgroundColor(Color.GREEN);
                    i++;
                } else if (!a.isTrue()) {
                    mViewHolder.listButton.get(i).setBackgroundColor(Color.RED);
                    i++;
                }
            }
        }
        return convertView;
    }

    private class MyViewHolder {
        public LinearLayout linearLayout;
        public Button question_button;
        public Button answer1, answer2, answer3, answer4, answer5, answer6;
        public LinkedList<Button> listButton;



        public MyViewHolder(View item) {
            listButton = new LinkedList<>();
            question_button = (Button) item.findViewById(R.id.question_button);
            answer1 = (Button) item.findViewById(R.id.answer_button1);
            answer2 = (Button) item.findViewById(R.id.answer_button2);
            answer3 = (Button) item.findViewById(R.id.answer_button3);
            answer4 = (Button) item.findViewById(R.id.answer_button4);
            answer5 = (Button) item.findViewById(R.id.answer_button5);
            listButton.add(0, answer1);
            listButton.add(1,answer2);
            listButton.add(2,answer3);
            listButton.add(3,answer4);
            listButton.add(4,answer5);
            listButton.add(5,answer6);



        }
    }

}
