package com.bitdecay.game.objects;

import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class GameObjectsTest {

    @Test
    public void testConstructor() {
        GameObjects go = new GameObjects();

        assert (go.gameObjects.isEmpty());
        assert (go.pendingAdds.isEmpty());
        assert (go.pendingRemoves.isEmpty());
    }
}
