package com.bitdecay.game.objects.components;

import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.assertFalse;

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

    @Test
    public void testTimeEventTriggered(){
        TimerComponent tim = new TimerComponent(6);
        assertFalse(tim.hasTriggered());
        tim.update(3);
        assertFalse(tim.hasTriggered());
        tim.update(3);
        assert(tim.hasTriggered());
    }

    @Test
    public void testTimeCannotBeReducedBelowZero(){
        TimerComponent tim = new TimerComponent(8);
        assert(tim.timeLeft > 0);
        tim.update(15);
        assert(tim.timeLeft == 0);
    }
}
