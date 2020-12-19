package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash_Ekrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__ekrani);


        Thread timerThread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(1200);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(Splash_Ekrani.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }



    @Override    protected void onPause() {
        super.onPause();
        finish();
    }


}