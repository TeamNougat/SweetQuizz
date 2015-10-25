package fr.isen.teamnougat.sweetquizz.model.timer;

import java.util.Date;
import java.util.Timer;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class QuizzTimer {
    private QuizzTimerTask task;
    private Timer timer;
    private static QuizzTime DEFAULT_QUIZZ_TIME = new QuizzTime(0,15,0);


    public QuizzTimer() {
        task = new QuizzTimerTask(DEFAULT_QUIZZ_TIME);
    }

    public QuizzTimer(QuizzTime time) {
        task = new QuizzTimerTask(time);
    }

    public void startQuizzTimer(){
        try{
        this.timer = new Timer();
        this.timer.schedule(task, new Date(), 1000);
        }catch(Exception ex){

        }
    }

    public void stopQuizzTimer(){
        this.timer.cancel();
    }

    public void resumeQuizzTimer(){
        this.timer = new Timer();
        this.timer.schedule(task, new Date(), 1000);
    }


    public void resetQuizzTimer(QuizzTime time){
        this.task = new QuizzTimerTask(time);
    }

    public QuizzTime getUnderlyingTime(){
        return this.task.getQuizzTime();
    }

}
