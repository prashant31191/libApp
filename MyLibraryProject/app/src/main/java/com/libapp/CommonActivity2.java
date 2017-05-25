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
public class CommonActivity2 extends AppCompatActivity implements AppInfoListener {
    String macAdress = "", sha256MacAdress = "", advertisingId = "";
Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonActivity2.this,CommonActivity3.class));
            }
        });
        AppInfoSetData appInfoSetData = new AppInfoSetData(this);

        // calling this function for the getting mac address and Advertising Id.
    }


    @Override
    public void callbackAdvertisingId(String advertisingId) {
        Log.i("==callbackAdvertisingId==","====2advertisingId=="+advertisingId);
    }

    @Override
    public void callbackMacAdressId(String macAdressId) {
        Log.i("==callbackMacAdressId==","===2=macAdressId=="+macAdressId);
    }
}
