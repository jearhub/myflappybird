package com.jearhub.android.myflappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;
    Bitmap toptower, bottomtower;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource ( res,R.drawable.background );
        background = scaleImage ( background );
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource ( res, R.drawable.flappy1 );
        bird[1] = BitmapFactory.decodeResource ( res, R.drawable.flappy2 );
        bird[2] = BitmapFactory.decodeResource ( res, R.drawable.flappy3 );
        bird[3] = BitmapFactory.decodeResource ( res, R.drawable.flappy4 );
        toptower= BitmapFactory.decodeResource ( res, R.drawable.toptower );
        bottomtower= BitmapFactory.decodeResource ( res, R.drawable.bottomtower );
    }

    // Return Top-Tower Bitmap
    public Bitmap getTopTower(){
        return toptower;
    }

    // Return Bottom-Tower Bitmap
    public Bitmap getBottomTower(){
        return bottomtower;
    }

    // Return Tower-width
    public int getTowerWidth(){
        return toptower.getWidth ();
    }

    // Return Tower-height
    public int getTowerHeight(){
        return toptower.getHeight ();
    }

    //Return bird bitmap of frame
    public Bitmap getBird(int frame) {
        return bird[frame];
    }
    public int getBirdWidth(){
        return bird[0].getWidth ();
    }
    public int getBirdHeight(){
        return bird[0].getHeight ();
    }

    //Return Background bitmap
    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth ();
    }
    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight ();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth () / getBackgroundHeight ();
        //We will multiply widthHeightRatio with ScreenHeight to get scaled width
        //Then call createScaleBitmap() to create a new bitmap scaled from an existing bitmap
        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap ( bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false );
    }
}
