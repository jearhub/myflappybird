package com.jearhub.android.myflappybird;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;

    public BackgroundImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 3;
    }

    //Getter method for getting the X-Coordinate
    public int getX(){
        return backgroundImageX;
    }
    //Getter method for getting the Y-Coordinate
    public int getY(){
        return backgroundImageY;
    }
    //Setter method for Setting the X-Coordinate
    public void setX(int backgroundImageX){
        this.backgroundImageX = backgroundImageX;
    }
    //Setter method for setting the Y-Coordinate
    public void setY(int backgroundImageY){
        this.backgroundImageY = backgroundImageY;
    }
    //Getter method for getting the velocity
    public int getVelocity(){
        return backgroundImageVelocity;
    }
}
