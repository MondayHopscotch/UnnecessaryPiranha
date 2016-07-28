package com.bitdecay.game.objects;

import com.bitdecay.game.objects.component.IUpdate;
import com.bitdecay.jump.leveleditor.example.game.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class GameObjects {
    List<GameObject> gameObjects;
    List<GameObject> pendingAdds;
    List<GameObject> pendingRemoves;

    public GameObjects() {
        gameObjects = new ArrayList<GameObject>();
        pendingAdds = new ArrayList<GameObject>();
        pendingRemoves = new ArrayList<GameObject>();
    }
}
