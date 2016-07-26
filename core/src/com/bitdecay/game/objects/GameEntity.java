package com.bitdecay.game.objects;

import com.bitdecay.game.objects.component.BitComponent;
import com.bitdecay.game.objects.component.IUpdate;

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
