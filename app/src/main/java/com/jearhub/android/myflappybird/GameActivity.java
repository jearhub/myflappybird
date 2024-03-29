package com.jearhub.android.myflappybird;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

public class GameActivity extends Activity {

    GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        this.requestWindowFeature ( getWindow ().FEATURE_NO_TITLE );
        this.getWindow ().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow ().addFlags ( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
        AppConstants.gameActivityContext = this;
        gameView = new GameView ( this );
        setContentView ( gameView );
    }
}
