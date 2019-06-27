package com.jearhub.android.myflappybird;

import java.util.Random;

public class Tower {
    // towerX = Tower X-coordinate, topTowerOffsetY = top tower bottom edge coordinate
    private int towerX, topTowerOffsetY;
    private Random random;
    public Tower(int towerX, int topTowerOffsetY){
        this.towerX = towerX;
        this.topTowerOffsetY = topTowerOffsetY;
        random = new Random();
    }

    public int getTopTowerOffsetY(){
        return topTowerOffsetY;
    }

    public int getTowerX(){
        return towerX;
    }

    public int getTopTowerY(){
        return topTowerOffsetY - AppConstants.getBitmapBank ().getTowerHeight ();
    }

    public int getBottomTowerY(){
        return topTowerOffsetY + AppConstants.gapBetweenTopAndBottomTowers;
    }

    public void setTowerX(int towerX) {
        this.towerX = towerX;
    }

    public void setTopTowerOffsetY(int topTowerOffsetY) {
        this.topTowerOffsetY = topTowerOffsetY;
    }
}
