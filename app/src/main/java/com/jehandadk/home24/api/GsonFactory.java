package com.jehandadk.home24.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jehandad.kamal on 5/15/2016.
 */
public class GsonFactory {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }

}
