package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class CircularUnit extends BaseUnit {

  private long radius;

  public CircularUnit(long x, long y, long radius, Color color) {
    super(color, x, y);
    this.radius = radius;
  }

  @Override
  public Shape getShape() {
    return new Circle(this.getX(), this.getY(), this.radius);
  }
}
