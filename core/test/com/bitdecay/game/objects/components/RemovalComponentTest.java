package com.bitdecay.game.objects.components;

import com.bitdecay.game.TestObjects;
import com.bitdecay.game.objects.GameEntities;
import com.bitdecay.jump.collision.BitWorld;
import org.junit.Test;

/**
 * Created by MondayHopscotch on 8/3/2016.
 */
public class RemovalComponentTest {

    @Test
    public void testConstructor() {
        BitWorld world = new BitWorld();
        GameEntities entities = new GameEntities();

        WorldLinkComponent worldLink = new WorldLinkComponent(world, entities);

        TimerComponent timer = new TimerComponent(10);
        RemovalComponent comp = new RemovalComponent(worldLink, timer);

        TestObjects.TestEntity testEntity = new TestObjects.TestEntity();
        testEntity.addComponent(worldLink);
        testEntity.addComponent(timer);
        testEntity.addComponent(comp);

        worldLink.addEntity(testEntity);
        entities.update(1);
        assert(entities.gameObjects.contains(testEntity));

        testEntity.update(11);
        entities.update(1);

        assert(!entities.gameObjects.contains(testEntity));
    }
}
