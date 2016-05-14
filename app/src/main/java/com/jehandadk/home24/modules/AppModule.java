package com.jehandadk.home24.modules;

import android.content.Context;

import com.jehandadk.home24.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */

@Module
public class AppModule {

    App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApplication;
    }


}