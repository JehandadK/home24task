package com.jehandadk.home24.modules;

import com.jehandadk.home24.BuildConfig;
import com.jehandadk.home24.api.GsonFactory;
import com.jehandadk.home24.api.IApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */

@Module
public class ApiModule {

    public ApiModule() {
    }

    @Provides
    @Singleton
    IApiClient provideApiService(Retrofit retrofit) {
        return retrofit.create(IApiClient.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.getGson()))
                .baseUrl(BuildConfig.ENDPOINT)
                .build();
    }

    @Provides
    OkHttpClient provideClient(Interceptor logger) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(logger);
        return builder.build();
    }

    @Provides
    Interceptor provideLogger() {
        // Just some stupid issue with my device
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        });
        logger.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);
        return logger;
    }


}
