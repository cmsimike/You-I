package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Ship extends BaseUnit {

  private int thrust;

  public Ship() {
    super(Color.darkGray, 1, 1);
  }

  //required - 2d vector movement?
  // thrust which leads to accel
//http://stackoverflow.com/questions/5705397/java-movement-in-2d
  // ships have a certain acceleration (km/h/h)
  // which we then keep track of the velocity.
  // acceleration is based on engine type.
  // 2500 ms = 1 hour
  // 60 seconds = 1 day.
  // TODO may want ot increase this?
  // so 600 orbital days = 600 minutes
  @Override
  public void progressUnit(long millis) {

  }

  @Override
  public void render(Graphics g) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public Shape getShape() {
    return new Rectangle(100, 100, 50, 50);
  }
}

