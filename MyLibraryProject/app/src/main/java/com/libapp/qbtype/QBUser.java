package com.libapp.qbtype;

import android.app.Activity;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public class QBUser {

    Activity activity;
    String v1;
    String v2;

    public QBUser() {
    }

    public QBUser(String v1, String v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public QBUser(Activity activity) {
        this.activity = activity;
    }
}
