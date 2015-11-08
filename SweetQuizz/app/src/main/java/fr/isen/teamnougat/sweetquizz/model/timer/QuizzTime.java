package fr.isen.teamnougat.sweetquizz.model.timer;

import fr.isen.teamnougat.sweetquizz.model.timer.obs.TimerObservable;

/**
 * Created by dhawo on 21-Oct-15.
 */
public class QuizzTime extends TimerObservable {
    private int hours;
    private int minutes;
    private int seconds;


    public QuizzTime(int hours, int minutes, int seconds) {
        super();
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public QuizzTime(int duration){
        super();
        this.hours = duration / 3600;
        duration -= (this.hours*3600);
        this.minutes = duration / 60;
        duration -= (this.minutes*60);
        this.seconds = duration;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void increment(){
        this.seconds++;
        if(this.seconds == 60){
            this.minutes++;
            this.seconds = 0;
            if(this.minutes == 60){
                this.hours++;
                this.minutes = 0;
            }
        }
        fireOnTimeChangedEvent();
    }

    public void decrement(){
        boolean isEnded = false;
        this.seconds--;
        if(this.seconds < 0){
            this.minutes--;
            this.seconds = 59;
            if(this.minutes < 0){
                this.hours--;
                this.minutes = 59;
                if(this.hours < 0 ){
                    isEnded = true;
                }
            }
        }
        if(isEnded){
            fireOnTimeEnded();
        }
        else{
            fireOnTimeChangedEvent();
        }

    }

    public String getHumanReadableTime(){
        return String.format("%d:%02d:%02d",hours, minutes, seconds);
    }
}
