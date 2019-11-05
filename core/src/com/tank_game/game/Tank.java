package com.tank_game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Tank extends ApplicationAdapter {
    private SpriteBatch batch = new SpriteBatch();

    public Texture tankImg;
    private Texture canonImg;
    public Rectangle collision;

    int timer = 0; // For counting up

    public Tank(String tankImgPath, String canonImgPath, int x, int y) {
        tankImg = new Texture(Gdx.files.internal(tankImgPath));
        canonImg = new Texture(Gdx.files.internal(canonImgPath));
        collision = new Rectangle();
        collision.x = x;
        collision.y = y;
        collision.width = 64;
        collision.height = 64;

    }

    public void step() {
        movement();
        mouse_point();
        timer++;

        // Draws all the textures in the game
        batch.begin();
        batch.draw(tankImg, collision.x, collision.y);
        batch.draw(canonImg, collision.x + 24, collision.y + 24);
        batch.end();
    }

    public void movement() {
        // Keyboard Movement
        if(Gdx.input.isKeyPressed(Input.Keys.A)) collision.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.D)) collision.x += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.W)) collision.y += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.S)) collision.y -= 200 * Gdx.graphics.getDeltaTime();

        // Restricts the tank to go outside of the window
        if(collision.x < 0) collision.x = 0;
        if(collision.x > 800 - 64) collision.x = 800 - 64;
    }

    public void mouse_point() {
        // Holds the mouse coordinates
        Vector3 mousePos = new Vector3();
        if (timer == 50) {
            System.out.println("x: " + Gdx.input.getX() + ", y: " + Gdx.input.getY());
            timer = 0;
        }
    }
}
