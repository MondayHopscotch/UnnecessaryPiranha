package com.bitdecay.game.objects.components;

import com.bitdecay.game.objects.GameEntities;
import com.bitdecay.game.objects.GameEntity;
import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.BodyType;
import com.bitdecay.jump.collision.BitWorld;
import com.bitdecay.jump.level.Level;
import org.junit.Test;

/**
 * Created by MondayHopscotch on 7/28/2016.
 */
public class WorldLinkComponentTest {

    @Test
    public void testBodiesAddedToWorld() {
        BitWorld world = new BitWorld();
        Level level = new Level(32);
        world.setLevel(level);

        GameEntities entities = new GameEntities();

        WorldLinkComponent worldLink = new WorldLinkComponent(world, entities);

        MockGameObject obj = new MockGameObject();

        worldLink.addEntity(obj);
        assert(worldLink.entities.pendingAdds.contains(obj));

        worldLink.world.step(BitWorld.STEP_SIZE * 1.5f);
        assert(worldLink.world.getStaticBodies().contains(obj.body));
    }

    private static class MockGameObject extends GameEntity {
        BitBody body = new BitBody();
        PhysicsComponent physics;

        public MockGameObject() {
            body = new BitBody();
            body.bodyType = BodyType.STATIC;
            physics = new PhysicsComponent(body, new PositionComponent());

            components.add(physics);
        }
    }
}
