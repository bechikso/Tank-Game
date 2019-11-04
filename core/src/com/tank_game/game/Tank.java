package com.tank_game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Tank extends ApplicationAdapter {
    public Texture tankImg;
    public Rectangle collision;

    public Tank(String imgPath, int x, int y) {
        tankImg = new Texture(Gdx.files.internal(imgPath));
        collision = new Rectangle();
        collision.x = x;
        collision.y = y;
        collision.width = 64;
        collision.height = 64;
    }

    public void step() {
        movement();
        mouse_point();
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
        System.out.println("x: " + Gdx.input.getX() + ", y: " + Gdx.input.getY());


    }
}
