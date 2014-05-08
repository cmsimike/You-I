package com.xekm.youi;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import com.xekm.util.NativeUtils;
import com.xekm.youi.game.YouIStateBasedGame;

public class App {


  static {
    try {
      NativeUtils.loadLibraryFromJar("/jinput-dx8_64.dll");
      NativeUtils.loadLibraryFromJar("/jinput-dx8.dll");
      NativeUtils.loadLibraryFromJar("/jinput-raw_64.dll");
      NativeUtils.loadLibraryFromJar("/jinput-raw.dll");
      NativeUtils.loadLibraryFromJar("/jinput-wintab.dll");
      NativeUtils.loadLibraryFromJar("/lwjgl.dll");
      NativeUtils.loadLibraryFromJar("/lwjgl64.dll");
      NativeUtils.loadLibraryFromJar("/OpenAL32.dll");
      NativeUtils.loadLibraryFromJar("/OpenAL64.dll");

      NativeUtils.loadLibraryFromJar("/libjinput-linux.so");
      NativeUtils.loadLibraryFromJar("/libjinput-linux64.so");
      NativeUtils.loadLibraryFromJar("/liblwjgl.so");
      NativeUtils.loadLibraryFromJar("/liblwjgl64.so");
      NativeUtils.loadLibraryFromJar("/libopenal.so");
      NativeUtils.loadLibraryFromJar("/libopenal64.so");

      NativeUtils.loadLibraryFromJar("/libjinput-osx.jnilib");
      NativeUtils.loadLibraryFromJar("/liblwjgl.jnilib");
      NativeUtils.loadLibraryFromJar("/openal.dylib");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new YouIStateBasedGame());

    app.setDisplayMode(1024, 768, false);
    app.setTargetFrameRate(60);
    app.setShowFPS(true);
    app.start();
  }

}
