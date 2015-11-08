package fr.isen.teamnougat.sweetquizz.fragments;

import android.os.Bundle;

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
