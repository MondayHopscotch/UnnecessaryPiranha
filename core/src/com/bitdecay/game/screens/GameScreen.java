package com.bitdecay.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitdecay.game.control.Xbox360Pad;
import com.bitdecay.game.objects.PlayerObject;
import com.bitdecay.jump.collision.BitWorld;
import com.bitdecay.jump.control.PlayerAction;
import com.bitdecay.jump.control.PlayerInputController;
import com.bitdecay.jump.gdx.input.ControllerButtonState;
import com.bitdecay.jump.gdx.input.ControllerPOVState;
import com.bitdecay.jump.gdx.input.GDXControls;
import com.bitdecay.jump.leveleditor.render.LibGDXWorldRenderer;
import com.bitdecay.jump.leveleditor.utils.LevelUtilities;

/**
 * Created by MondayHopscotch on 7/19/2016.
 */
public class GameScreen implements Screen {

    Game game;
    Texture backgroundTexture;
    Sprite backgroundImage;
    LibGDXWorldRenderer worldRenderer = new LibGDXWorldRenderer();

    OrthographicCamera camera = new OrthographicCamera(512, 448);

    SpriteBatch batch = new SpriteBatch();

    BitWorld world = new BitWorld();


    public GameScreen(Game game, Controller controller) {
        this.game = game;

        GDXControls controls = new GDXControls();
        controls.set(PlayerAction.JUMP, new ControllerButtonState(controller, Xbox360Pad.BUTTON_A));
        controls.set(PlayerAction.UP, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_UP));
        controls.set(PlayerAction.DOWN, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_DOWN));
        controls.set(PlayerAction.LEFT, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_LEFT));
        controls.set(PlayerAction.RIGHT, new ControllerPOVState(controller, Xbox360Pad.BUTTON_DPAD_RIGHT));

        PlayerInputController bbController = new PlayerInputController(controls);

        world.setGravity(0, -900);

        world.setLevel(LevelUtilities.loadLevel("Levels/betaFish.level"));

        PlayerObject ourPlayer = new PlayerObject(bbController);
        world.addBody(ourPlayer.physics.body);
    }

    @Override
    public void show() {
        backgroundTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        backgroundImage = new Sprite(backgroundTexture);
    }

    @Override
    public void render(float delta) {
        world.step(delta);
        camera.update();
        worldRenderer.render(world,camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

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
