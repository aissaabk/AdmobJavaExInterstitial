package com.example.admobjavaexinterstitial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;

import static android.os.Build.CPU_ABI;

public class MainActivityHardwareInformation extends AppCompatActivity {

    private static final String DEBUG_TAG = "NetworkStatusExample";
    private TextView textViewDeviceName;
    private TextView textViewDevicesVendor;
    private TextView textViewCpu;
    private TextView textViewStorage;
    private TextView textViewRam;
    private TextView textViewMainCamera;
    private TextView textViewSelfieCamera;
    private TextView textViewChipset;
    private TextView textViewDisplay;
    private TextView textViewNetworkTechnology;
    private TextView textViewBattery;
    private TextView[] textViewAll={textViewDeviceName,textViewDevicesVendor,textViewCpu,textViewStorage,textViewRam,textViewMainCamera,textViewSelfieCamera,textViewChipset,textViewDisplay,textViewNetworkTechnology,textViewBattery};



    private android.hardware.Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hardware_information);

        //name devices
        textViewDeviceName=findViewById(R.id.textViewDeviceValue);
        textViewDeviceName.setText(Build.MODEL);
        //name manufacture
        textViewDevicesVendor=findViewById(R.id.textViewVendorValue);
        textViewDevicesVendor.setText(Build.MANUFACTURER);
        //cpu
        textViewCpu=findViewById(R.id.textViewCpuValue);
        textViewCpu.setText(Build.HARDWARE);
        //chipset
        textViewChipset=findViewById(R.id.textViewChipsetValue);
       /* ProcessBuilder processBuilderChipset=new ProcessBuilder("cat","/proc/cpuinfo","|","grep","Hardware");
        String sr="";
        BufferedReader bis;
        try {
            bis = new BufferedReader(new InputStreamReader(processBuilderChipset.start().getInputStream()));
            int i=0;
            String lineRead="";
            while((lineRead=bis.readLine())!=null){
              if(lineRead.contains("cpu")){
                sr+=lineRead;
                break;
              }
            }

            textViewChipset.setText(sr);
            Toast.makeText(this,sr, Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
       textViewChipset.setText(Build.BOARD);


        //Display
textViewDisplay=findViewById(R.id.textViewDisplaySizeValue);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        final float scale = getResources().getDisplayMetrics().density;
        /*
            mdpi=(1.0dp * 160) pixels=160dpi;

            hdpi=(1.5dp * 160) pixels=240dpi;

            xxhdpi=(2.0dp * 160) pixels=320dpi;

            xxxhdpi=(3.0dp * 160) pixels=480dpi;

            xxxxhdpi=(4.0dp * 160) pixels=640dpi;

            source android developer

            https://developer.android.com/training/multiscreen/screendensities
        */

        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(this.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;
        double wi =(double)deviceWidth ;
        double hi=(double)deviceHeight ;
        int x =(int) Math.pow(wi, 2);
        int y = (int)Math.pow(hi, 2);
        double screenPixel =(double) Math.sqrt(x+y);
        double screenInches=screenPixel/((double)scale*160);
        textViewDisplay.setText((int)(screenInches+0.5)+"\""+ " Inches");

        //Storage

        textViewStorage=findViewById(R.id.textViewStorgaSizeValue);
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long BlockSize = stat.getBlockSize();
        long TotalBlocks = stat.getBlockCount();
        textViewStorage.setText(String.valueOf((TotalBlocks * BlockSize)/(1024*1024))+" MB");

        //RAM

        textViewRam=findViewById(R.id.textViewRamSizeValue);

        ActivityManager activityManager= (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo=new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        final long meminfo=memoryInfo.totalMem;
        textViewRam.setText(String.valueOf(meminfo/(1024*1024) )+" MB");


        //NETWORK
        String str;
       textViewNetworkTechnology=findViewById(R.id.textViewNetworkTechnologyValue);
        TelephonyManager telephonyManager=(TelephonyManager)getSystemService(this.TELEPHONY_SERVICE);

       switch(telephonyManager.getNetworkType())

       {   case TelephonyManager.NETWORK_TYPE_GSM:
           case TelephonyManager.NETWORK_TYPE_GPRS:
           case TelephonyManager.NETWORK_TYPE_EDGE:
           case TelephonyManager.NETWORK_TYPE_CDMA:
           case TelephonyManager.NETWORK_TYPE_1xRTT:
           case TelephonyManager.NETWORK_TYPE_IDEN:
               str= "2G";
               break;
           case TelephonyManager.NETWORK_TYPE_UMTS:
           case TelephonyManager.NETWORK_TYPE_EVDO_0:
           case TelephonyManager.NETWORK_TYPE_EVDO_A:
           case TelephonyManager.NETWORK_TYPE_HSDPA:
           case TelephonyManager.NETWORK_TYPE_HSUPA:
           case TelephonyManager.NETWORK_TYPE_HSPA:
           case TelephonyManager.NETWORK_TYPE_EVDO_B:
           case TelephonyManager.NETWORK_TYPE_EHRPD:
           case TelephonyManager.NETWORK_TYPE_HSPAP:
           case TelephonyManager.NETWORK_TYPE_TD_SCDMA:

               str= "3G";
               break;
           case TelephonyManager.NETWORK_TYPE_IWLAN:
           case TelephonyManager.NETWORK_TYPE_LTE:
               str= "4G";
               break;
           case  TelephonyManager.NETWORK_TYPE_NR:
               str="5G";
               break;
           case TelephonyManager.NETWORK_TYPE_UNKNOWN:
           default:
               str= String.valueOf(telephonyManager.getNetworkType());
       }
        textViewNetworkTechnology.setText(str);
        /*
        NETWORK_TYPE_1xRTT=01

        NETWORK_TYPE_CDMA=4 IS95A and IS95B

        NETWORK_TYPE_EDGE=2

        NETWORK_TYPE_EHRPD=14

        NETWORK_TYPE_EVDO_0=5

        NETWORK_TYPE_EVDO_A=6

        NETWORK_TYPE_EVDO_B=12

        NETWORK_TYPE_GPRS=1

        NETWORK_TYPE_GSM=16

        NETWORK_TYPE_HSDPA=8

        NETWORK_TYPE_HSPA=10

        NETWORK_TYPE_HSPAP=15

        NETWORK_TYPE_HSUPA=9

        NETWORK_TYPE_IDEN=11

        NETWORK_TYPE_IWLAN=18

        NETWORK_TYPE_LTE=13 4G

        NETWORK_TYPE_NR=20 5G

        NETWORK_TYPE_TD_SCDMA=17

        NETWORK_TYPE_UMTS=3

        NETWORK_TYPE_UNKNOWN=0

        PHONE_TYPE_CDMA=2

        PHONE_TYPE_GSM=1

        PHONE_TYPE_NONE=0

        PHONE_TYPE_SIP=3







         */
        //MAIN CAMERA
textViewMainCamera=findViewById(R.id.textViewMainCameraValue);
textViewMainCamera.setText(R.string.comming_soon);
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                CameraManager cameraManager=(CameraManager) this.getSystemService(CAMERA_SERVICE);



            }

            } else {
                // no camera on this device

            }

        //SELFIE CAMERA
textViewSelfieCamera=findViewById(R.id.textViewSelfieCameraValue);
        textViewSelfieCamera.setText(R.string.comming_soon);
        //BATTERY
        textViewBattery=findViewById(R.id.textViewBatteryValue);
        textViewBattery.setText(R.string.comming_soon);

        //



    }

}
