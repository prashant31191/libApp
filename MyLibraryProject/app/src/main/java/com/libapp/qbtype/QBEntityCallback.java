package com.libapp.qbtype;

import android.os.Bundle;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public interface QBEntityCallback<T> {
    void onSuccess(T var1, Bundle var2);

    void onError(Exception var1);
}
