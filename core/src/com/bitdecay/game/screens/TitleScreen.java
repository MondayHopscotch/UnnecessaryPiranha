package com.bitdecay.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bitdecay.game.Piranha;
import com.bitdecay.game.control.Xbox360Pad;

/**
 * Created by MondayHopscotch on 7/25/2016.
 */
public class TitleScreen implements Screen {
    Texture tex;
    Sprite bg;
    SpriteBatch batch;
    Game game;

    public TitleScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        tex = new Texture(Gdx.files.internal("thats_disguisting_uhh.png"));
        bg = new Sprite(tex);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
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

    private void draw(){
        batch.begin();
        bg.draw(batch);
        batch.end();
    }

    private void update(float delta){
        for (Controller cont : Controllers.getControllers()) {
            if (cont.getButton(Xbox360Pad.BUTTON_A)) {
                game.setScreen(new GameScreen(game, cont));
            }
        }
    }

}
