package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Ship extends BaseUnit {

  public Ship() {
    super(Color.darkGray, 1, 1);
  }

  @Override
  public void update(long millis) {

  }

  @Override
  public Shape getShape() {
    return new Rectangle(100, 100, 50, 50);
  }
}

