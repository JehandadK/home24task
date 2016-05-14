package com.jehandadk.home24.base;

/**
 * Created by jehandad.kamal on 12/18/2015.
 */
public interface ILoadingListener {

    void onLoadingStarted(ICancellableTask identifier);

    void onLoadingFinished(ICancellableTask identifier);
}
