package com.xekm.youi.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.xekm.youi.game.gamestate.*;

public class YouIStateBasedGame extends StateBasedGame {

  public static int STATE_SPLASH = 1;
  public static int STATE_GAME = 2;


  public YouIStateBasedGame() {
    super("You I - Conquer Space");
  }

  @Override
  public void initStatesList(GameContainer arg0) throws SlickException {
    GameEngine igs = new GameEngine(STATE_GAME);
    SplashState ss = new SplashState(STATE_SPLASH);

    this.addState(igs); // the first state shown
    //this.addState(igs);
  }
}
