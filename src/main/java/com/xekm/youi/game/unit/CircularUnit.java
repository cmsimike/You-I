package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class CircularUnit extends BaseUnit {

  private long diameter;

  public CircularUnit(long x, long y, long diameter, Color color) {
    super(color, x, y);
    this.diameter = diameter;
  }

  @Override
  public Shape getShape() {
    return new Circle(this.getX(), this.getY(), this.diameter / 2);
  }

  public long getDiameter() {
    return this.diameter;
  }

  public long getRadius() {
    return this.diameter / 2;
  }

  @Override
  public void render(Graphics g) {
    g.setColor(this.getColor());
    g.fill(this.getShape());
  }
}
