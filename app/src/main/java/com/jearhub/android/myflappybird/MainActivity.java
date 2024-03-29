package com.jearhub.android.myflappybird;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        AppConstants.initilization ( this.getApplicationContext () );
    }

    public void startGame(View view) {
        //Log.i ( "ImageButton", "clicked" );
        Intent intent = new Intent ( this, GameActivity.class );
        startActivity(intent);
        finish ();
    }
}
