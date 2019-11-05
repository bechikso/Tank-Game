package com.tank_game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Tank player;

	public void create () {
		// Loads camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 800);

		// Create Batch
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		// Creates Player
		player = new Tank("tank.jpg", "canon.jpg",400, 400);
		}

	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Esc to exit
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) System.exit(0);

		// Runs through the players actions
		player.step();

		// Updates the camera
		camera.update();
	}

	public void dispose () {
	}
}
