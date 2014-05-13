package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;

public class Planet extends CircularUnit {

  private CircularUnit orbitingUnit = null;

  private double orbitalRealTimeMs;
  private double distanceToStarCalculated = -1;

  public Planet(String name, long x, long y, long radius, Color color, CircularUnit unit,
                int orbitDays) {
    super(x, y, radius, color);

    this.setName(name);
    this.orbitingUnit = unit;
    this.orbitalRealTimeMs = orbitDays * 60 * 1000;

    System.err.println(this + " init: orbitDays " + orbitDays + "   this.orbitalRealTimeMs "
                       + this.orbitalRealTimeMs);
  }

  // 60 seconds = 1 day.
  // TODO may want ot increase this?
  // so 600 orbital days = 600 minutes
  //http://math.stackexchange.com/questions/266832/x-and-y-coordinates-of-circle-giving-a-center-radius-and-angle
  @Override
  public void progressUnit(long delta) {
    this.updateLocation(delta);

    //TODO update gravity pull on objects near?
  }

  private void updateLocation(long delta) {

    double change = (this.counterMs % this.orbitalRealTimeMs) / (this.orbitalRealTimeMs);
    double theta = (2 * Math.PI) * change;
    long _x = this.orbitingUnit.getX() + (long) (this.getDistanceToStar() * Math.cos(theta));
    long _y = this.orbitingUnit.getY() + (long) (this.getDistanceToStar() * Math.sin(theta));
    if (this.toString().contains("oon")) {
      System.err.printf("x y distance: %s %s %s \n", this.getX(), this.getY(), this.getDistanceToStar());
    }
    this.setX(_x);
    this.setY(_y);
  }

  private double getDistanceToStar() {
    if(this.distanceToStarCalculated > 0) {
      return this.distanceToStarCalculated;
    }

    long x = (this.getX() - this.orbitingUnit.getX());
    long y = (this.getY() - this.orbitingUnit.getY());
    long dSq = (x * x) + (y * y);
    this.distanceToStarCalculated = Math.ceil(Math.sqrt(dSq));
    return Math.ceil(Math.sqrt(dSq));
  }


  @Override
  public void render(Graphics g) {
    super.render(g);

  }
}
