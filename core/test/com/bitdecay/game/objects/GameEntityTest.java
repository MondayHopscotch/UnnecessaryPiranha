package com.bitdecay.game.objects;

import com.bitdecay.game.TestObjects;
import com.bitdecay.game.TestObjects.TestEntity;
import com.bitdecay.game.TestObjects.TestUpdateComponent;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class GameEntityTest {

    @Test
    public void testEmptyConstructor() {
        TestEntity entity = new TestEntity();
        assert(entity.getComponents() != null);
        assert(entity.getComponents().size() == 0);
    }

    @Test
    public void testComponentsUpdate() {
        TestEntity entity = new TestEntity();
        TestObjects.TestUpdateComponent component = new TestUpdateComponent();
        entity.addComponent(component);

        entity.update(0);

        assertTrue("Update was called", component.updateCount == 1);
    }
}
