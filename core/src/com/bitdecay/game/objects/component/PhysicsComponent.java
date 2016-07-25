package com.bitdecay.game.objects.component;

import com.bitdecay.jump.BitBody;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class PhysicsComponent implements BitComponent, IUpdate {
    public BitBody body;
    PositionComponent position;

    public PhysicsComponent(BitBody body, PositionComponent position) {
        this.body = body;
        this.position = position;
    }

    @Override
    public void update(float delta) {
        position.x = body.aabb.xy.x;
        position.y = body.aabb.xy.y;
    }
}
