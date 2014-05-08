package com.xekm.youi.game.gamestate;

import com.xekm.youi.game.YouIStateBasedGame;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SplashState
    extends YouIGameState {

  private String welcomeMessage = "YouI";
  private int selection = 0;
  private List<String> messages;

  private StateBasedGame sbg = null;

  public SplashState(int stateId) {
    super(stateId);

    messages = new LinkedList<String>();
    messages.add("Explore Space");
    messages.add("Exit game");

  }

  @Override
  public void init(GameContainer gc, StateBasedGame sbg)
      throws SlickException {
    this.sbg = sbg;
  }

  @Override
  public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
      throws SlickException {
    g.drawString(welcomeMessage, 100, 100);
    for (int i = 0; i < messages.size(); i++) {
      g.drawString(messages.get(i), 200, ((i + 1) * 30) + 100);
      if (this.selection == i) {
        g.drawRect(200 - 30, ((i + 1) * 30) + 100, 300, 20);
      }
    }
  }

  @Override
  public void update(GameContainer gc, StateBasedGame sbc, int delta)
      throws SlickException {
    // TODO Auto-generated method stub

  }

  private void incSelection() {
    this.selection++;
    if (this.selection == messages.size()) {
      this.selection = 0;
    }
  }

  private void decSelection() {
    this.selection--;
    if (this.selection < 0) {
      this.selection = this.messages.size() - 1;
    }
  }

  @Override
  public void keyReleased(int key, char c) {
    if (key == Input.KEY_ENTER) {
      if (this.selection == messages.size() - 1) {
        System.exit(0);
      } else if (this.selection == 0) {
        this.sbg.enterState(YouIStateBasedGame.STATE_GAME);
      }
    } else if (key == Input.KEY_DOWN) {
      this.incSelection();
    } else if (key == Input.KEY_UP) {
      this.decSelection();
    }
  }
}
