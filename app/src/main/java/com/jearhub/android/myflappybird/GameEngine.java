package com.jearhub.android.myflappybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Bird bird;
    static int gameState;
    ArrayList<Tower> towers;
    Random random;
    int score; // Stores the score
    int scoringTower; // Keeps track of the scoring tower
    Paint scorePaint;

    public GameEngine() {
        backgroundImage = new BackgroundImage ();
        bird = new Bird ();
        // 0 = Not started
        // 1 = Playing
        // 2 = GameOver
        gameState = 0;
        towers = new ArrayList<> ();
        random = new Random ();
        for (int i = 0; i < AppConstants.numberOfTowers; i++) {
            int towerX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTowers;
            //Get topTowerOffsetY
            int topTowerOffsetY = AppConstants.minTowerOffsetY +
                    random.nextInt ( AppConstants.maxTowerOffsetY - AppConstants.minTowerOffsetY + 1 );
            // Now create Tower objects
            Tower tower = new Tower ( towerX, topTowerOffsetY );
            towers.add ( tower );
        }
        score = 0;
        scoringTower = 0;
        scorePaint = new Paint ();
        scorePaint.setColor ( Color.WHITE );
        scorePaint.setTextSize ( 100 );
        scorePaint.setTextAlign ( Paint.Align.LEFT );
    }

    public void updateAndDrawTowers(Canvas canvas) {
        if (gameState == 1) {
            if ((towers.get ( scoringTower ).getTowerX () < bird.getX () + AppConstants.getBitmapBank ().getBirdWidth ())
                    && (towers.get ( scoringTower ).getTopTowerOffsetY () > bird.getY () || towers.get ( scoringTower ).getBottomTowerY () < (bird.getY () +
                    AppConstants.getBitmapBank ().getBirdHeight ()))) {
                // Go to GameOver screen
                gameState = 2;
                //Log.d ( "Game", "Over" );
                AppConstants.getSoundBank ().playPain();
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent ( context, GameOver.class );
                intent.putExtra ( "score", score );
                context.startActivity ( intent );
                ((Activity) context).finish();
            } else if (towers.get ( scoringTower ).getTowerX () < bird.getX () - AppConstants.getBitmapBank ().getTowerWidth ()) {
                score++;
                scoringTower++;
                if (scoringTower > AppConstants.numberOfTowers - 1) {
                    scoringTower = 0;
                }
                AppConstants.getSoundBank ().playScore ();
            }
            for (int i = 0; i < AppConstants.numberOfTowers; i++) {
                if (towers.get ( i ).getTowerX () < -AppConstants.getBitmapBank ().getTowerWidth ()) {
                    towers.get ( i ).setTowerX ( towers.get ( i ).getTowerX () +
                            AppConstants.numberOfTowers * AppConstants.distanceBetweenTowers );
                    int topTowerOffsetY = AppConstants.minTowerOffsetY +
                            random.nextInt ( AppConstants.maxTowerOffsetY - AppConstants.minTowerOffsetY + 1 );
                    towers.get ( i ).setTopTowerOffsetY ( topTowerOffsetY );
                }
                towers.get ( i ).setTowerX ( towers.get ( i ).getTowerX () - AppConstants.towerVelocity );
                canvas.drawBitmap ( AppConstants.getBitmapBank ().getTopTower (), towers.get ( i ).getTowerX (), towers.get ( i ).getTopTowerY (), null );
                canvas.drawBitmap ( AppConstants.getBitmapBank ().getBottomTower (), towers.get ( i ).getTowerX (), towers.get ( i ).getBottomTowerY (), null );
            }
            canvas.drawText ( "Pt:" + score, 0, 110, scorePaint );
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX ( backgroundImage.getX () - backgroundImage.getVelocity () );
        if (backgroundImage.getX () < -AppConstants.getBitmapBank ().getBackgroundWidth ()) {
            backgroundImage.setX ( 0 );
        }
        canvas.drawBitmap ( AppConstants.getBitmapBank ().getBackground (), backgroundImage.getX (), backgroundImage.getY (), null );
        if (backgroundImage.getX () < -(AppConstants.getBitmapBank ().getBackgroundWidth () - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap ( AppConstants.getBitmapBank ().getBackground (), backgroundImage.getX () +
                    AppConstants.getBitmapBank ().getBackgroundWidth (), backgroundImage.getY (), null );
        }
    }

    public void updateAndDrawBird(Canvas canvas) {
        if (gameState == 1) {
            if (bird.getY () < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank ().getBirdHeight ()) || bird.getVelocity () < 0) {
                bird.setVelocity ( bird.getVelocity () + AppConstants.gravity );
                bird.setY ( bird.getY () + bird.getVelocity () );
            }
        }
        int currentFrame = bird.getCurrentFrame ();
        canvas.drawBitmap ( AppConstants.getBitmapBank ().getBird ( currentFrame ), bird.getX (), bird.getY (), null );
        currentFrame++;
        //If it exceeds maxframe re-initialize to 0
        if (currentFrame > bird.maxFrame) {
            currentFrame = 0;
        }
        bird.setCurrentFrame ( currentFrame );
    }
}
