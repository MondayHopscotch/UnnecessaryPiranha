package com.bitdecay.game.objects.components;

import com.bitdecay.game.objects.GameEntities;
import com.bitdecay.game.objects.GameEntity;
import com.bitdecay.jump.collision.BitWorld;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class WorldLinkComponent extends BitComponent {
    BitWorld world;
    GameEntities entities;

    public WorldLinkComponent(BitWorld world, GameEntities entities) {
        this.world = world;
        this.entities = entities;
    }

    public void addEntity(GameEntity entity) {
        entities.add(entity);
        for (BitComponent comp : entity.getComponents()) {
            if (comp.getClass().isAssignableFrom(PhysicsComponent.class)){
                PhysicsComponent phys = (PhysicsComponent) comp;
                world.addBody(phys.body);
            }
        }
    }

    public void removeEntity(GameEntity entity) {
        entities.remove(entity);
        for (BitComponent comp : entity.getComponents()) {
            if (comp.getClass().isAssignableFrom(PhysicsComponent.class)){
                PhysicsComponent phys = (PhysicsComponent) comp;
                world.removeBody(phys.body);
            }
        }
    }
}
