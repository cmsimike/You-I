package com.xekm.youi.game.unit;

import org.newdawn.slick.Color;

public class Planet extends CircularUnit {

  private Star orbitStar = null;

  private double orbitalRealTimeMs;
  private double counterMs;

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
  public void update(long millis) {
    //System.err.println(this + " " + this.getDistanceToStar());
    this.counterMs = this.counterMs + millis;
    if (this.counterMs > this.orbitalRealTimeMs) {
      this.counterMs = this.counterMs - this.orbitalRealTimeMs;
    }
    double theta = (2 * Math.PI) * (double) (this.counterMs / (this.orbitalRealTimeMs));
    long _x = this.orbitStar.getX() + (long) (this.getDistanceToStar() * Math.cos(theta));
    long _y = this.orbitStar.getY() + (long) (this.getDistanceToStar() * Math.sin(theta));

//      System.err.println(this + " x, y " + this.getX() + "   "  + this.getY());
//      System.err.println("theta " + theta);
//      System.err.println("this.counterMs " + this.counterMs);

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
