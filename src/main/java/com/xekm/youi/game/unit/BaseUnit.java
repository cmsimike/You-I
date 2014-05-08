package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Shape;

public abstract class BaseUnit {

  private String name;
  private Shape shape;
  private Color color;
  private long x;
  private long y;

  protected BaseUnit(Color color, long x, long y) {
    this.color = color;
    this.x = x;
    this.y = y;
  }

  public Shape getShape() {
    return shape;
  }

  public Color getColor() {
    return color;
  }

  public long getY() {
    return y;
  }

  public long getX() {
    return x;
  }

  public void setX(long x) {
    this.x = x;
  }

  public void setY(long y) {
    this.y = y;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return this.getClass().getSimpleName() + " named " + this.name;
  }

  public abstract void update(long millis);
}
