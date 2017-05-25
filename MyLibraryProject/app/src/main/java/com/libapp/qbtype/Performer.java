package com.libapp.qbtype;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public interface Performer<T> extends QBCancelable {
    void performAsync(QBEntityCallback<T> var1);

    T perform() throws Exception;

    <R> R convertTo(PerformProcessor<?> var1);

    boolean isCanceled();
}