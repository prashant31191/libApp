package com.libapp.utils;

import android.location.Location;

/**
 * Created by prashant.patel on 5/24/2017.
 */
public class AppInfoSetData
{
    AppInfoListener appInfoListener;

    String advertisingId="";
    String macAdressId="";
    Location location;

    public AppInfoSetData(AppInfoListener appInfoListener)
    {
        this.appInfoListener = appInfoListener;
    }

    public void setAdvertisingId(String advertisingId) {
        this.advertisingId = advertisingId;
    }

    public String getAdvertisingId() {
        return advertisingId;
    }

    public void setMacAdressId(String macAdressId) {
        this.macAdressId = macAdressId;
    }

    public String getMacAdressId() {
        return macAdressId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    /*
    public void setAppInfoListener(AppInfoListener appInfoListener) {
        this.appInfoListener = appInfoListener;
    }

    public AppInfoListener getAppInfoListener() {
        return appInfoListener;
    }

    */

    /*
    AppInfoSetData(String adsId,String macId)
    {
        if(adsId !=null && adsId.length() > 0)
        {
            advertisingId = adsId;
        }

        if(macId !=null && macId.length() > 0)
        {
            macAdressId = macId;
        }

    }*/

}
