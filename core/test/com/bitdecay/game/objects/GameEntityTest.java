package com.bitdecay.game.objects;

import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class GameEntityTest {

    @Test
    public void testEmptyConstructor() {
        GameEntity entity = new GameEntity();
        assert(entity.components != null);
        assert(entity.components.size() == 0);
    }
}
