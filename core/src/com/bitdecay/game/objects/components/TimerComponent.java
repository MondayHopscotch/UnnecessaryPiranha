package com.bitdecay.game.objects.components;


import com.bitdecay.game.objects.interfaces.IEvent;
import com.bitdecay.game.objects.interfaces.IUpdate;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class TimerComponent implements BitComponent, IUpdate, IEvent {
    float timeLeft;

    public TimerComponent (int time) {
        timeLeft = time;
    }

    @Override
    public void update(float delta) {
        timeLeft -= delta;
        if (timeLeft < 0) {
            timeLeft = 0;
        }
    }

    @Override
    public boolean hasTriggered() {
        return timeLeft <= 0;
    }
}
