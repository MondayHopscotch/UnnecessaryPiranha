package com.bitdecay.game.objects.component;

import com.bitdecay.jump.BitBody;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class PhysicsComponentTest {

    @Test
    public void testConstructor() {
        BitBody body = new BitBody();
        PositionComponent position = new PositionComponent();

        PhysicsComponent physics = new PhysicsComponent(body, position);
        assert(physics != null);
    }

    @Test
    public void testPositionUpdated() {
        BitBody body = new BitBody();
        PositionComponent position = new PositionComponent();

        PhysicsComponent physics = new PhysicsComponent(body, position);
        body.aabb.xy.set(50, 100);

        physics.update(0);

        assertTrue(position.x == 50);
        assertTrue(position.y == 100);
    }
}
