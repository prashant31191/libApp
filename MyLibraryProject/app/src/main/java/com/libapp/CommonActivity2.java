package com.libapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.libapp.utils.AdvertisingIdClient;
import com.libapp.utils.AppInfoListener;
import com.libapp.utils.AppInfoSet;
import com.libapp.utils.AppInfoSetData;
import com.libapp.utils.CommonObjects;
import com.libapp.utils.ErrorModel;
import com.libapp.utils.MacAdressId;
import com.libapp.utils.SucessModel;

/**
 * Created by CartelTech on 3/21/2017.
 */

@SuppressLint("LongLogTag")
public class CommonActivity2 extends AppCompatActivity implements  AppInfoListener{
    String macAdress = "", sha256MacAdress = "", advertisingId = "";
Button btnNext;
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        tvData = (TextView) findViewById(R.id.tvData);
        tvData.setText("===CommonActivity2===");

        //AppInfoSet.setOnInfoListner(this);
        CommonObjects.setActivityCommon(this);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommonActivity2.this,CommonActivity3.class));
            }
        });
/*

        //AppInfoListener listener = (AppInfoListener) mContext;
        ErrorModel errorModel = new ErrorModel();
        errorModel.exception = new Exception("Location Provider Disabled");

        AppInfoSet appInfoSet = new AppInfoSet();
        appInfoSet.setErrorModel(errorModel);

*/

    }


    @Override
    public void onSuccess(SucessModel sucessModel) {

        Log.i("==onSuccess=",sucessModel.getStatusCode());
        Log.i("==onSuccess=getAdvertisingId",sucessModel.getAdvertisingId());
        Log.i("==onSuccess=getMacAdressId",sucessModel.getMacAdressId());
        Log.i("==onSuccess=getSha256MacAdressId",sucessModel.getSha256MacAdressId());

        Log.i("==onSuccess=getLatitude",""+sucessModel.getLocationLatLong().getLatitude());
        Log.i("==onSuccess=getLongitude",""+sucessModel.getLocationLatLong().getLongitude());

        if(tvData !=null)
        {
            tvData.setText("========"+sucessModel.getStatusCode()+"==============");
        }
    }

    @Override
    public void onFailure(ErrorModel errorModel) {
        Log.i("==onFailure=getStatusCode",errorModel.getStatusCode());
        Log.i("==onFailure=getMessage",errorModel.getException().getMessage());
        if(tvData !=null)
        {
            tvData.setText("========"+errorModel.getStatusCode()+"==============");
        }
    }
}
