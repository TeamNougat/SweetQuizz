package fr.isen.teamnougat.sweetquizz.fragments;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.adapters.QuizzListAdapter;
import fr.isen.teamnougat.sweetquizz.adapters.ThemesListAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizzes;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class QuizzSelectionFragment extends SelectionFragment {
    private String themeName;
    private QuizzListAdapter mAdapter;

    public static QuizzSelectionFragment newInstance(String themeName){
        final Bundle args = new Bundle();
        QuizzSelectionFragment newFragment = new QuizzSelectionFragment();
        args.putString("name",themeName);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeName = getArguments().getString("name");
        ServerQuizzes.fetchQuizzes(themeName,(ServerListener)getActivity());
    }

    public void setmAdapter(QuizzListAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.getmRecyclerView().setAdapter(this.mAdapter);
    }

    public QuizzListAdapter getmAdapter() {
        return mAdapter;
    }
}
