package com.bitdecay.game.objects;

import com.bitdecay.game.objects.component.BitComponent;
import com.bitdecay.game.objects.component.IUpdate;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class GameEntityTest {

    @Test
    public void testEmptyConstructor() {
        TestEntity entity = new TestEntity();
        assert(entity.components != null);
        assert(entity.components.size() == 0);
    }

    @Test
    public void testComponentsUpdate() {
        TestEntity entity = new TestEntity();
        TestUpdateComponent component = new TestUpdateComponent();
        entity.addComponent(component);

        entity.update(0);

        assertTrue("Update was called", component.updateCount == 1);
    }

    private static class TestEntity extends GameEntity {}

    private static class TestUpdateComponent implements BitComponent, IUpdate {
        public int updateCount = 0;
        @Override
        public void update(float delta) {
            updateCount++;
        }
    }
}
