package com.bitdecay.game.objects.component;

import com.bitdecay.jump.control.ControlMap;
import com.bitdecay.jump.gdx.input.GDXControls;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class ControllerComponentTest {

    @Test
    public void testConstructor() {
        ControlMap controlMap = new GDXControls();
        ControllerComponent controls = new ControllerComponent(controlMap);
    }

    @Test
    public void testEnableDisable() {
        GDXControls map = new GDXControls();
        ControllerComponent controls = new ControllerComponent(map);

        controls.disable();

        assertFalse("Component disables underlying control map", map.enabled);

        controls.enable();

        assertTrue("Component enables underlying control map", map.enabled);
    }
}
