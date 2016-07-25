package com.bitdecay.game.objects;

import com.bitdecay.game.objects.component.BitComponent;

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
}
