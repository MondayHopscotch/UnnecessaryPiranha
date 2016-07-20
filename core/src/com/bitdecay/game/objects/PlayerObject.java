package com.bitdecay.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bitdecay.jump.BitBody;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class PlayerObject {
    Sprite playerSprite;

    BitBody playerBody = new BitBody();


    public BitBody getBody() {
        playerBody.aabb.width = 32;
        playerBody.aabb.height = 64;
        return playerBody;
    }
}
