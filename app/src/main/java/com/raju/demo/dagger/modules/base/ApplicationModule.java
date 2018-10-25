package com.raju.demo.dagger.modules.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.raju.demo.MyApp;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

@Module(includes = AndroidInjectionModule.class)
public class ApplicationModule {

    @Provides
    Context provideContext(MyApp application) {
        return application.getApplicationContext();
    }

    @Provides
    Application provideApplication(MyApp application) {
        return application;
    }

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    SharedPreferences provideSharedPrefs(MyApp application) {
        return application.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }
}
