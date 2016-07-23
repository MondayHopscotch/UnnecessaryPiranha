package com.bitdecay.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.bitdecay.game.control.Xbox360Pad;
import com.bitdecay.game.objects.PlayerObject;
import com.bitdecay.jump.BitBody;
import com.bitdecay.jump.collision.BitWorld;
import com.bitdecay.jump.control.BitBodyController;
import com.bitdecay.jump.control.PlayerAction;
import com.bitdecay.jump.control.PlayerInputController;
import com.bitdecay.jump.gdx.input.ControllerButtonState;
import com.bitdecay.jump.gdx.input.ControllerPOVState;
import com.bitdecay.jump.gdx.input.GDXControls;
import com.bitdecay.jump.leveleditor.render.LibGDXWorldRenderer;

import java.util.List;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class GameScreen implements Screen {

    Texture backgroundTexture;
    Sprite backgroundImage;
    LibGDXWorldRenderer worldRenderer = new LibGDXWorldRenderer();

    OrthographicCamera camera = new OrthographicCamera(512, 448);

    SpriteBatch batch = new SpriteBatch();

    BitWorld world = new BitWorld();
    private Controller controller;
    private GDXControls controls = new GDXControls();

    Array<Controller> connectedControllers;

    @Override
    public void show() {
        world.setTileSize(32);
        backgroundTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        backgroundImage = new Sprite(backgroundTexture);

        PlayerObject ourPlayer = new PlayerObject();
        BitBody playerBody = ourPlayer.getBody();
        BitBodyController bbController = new PlayerInputController(controls);
        playerBody.controller = bbController;
        world.addBody(playerBody);

        connectedControllers = Controllers.getControllers();
    }

    @Override
    public void render(float delta) {
        if (controller == null) {
            System.out.println("No controller connected. Press Jump to connect");
            for (Controller cont : connectedControllers) {
                if (cont.getButton(Xbox360Pad.BUTTON_A)) {
                    this.controller = cont;
                    Gdx.app.log("CONTROLLER", controller.getName());
                    controls.set(PlayerAction.JUMP, new ControllerButtonState(controller, Xbox360Pad.BUTTON_A));
                    controls.set(PlayerAction.UP, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_UP));
                    controls.set(PlayerAction.DOWN, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_DOWN));
                    controls.set(PlayerAction.LEFT, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_LEFT));
                    controls.set(PlayerAction.RIGHT, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_RIGHT));
                    break;
                }
            }
         } else {
            if (controls.isJustPressed(PlayerAction.JUMP)) {
                System.out.println("Jump is JUST pressed");
            }
            if (controls.isPressed(PlayerAction.JUMP)) {
                System.out.println("Jump is pressed");
            }
            if (controls.isPressed(PlayerAction.UP)) {
                System.out.println("Up is pressed");
            }
            if (controls.isPressed(PlayerAction.DOWN)) {
                System.out.println("Down is pressed");
            }
            if (controls.isPressed(PlayerAction.LEFT)) {
                System.out.println("Left is pressed");
            }
            if (controls.isPressed(PlayerAction.RIGHT)) {
                System.out.println("Right is pressed");
            }
            world.step(world.STEP_SIZE);
        }

        camera.update();
        worldRenderer.render(world, camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

//        batch.draw(backgroundImage, 0, 0);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
