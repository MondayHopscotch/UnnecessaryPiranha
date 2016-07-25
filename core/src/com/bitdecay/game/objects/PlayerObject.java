package com.bitdecay.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bitdecay.game.objects.component.PhysicsComponent;
import com.bitdecay.game.objects.component.PositionComponent;
import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.BodyType;
import com.bitdecay.jump.JumperBody;
import com.bitdecay.jump.geom.BitRectangle;
import com.bitdecay.jump.properties.BitBodyProperties;
import com.bitdecay.jump.properties.JumperProperties;
import com.bitdecay.jump.render.JumperRenderStateWatcher;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class PlayerObject extends GameEntity {
    PositionComponent position;
    PhysicsComponent physics;

    public PlayerObject() {
        physics = createPhysics();
    }

    private PhysicsComponent createPhysics() {
        JumperBody body = new JumperBody();
        body.props.deceleration = 10000;
        body.jumperProps = new JumperProperties();
        body.jumperProps.jumpCount = 1;
        body.renderStateWatcher = new JumperRenderStateWatcher();
        body.bodyType = BodyType.DYNAMIC;
        body.aabb.set(new BitRectangle(0, 0, 16, 32));
        body.userObject = this;

        return new PhysicsComponent(body, position);
    }
}
