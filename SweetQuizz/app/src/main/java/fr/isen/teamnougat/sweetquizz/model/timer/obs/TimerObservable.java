package fr.isen.teamnougat.sweetquizz.model.timer.obs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class TimerObservable {
    private List<TimeListener> listeners;

    public TimerObservable() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(TimeListener listener){
        this.listeners.add(listener);
    }

    public void removeListener(TimeListener listener){
        this.listeners.remove(listener);
    }

    public void fireOnTimeChangedEvent(){
        for(TimeListener l : this.listeners){
            l.onTimeChanged();
        }
    }

    public void fireOnTimeEnded(){
        for(TimeListener l : this.listeners){
            l.onTimeEnded();
        }
    }
}
