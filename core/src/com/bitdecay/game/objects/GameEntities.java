package com.bitdecay.game.objects;

import com.bitdecay.game.objects.interfaces.IUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MondayHopscotch on 7/27/2016.
 */
public class GameEntities implements IUpdate {
    public List<GameEntity> gameObjects;
    public List<GameEntity> pendingAdds;
    public List<GameEntity> pendingRemoves;

    public GameEntities() {
        gameObjects = new ArrayList<GameEntity>();
        pendingAdds = new ArrayList<GameEntity>();
        pendingRemoves = new ArrayList<GameEntity>();
    }

    public void add(GameEntity entity) {
        pendingAdds.add(entity);
    }

    public void remove(GameEntity entity) {
        pendingRemoves.add(entity);
    }

    private void doAdds() {
        gameObjects.addAll(pendingAdds);
        pendingAdds.clear();
    }

    private void doRemoves() {
        gameObjects.removeAll(pendingRemoves);
        pendingRemoves.clear();
    }

    @Override
    public void update(float delta) {
        doAdds();
        doRemoves();
    }
}
