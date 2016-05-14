package com.jehandadk.home24;

import android.app.Application;

import com.jehandadk.home24.modules.ApiModule;
import com.jehandadk.home24.modules.AppModule;
import com.jehandadk.home24.modules.DaggerMainComponent;
import com.jehandadk.home24.modules.MainComponent;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */
public class App extends Application {

    protected MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createComponent();
    }

    protected void createComponent() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
