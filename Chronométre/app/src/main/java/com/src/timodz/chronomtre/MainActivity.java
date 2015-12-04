package com.src.timodz.chronomtre;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Déclaration des objets ///////////////
    Button start , stop , reset , about ;
    Chronometer chrono ;
    long time, t ;
    /////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialisation des objets//////////////
        start = (Button) findViewById(R.id.bstart);
        stop = (Button) findViewById(R.id.bStop);
        reset = (Button) findViewById(R.id.breset);
        about = (Button) findViewById(R.id.babout);
        chrono = (Chronometer) findViewById(R.id.chronometer2);
        ///////////////////////////////////////////
        //changer le font /////////////////////////
        chrono.setTypeface(Typeface.createFromAsset(getAssets(),"Casua.ttf"));
        ///////////////////////////////////////////
        //Initialiser les variable du chronométre/////
        time = 0;
        t = 0 ;
        //////////////////////////////////////////////
        //Métre le boutton Stop inclickable//////////
        stop.setEnabled(false);
        /////////////////////////////////////////////
        //Listeners//////////////////////////////////
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime()-t+time);
                chrono.start();
                start.setEnabled(false);
                stop.setEnabled(true);
            }});

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = chrono.getBase();
                t = SystemClock.elapsedRealtime();
               chrono.stop();
                start.setEnabled(true);
                stop.setEnabled(false);

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                time = 0 ;
                t = 0 ;
             }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Phoenix Club \n AndroidLab",Toast.LENGTH_LONG).show();
            }
        });
        ///////////////////////////////////////////////////
    }
}
