package com.bitdecay.game.objects.component;


/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class TimerComponent implements BitComponent, IUpdate {
    float timeLeft;

    public TimerComponent (int time) {
        timeLeft = time;
    }

    @Override
    public void update(float delta) {
        timeLeft -= delta;
        if (timeLeft <= 0) {
            //TODO REMOVE YO'SELF!!!!... in whichever fashion suits you
        }
    }
}
