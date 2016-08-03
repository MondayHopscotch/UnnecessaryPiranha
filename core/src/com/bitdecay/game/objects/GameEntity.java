package com.bitdecay.game.objects;

import com.bitdecay.game.objects.components.BitComponent;
import com.bitdecay.game.objects.interfaces.IUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class GameEntity {
    public List<BitComponent> components;

    public GameEntity() {
        components = new ArrayList();
    }

    public void addComponent(BitComponent component) {
        components.add(component);
    }

    public void update(float delta) {
        for(BitComponent comp : components) {
            if(comp instanceof IUpdate) {
                ((IUpdate) comp).update(delta);
            }
        }
    }
}
