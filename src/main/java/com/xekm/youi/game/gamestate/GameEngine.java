package com.xekm.youi.game.gamestate;

import com.xekm.youi.game.unit.BaseUnit;
import com.xekm.youi.game.unit.Planet;
import com.xekm.youi.game.unit.Star;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class GameEngine extends YouIGameState {

  private final Planet earth;
  private List<BaseUnit> units;
  private float centerX = 0f;
  private float centerY = 0f;
  private float scale = 13f;
  private boolean[] keyDown = new boolean[0xDF];

  public GameEngine(int stateId) {
    super(stateId);
    this.units = new ArrayList<BaseUnit>();

    Star sun = new Star("Sun", 0L, 0L, 695500L);
    this.addUnit(sun);
    this.addUnit(new Planet("Mercury", 57000000L, 0L, 4880L, Color.gray, sun, 88));
    this.addUnit(
        new Planet("Venus", 108000000L, 0L, 12104L, new Color(255, 255, 214, 255), sun,
                   225));
    this.earth = new Planet("Earth", 150000000L, 0L, 12756L, Color.blue, sun, 365);
    this.addUnit(this.earth);
    this.addUnit(new Planet("Moon", 150384400, 0L, 13473L, Color.gray, this.earth, 28));
    this.addUnit(new Planet("Mars", 228000000L, 0L, 6794L, Color.red, sun, 687));
  }

  public void progress(int delta) {

    if (this.keyDown[Input.KEY_UP]) {
      this.centerY--;
    }
    if (this.keyDown[Input.KEY_DOWN]) {
      this.centerY++;
    }
    if (this.keyDown[Input.KEY_LEFT]) {
      this.centerX--;
    }
    if (this.keyDown[Input.KEY_RIGHT]) {
      this.centerX++;
    }
    if (this.keyDown[Input.KEY_RBRACKET]) {
      this.scale = this.scale - 8;
    }
    if (this.keyDown[Input.KEY_LBRACKET]) {
      this.scale = this.scale + 8;
    }
    if (this.keyDown[Input.KEY_E]) {
      float x = earth.getX();
      float y = earth.getY();
      this.centerX = -(x / this.scale);
      this.centerY = -(y / this.scale);
    }

    for (BaseUnit b : this.units) {
      b.update(delta);
    }
  }

  private void addUnit(BaseUnit unit) {
    this.units.add(unit);
  }

  @Override
  public void init(GameContainer gc, StateBasedGame sbg)
      throws SlickException {
    gc.setShowFPS(true);
  }

  @Override
  public void render(GameContainer gc, StateBasedGame sbc, Graphics g)
      throws SlickException {
    //Log.info("Rendering.");
//    System.err.println("screen width = " + gc.getWidth());
//    System.err.println("screen height = " + gc.getHeight());
    g.translate(this.centerX + (gc.getWidth() / 2), this.centerY + (gc.getHeight() / 2));
    g.scale((1 / (this.scale)), (1 / (this.scale)));
    for (BaseUnit b : this.units) {
      b.render(g);
    }
  }

  @Override
  public void update(GameContainer container, StateBasedGame game, int delta)
      throws SlickException {
    this.progress(delta);

  }

  @Override
  public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    //Log.info("mouseMoved: " + oldx + ", " + oldy + ", " + newx + ", " + newy);
  }

  @Override
  public void mousePressed(int button, int x, int y) {
    //Log.info("mousePressed: " + button + ", " + x + ",  " + y);
  }

  @Override
  public void mouseReleased(int button, int x, int y) {
//    if (button == Input.MOUSE_LEFT_BUTTON) {
//      for (Rectangle r : this.rectangles) {
//        if (r.contains(x, y)) {
//          Log.info("Clicked on: " + r.getX() + ", " + r.getY());
//        }
//      }
//    }
    //Log.info("mouseReleased: " + button + ", " + x + ",  " + y);
  }

  @Override
  public void mouseWheelMoved(int change) {
    //Log.info("mouseWheelMoved: " + change);
  }

  @Override
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_E) {
      this.keyDown[Input.KEY_E] = !this.keyDown[Input.KEY_E];
    } else {
      this.keyDown[key] = false;
    }
  }

  @Override
  public void keyPressed(int key, char c) {
    if (!(key == Input.KEY_E)) {
      this.keyDown[key] = true;
    }
  }
}
