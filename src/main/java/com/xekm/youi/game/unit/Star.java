package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;

public class Star extends CircularUnit {

  public Star(String name, long x, long y, long radius) {
    super(x, y, radius, Color.yellow);
    this.setName(name);
  }

  @Override
  public void update(long millis) {

  }
}
