package fr.isen.teamnougat.sweetquizz.fragments;

import android.os.Bundle;

import fr.isen.teamnougat.sweetquizz.adapters.ThemesListAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class ThemesSelectionFragment extends SelectionFragment{
    private ThemesListAdapter mAdapter;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Themes.fetchThemes((ServerListener) getActivity());
    }

    public void setmAdapter(ThemesListAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.getmRecyclerView().setAdapter(this.mAdapter);
    }

    public ThemesListAdapter getmAdapter() {
        return mAdapter;
    }
}
