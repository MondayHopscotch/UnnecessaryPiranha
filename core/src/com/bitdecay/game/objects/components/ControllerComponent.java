package com.bitdecay.game.objects.components;

import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.control.PlayerInputController;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class ControllerComponent implements BitComponent {
    public BitBody body;
    public PlayerInputController bodyController;

    public ControllerComponent(BitBody body, PlayerInputController bodyController) {
        this.body = body;
        this.bodyController = bodyController;
        body.controller = bodyController;
    }

    public void enable() {
        bodyController.controls.enable();
    }

    public void disable() {
        bodyController.controls.disable();
    }
}
