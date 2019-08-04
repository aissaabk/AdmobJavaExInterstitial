package com.example.admobjavaexinterstitial;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;

public class MainActivitySoftwareInformation extends AppCompatActivity {

  //  private AdView mAdView;

    private TextView textViewAndroidVersion;
    private TextView textViewAndroidSecurity;
    private TextView textViewAndroidBasebandVersion;
    private TextView textViewAndroidBuilderNumbre;
    private TextView textViewAndroidKernelVersion;
    private TextView[] textViewAll={textViewAndroidVersion,textViewAndroidSecurity,textViewAndroidBasebandVersion,textViewAndroidBuilderNumbre,textViewAndroidKernelVersion};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_software_information);

     //   mAdView=findViewById(R.id.adView);
      //  MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
textViewAndroidVersion=findViewById(R.id.textViewAndroidVersionValue);

        //android version

        // baseband version
        textViewAndroidBasebandVersion=findViewById(R.id.textViewAndroidBasebandVersionValue);


        // builder numbre
        textViewAndroidBuilderNumbre=findViewById(R.id.textViewAndroidBasebandVersionValue);



        // security patch level;
        textViewAndroidSecurity=findViewById(R.id.textViewAndroidSecurityPatchLevelValue);

        //textViewAndroidSecurity.setText(android.os.Build.VERSION.BASE_OS);


        // android kernel version
        textViewAndroidKernelVersion=findViewById(R.id.textViewAndroidKernelVersionValue);

        // create request admob and load it
         switch (android.os.Build.VERSION.SDK_INT){
             case  Build.VERSION_CODES.BASE:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" FIRST REALASE");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();

                 break;

             case Build.VERSION_CODES.CUPCAKE:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" SECOND REALASE");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.CUR_DEVELOPMENT:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" CUPCAKE");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.DONUT:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" DONUT");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.ECLAIR:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" ECLAIR");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.ECLAIR_0_1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" ECLAIR 0.1");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.ECLAIR_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" ECLAIR MR1");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.FROYO:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" FROYO");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.GINGERBREAD:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" GINGERBREAD");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.GINGERBREAD_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" GINGERBREAD MR1");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.HONEYCOMB:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" HONEYCOMB");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.HONEYCOMB_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" HONEYCOMB MR1");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.HONEYCOMB_MR2:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" HONEYCOMB MR2");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.ICE_CREAM_SANDWICH:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" ICE CREAM SANDWICH");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" ICE CREAM SANDWICH MR1");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.JELLY_BEAN:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" JELLY BEAN");
                 textViewAndroidBasebandVersion.setText(Build.RADIO);
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.JELLY_BEAN_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" JELLY BEAN MR1");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.JELLY_BEAN_MR2:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" JELLY BEAN MR2");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.KITKAT:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" KITKAT");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.KITKAT_WATCH:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" KITKAT WATCH");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.LOLLIPOP:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" LOLLIPOP");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();

                 break;
             case Build.VERSION_CODES.LOLLIPOP_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" LOLLIPOP MR1");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.M:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Marshmallow");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.N:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Nougat");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.N_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Nougat ++");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.O:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Oreo");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.O_MR1:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Oreo");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();

                 break;
             case Build.VERSION_CODES.P:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Pie");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();
                 break;
             case Build.VERSION_CODES.Q:
                 textViewAndroidVersion.setText(Build.VERSION.RELEASE+" Q");
                 textViewAndroidBasebandVersion.setText(Build.getRadioVersion());
                 getCurrenSdk();

                 break;
              default:
                  textViewAndroidVersion.setText("UNKNOWN");
                  textViewAndroidBasebandVersion.setText(Build.getRadioVersion());

                     getCurrenSdk();




         }

     //   AdRequest requestAd=new AdRequest.Builder().addTestDevice("emulator-5554").build();
       // mAdView.loadAd(requestAd);


    }
    public void getCurrenSdk() {


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            textViewAndroidSecurity.setText(Build.VERSION.SECURITY_PATCH);
            textViewAndroidKernelVersion.setText(Build.VERSION.BASE_OS);
        }
    }
}