package com.bitdecay.game.objects;

import com.bitdecay.jump.control.PlayerInputController;
import com.bitdecay.jump.gdx.input.GDXControls;
import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class GameEntitiesTest {

    @Test
    public void testConstructor() {
        GameEntities go = new GameEntities();

        assert (go.gameObjects.isEmpty());
        assert (go.pendingAdds.isEmpty());
        assert (go.pendingRemoves.isEmpty());
    }

    @Test
    public void testAdd() {
        GameEntities go = new GameEntities();

        PlayerObject player = new PlayerObject(new PlayerInputController(GDXControls.defaultMapping));

        go.add(player);

        assert(!go.gameObjects.contains(player));
        assert(go.pendingAdds.contains(player));

        go.update(.1f);

        assert(!go.pendingAdds.contains(player));
        assert(go.gameObjects.contains(player));
    }

    @Test
    public void testRemove() {
        GameEntities entities = new GameEntities();

        PlayerObject player = new PlayerObject(new PlayerInputController(GDXControls.defaultMapping));

        entities.add(player);

        entities.update(1);

        assert(entities.gameObjects.contains(player));

        entities.remove(player);

        assert(entities.pendingRemoves.contains(player));

        entities.update(1);

        assert(!entities.gameObjects.contains(player));
    }
}
