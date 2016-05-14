package com.jehandadk.home24.modules;

import com.jehandadk.home24.selection.SelectionActivity;
import com.jehandadk.home24.start.StartActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */

@Singleton
@Component(
        modules = {AppModule.class, ApiModule.class}
)
public interface MainComponent {
    void inject(StartActivity activity);

    void inject(SelectionActivity activity);

}