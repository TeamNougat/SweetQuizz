package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.model.timer.QuizzTimer;

/**
 * Created by dhawo on 24-Oct-15.
 */
public class TimerFragment extends Fragment {
    private QuizzTimer timer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.timer_fragment_layout,container,false);
        return rootView;
    }

    public static TimerFragment newInstance(QuizzTimer timer){
        TimerFragment newTimer = new TimerFragment();
        newTimer.setTimer(timer);
        return newTimer;
    }

    public QuizzTimer getTimer() {
        return timer;
    }

    public void setTimer(QuizzTimer timer) {
        this.timer = timer;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.timer.startQuizzTimer();
    }
}
