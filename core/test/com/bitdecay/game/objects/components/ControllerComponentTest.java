package com.bitdecay.game.objects.components;

import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.control.ControlMap;
import com.bitdecay.jump.control.PlayerInputController;
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
        BitBody body = new BitBody();
        PlayerInputController controller = new PlayerInputController(controlMap);
        ControllerComponent controls = new ControllerComponent(body, controller);
        assertTrue(body.controller == controller);
    }

    @Test
    public void testEnableDisable() {
        GDXControls map = new GDXControls();

        BitBody body = new BitBody();

        PlayerInputController bodyController = new PlayerInputController(map);

        ControllerComponent controls = new ControllerComponent(body, bodyController);

        controls.disable();

        assertFalse("Component disables underlying control map", map.isEnabled());

        controls.enable();

        assertTrue("Component enables underlying control map", map.isEnabled());
    }
}
