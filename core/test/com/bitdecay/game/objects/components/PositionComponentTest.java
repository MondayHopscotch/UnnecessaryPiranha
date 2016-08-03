package com.bitdecay.game.objects.components;

import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class PositionComponentTest {

    @Test
    public void testConstructor(){
        PositionComponent comp = new PositionComponent();
        assert(comp.x == 0);
        assert(comp.y == 0);
    }
}
