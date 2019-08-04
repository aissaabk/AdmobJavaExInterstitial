package com.example.admobjavaexinterstitial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
public class MainActivity extends AppCompatActivity {
   // private InterstitialAd mInterstitialAd;
    private Button buttonHardwareInforamtion;
    private Button buttonSoftwareInformation;
TextView mLog;
    private final int showSoftwareInformationActivity=0;

    private int statusActivityCalled=1;

    /**
     * This function assumes logger is an instance of AppEventsLogger and has been
     * created using AppEventsLogger.newLogger() call.
     */
    public void logCompleteTutorialEvent (String contentData, String contentId, boolean success) {
        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 1 : 0);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.getApplicationContext();
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();

       /* AdView mAdView2 = findViewById(R.id.adView2);
        MobileAds.initialize(this,"ca-app-pub-2495222726894457/6316203202");

        AdRequest requestAd2=new AdRequest.Builder().addTestDevice("emulator-5554")
                .build();

       mAdView2.loadAd(requestAd2);
*/





        buttonHardwareInforamtion=findViewById(R.id.buttonHardwareInformation);

        buttonHardwareInforamtion.setVisibility(View.VISIBLE);
        buttonSoftwareInformation=findViewById(R.id.buttonSoftwareInformation);
        buttonSoftwareInformation.setVisibility(View.VISIBLE);
     /*  mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("emulator-5554").build());
*/
        buttonHardwareInforamtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                showInterstitial();*/
            }
        });
        buttonSoftwareInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusActivityCalled=showSoftwareInformationActivity;
               // showInterstitial();
            }
         });
      /*  mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {

                buttonHardwareInforamtion.setVisibility(View.VISIBLE);

                buttonSoftwareInformation.setVisibility(View.VISIBLE);

                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(R.string.dialog_fire_missiles);
                alertDialog.setMessage(getResources().getString(R.string.dialog_fire_missiles)+" "+errorCode);
                alertDialog.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"refresh",Toast.LENGTH_LONG).show();
                        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("emulator-5554").build());
                    }
                });
                alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"cancel",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                alertDialog.create().show();
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdLeftApplication() {

                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                if(statusActivityCalled==showSoftwareInformationActivity)
                {   startActivitySoftwareInformation();
                }

                else
                {
                    startActivityHardwareInformation();

                    }
                mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("emulator-5554").build());// Code to be executed when the interstitial ad is closed.

            }
        });
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if(mInterstitialAd == null && !mInterstitialAd.isLoaded())
        {
            showProgressDialog();
        }
        else if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
    public void startActivityHardwareInformation() {
        Intent intent = new Intent(this, MainActivityHardwareInformation.class);
        startActivity(intent);
    }
    public void startActivitySoftwareInformation() {
        Intent intent = new Intent(this, MainActivitySoftwareInformation.class);
        startActivity(intent);
    }
public void showProgressDialog(){
    ProgressDialog progressDialog=new ProgressDialog(this);
    progressDialog.show();
    }


}
