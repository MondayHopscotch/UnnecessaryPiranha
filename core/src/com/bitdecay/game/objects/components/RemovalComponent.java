package com.bitdecay.game.objects.components;

import com.bitdecay.game.objects.GameEntity;
import com.bitdecay.game.objects.interfaces.IEvent;
import com.bitdecay.game.objects.interfaces.IUpdate;

/**
 * Created by MondayHopscotch on 8/3/2016.
 */
public class RemovalComponent extends BitComponent implements IUpdate {

    private WorldLinkComponent worldLink;
    private IEvent event;

    public RemovalComponent(WorldLinkComponent worldLink, IEvent event) {
        this.worldLink = worldLink;
        this.event = event;
    }


    @Override
    public void update(float delta) {
        if (event.hasTriggered()) {
            worldLink.removeEntity(parent);
        }
    }
}
