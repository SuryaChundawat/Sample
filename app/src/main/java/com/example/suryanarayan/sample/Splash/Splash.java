package com.example.suryanarayan.sample.Splash;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.suryanarayan.sample.Activity.Login;
import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.R;


public class Splash extends BaseActivity {

    private CircleProgressBar progressBar;
    //comit from surya


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        intialize();
        fullScreen();
        functionality();
        InitiStatus();
    }

    private void functionality() {

        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(3 * 1000);
                    showProgress(false);
                   // jsonparsing.StartActivity(Splash.this);
                    //otp.StartActivity(Splash.this);
                   Login.StartActivity(Splash.this);
                   finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }


    @SuppressLint("WrongViewCast")
    private void intialize() {
        progressBar = (CircleProgressBar) findViewById(R.id.progressBar);
        showProgress(true);
    }

    private void showProgress(boolean b) {
        if (b) {

            AnimationUtils.animateScaleOut(progressBar);
        } else {

            AnimationUtils.animateScaleIn(progressBar);
        }
    }



    private void fullScreen() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
