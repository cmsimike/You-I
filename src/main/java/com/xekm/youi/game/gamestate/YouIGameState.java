package com.xekm.youi.game.gamestate;

import org.newdawn.slick.state.BasicGameState;

public abstract class YouIGameState extends BasicGameState {

  private int stateId;

  public YouIGameState(int id) {
    this.stateId = id;
  }

  @Override
  public int getID() {
    return this.stateId;
  }
}
