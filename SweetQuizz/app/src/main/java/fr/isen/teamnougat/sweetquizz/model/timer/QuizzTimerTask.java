package fr.isen.teamnougat.sweetquizz.model.timer;

import java.util.TimerTask;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class QuizzTimerTask extends TimerTask {
    private QuizzTime quizzTime;

    public QuizzTimerTask(QuizzTime quizzTime) {
        this.quizzTime = quizzTime;
    }

    public QuizzTime getQuizzTime() {
        return quizzTime;
    }

    @Override
    public void run(){
        this.quizzTime.decrement();
        //Log.i(Logger.GLOBAL_LOGGER_NAME,quizzTime.getHumanReadableTime() );
    }
}