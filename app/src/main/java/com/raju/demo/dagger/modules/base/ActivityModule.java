package com.raju.demo.dagger.modules.base;

import com.raju.demo.dagger.PerActivity;
import com.raju.demo.ui.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
