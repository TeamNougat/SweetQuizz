package fr.isen.teamnougat.sweetquizz.fragments;

import android.content.Context;

import fr.isen.teamnougat.sweetquizz.adapters.ThemesListAdapter;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class ThemesSelectionFragment extends SelectionFragment{
    private ThemesListAdapter mAdapter;

    public void setmAdapter(ThemesListAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.getmRecyclerView().setAdapter(this.mAdapter);
    }

    public ThemesListAdapter getmAdapter() {
        return mAdapter;
    }
}
