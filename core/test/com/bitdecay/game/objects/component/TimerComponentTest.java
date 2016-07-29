package com.bitdecay.game.objects.component;

import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class TimerComponentTest {

    @Test
    public void testConstructor(){
        TimerComponent tim = new TimerComponent(10);
        assert(tim.timeLeft > 0);
    }

    @Test
    public void testTimeReduction(){
        TimerComponent tim = new TimerComponent(5);
        assert(tim.timeLeft == 5);
        tim.update(3.4568f);
        assert(tim.timeLeft == 5-3.4568f);
    }
}
