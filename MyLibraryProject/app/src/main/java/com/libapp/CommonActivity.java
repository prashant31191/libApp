package com.libapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.libapp.utils.AdvertisingIdClient;
import com.libapp.utils.AppInfoListener;
import com.libapp.utils.AppInfoSetData;
import com.libapp.utils.MacAdressId;

/**
 * Created by CartelTech on 3/21/2017.
 */

@SuppressLint("LongLogTag")
public class CommonActivity extends AppCompatActivity implements AppInfoListener {
    String macAdress = "", sha256MacAdress = "", advertisingId = "";
    Button btnNext;
    AppInfoSetData appInfoSetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonActivity.this,CommonActivity2.class));
            }
        });

        appInfoSetData = new AppInfoSetData(this);


        AppInfoListener infoListener = new AppInfoListener() {
            @Override
            public void callbackAdvertisingId(String advertisingId) {

            }

            @Override
            public void callbackMacAdressId(String macAdressId) {

            }
        };

        // calling this function for the getting mac address and Advertising Id.
        getDeviceInfo();
    }


    /**
     * use this function for the getting encrypted SHA256 mac adress  and Advertising Id.
     * <p>
     * you can use any activity using in your application.
     */

    private void getDeviceInfo() {
        // get mac adress from your device
        macAdress = MacAdressId.getMacAddr();
        // get Mac Adress Id encrypt to SHA256
        sha256MacAdress = MacAdressId.encryptSHA256(macAdress);

        // for the get Advertising Id
        new Thread(new Runnable() {
            public void run() {
                try {
                    AdvertisingIdClient.AdInfo adInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                    // get AdvertisingId
                    advertisingId = adInfo.getId();


                    // pass "sha256MacAdress" variable for the encrypted sha256 mac adress
                    Log.i("MAC SHA526", sha256MacAdress);

                    // pass "advertisingId" variable for the Advertising Id
                    Log.i("AdvertisingId", advertisingId);

                     /*
                    set here api or webserice call

                    link like = "http://www.appurlxxxxxxx.com/appnameXXX/apiname.php?macaddr="+sha256MacAdress+"&adsId="+advertisingId

                        macaddr = Request parameter using for get Mac adress in your api
                        adsId = Request parameter using get Advertising id in your api
                    */
                    appInfoSetData.setAdvertisingId(advertisingId);
                    appInfoSetData.setMacAdressId(sha256MacAdress);



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    @Override
    public void callbackAdvertisingId(String advertisingId) {
        Log.i("==callbackAdvertisingId==","====advertisingId=="+advertisingId);
    }

    @Override
    public void callbackMacAdressId(String macAdressId) {
        Log.i("==callbackMacAdressId==","====macAdressId=="+macAdressId);
    }
}
