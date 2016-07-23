package com.bitdecay.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.BodyType;
import com.bitdecay.jump.JumperBody;
import com.bitdecay.jump.properties.BitBodyProperties;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class PlayerObject {
    Sprite playerSprite;

    JumperBody playerBody = new JumperBody();


    public BitBody getBody() {
        playerBody.aabb.width = 32;
        playerBody.aabb.height = 64;
        playerBody.bodyType = BodyType.DYNAMIC;
        playerBody.props = new BitBodyProperties();

        return playerBody;
    }
}
