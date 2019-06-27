package com.jearhub.android.myflappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank bitmapBank; // Bitmap object reference
    static GameEngine gameEngine; // GameEngine object reference
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMPED;
    static int gapBetweenTopAndBottomTowers;
    static int numberOfTowers;
    static int towerVelocity;
    static int minTowerOffsetY;
    static int maxTowerOffsetY;
    static int distanceBetweenTowers;
    static SoundBank soundBank;
    static Context gameActivityContext;

    public static void initilization(Context context){
        setScreenSize ( context );
        bitmapBank = new BitmapBank ( context.getResources () );
        setGameConstants ();
        gameEngine = new GameEngine ();
        soundBank = new SoundBank ( context );
      //gravity = 3;
    }

    public static SoundBank getSoundBank(){
        return soundBank;
    }

    public static void setGameConstants() {
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_WHEN_JUMPED = -30;
        gapBetweenTopAndBottomTowers = 700;
        AppConstants.numberOfTowers = 2;
        AppConstants.towerVelocity = 10;
        AppConstants.minTowerOffsetY = (int) (AppConstants.gapBetweenTopAndBottomTowers/2);
        AppConstants.maxTowerOffsetY = AppConstants.SCREEN_HEIGHT - AppConstants.minTowerOffsetY - AppConstants.gapBetweenTopAndBottomTowers;
        AppConstants.distanceBetweenTowers = AppConstants.SCREEN_WIDTH * 3 /4;
    }

    // Return BitmapBank instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    // Return GameEngine instance
    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService ( Context.WINDOW_SERVICE );
        Display display = wm.getDefaultDisplay ();
        DisplayMetrics metrics = new DisplayMetrics ();
        display.getMetrics ( metrics );
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }

}
