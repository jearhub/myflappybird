package com.jearhub.android.myflappybird;

public class Bird {

    private int birdX, birdY, currentFrame, velocity;
    public static int maxFrame;

    public Bird(){
        birdX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank ().getBirdWidth ()/2;
        birdY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank ().getBirdHeight ()/2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    //Getter method for velocity
    public int getVelocity(){
        return velocity;
    }

    //Setter method for velocity
    public void  setVelocity(int velocity){
        this.velocity = velocity;
    }

    //Getter method for current frame
    public int getCurrentFrame(){
        return currentFrame;
    }

    //Setter method for current frame
    public void  setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }
    //Getter method for getting X-Coordinate of the bird
    public int getX(){
        return birdX;
    }
    //Getter method for getting Y-Coordinate of the bird
    public int getY(){
        return birdY;
    }
    //Setter method for setting X-Coordinate of the bird
    public void  setX(int birdX){
        this.birdX = birdX;
    }
    //Setter method for setting Y-Coordinate of the bird
    public void  setY(int birdY){
        this.birdY = birdY;
    }
}
