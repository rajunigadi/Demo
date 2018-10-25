package com.raju.demo.dagger.modules.base;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.raju.demo.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import static okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

@Module
public class NetworkModule {

    public NetworkModule() {

    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();

        okClientBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        okClientBuilder.writeTimeout(60, TimeUnit.SECONDS);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HEADERS : NONE);
        okClientBuilder.addInterceptor(httpLoggingInterceptor);

        return okClientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }
}

