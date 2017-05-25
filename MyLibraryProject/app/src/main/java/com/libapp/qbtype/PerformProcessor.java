package com.libapp.qbtype;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public interface PerformProcessor<R> {
    <T> R process(Performer<T> var1);
}
