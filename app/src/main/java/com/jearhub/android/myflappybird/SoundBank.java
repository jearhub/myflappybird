package com.jearhub.android.myflappybird;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundBank {

    Context context;
    MediaPlayer pain, score, swoosh, wing;

    public SoundBank(Context context){
        this.context = context;
        swoosh = MediaPlayer.create ( context, R.raw.swoosh );
        score = MediaPlayer.create ( context, R.raw.score );
        pain = MediaPlayer.create ( context,R.raw.pain );
        wing = MediaPlayer.create ( context,R.raw.wing );
    }

    public void playSwoosh(){
        if(swoosh != null){
            swoosh.start ();
        }
    }
    public void playScore(){
        if(score != null){
            score.start ();
        }
    }
    public void playWing(){
        if(wing != null){
            wing.start ();
        }
    }
    public void playPain(){
        if(pain != null){
            pain.start ();
        }
    }
}
