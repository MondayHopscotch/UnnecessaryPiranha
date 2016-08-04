package com.bitdecay.game;

import com.bitdecay.game.objects.GameEntity;
import com.bitdecay.game.objects.components.BitComponent;
import com.bitdecay.game.objects.interfaces.IUpdate;

/**
 * Created by MondayHopscotch on 8/3/2016.
 */
public class TestObjects {
    public static class TestEntity extends GameEntity {}

    public static class TestUpdateComponent extends BitComponent implements IUpdate {
        public int updateCount = 0;
        @Override
        public void update(float delta) {
            updateCount++;
        }
    }
}
