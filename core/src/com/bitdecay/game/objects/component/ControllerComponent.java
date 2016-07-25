package com.bitdecay.game.objects.component;

import com.bitdecay.jump.control.ControlMap;

/**
 * Created by MondayHopscotch on 7/24/2016.
 */
public class ControllerComponent implements BitComponent {
    public ControlMap controlMap;

    public ControllerComponent(ControlMap controlMap) {
        this.controlMap = controlMap;
    }

    public void enable() {
        controlMap.enable();
    }

    public void disable() {
        controlMap.disable();
    }
}
