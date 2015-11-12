package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.Result;


public class CreditsFragment extends Fragment {

    public CreditsFragment(){
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.credits_layout,container,false);
        setHasOptionsMenu(true);
        return rootView;
    }
}
