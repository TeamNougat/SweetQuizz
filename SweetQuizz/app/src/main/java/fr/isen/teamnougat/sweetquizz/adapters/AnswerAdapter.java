package fr.isen.teamnougat.sweetquizz.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.List;

import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.model.quizz.Answer;

/**
 * Created by dhawo on 25-Oct-15.
 */
public class AnswerAdapter extends BaseAdapter {
    private List<Answer> answers;

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
        CheckBox view = new CheckBox(SweetQuizz.getAppContext());
        view.setText(answers.get(position).getText());
        return view;
    }
}
