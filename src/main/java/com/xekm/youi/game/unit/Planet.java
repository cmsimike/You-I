package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;

public class Planet extends CircularUnit {

  private Star orbitStar = null;

  private double orbitalRealTimeMs;

  public Planet(String name, long x, long y, long radius, Color color, Star star, int orbitDays) {
    super(x, y, radius, color);

    this.setName(name);
    this.orbitStar = star;
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
    long _x = this.orbitStar.getX() + (long) (this.getDistanceToStar() * Math.cos(theta));
    long _y = this.orbitStar.getY() + (long) (this.getDistanceToStar() * Math.sin(theta));

    this.setX(_x);
    this.setY(_y);
  }

  private double getDistanceToStar() {
    long x = (this.getX() - this.orbitStar.getX());
    long y = (this.getY() - this.orbitStar.getY());
    long dSq = (x * x) + (y * y);
    return Math.sqrt(dSq);
  }


}
