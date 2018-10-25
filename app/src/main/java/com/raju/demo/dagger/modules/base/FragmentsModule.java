package com.raju.demo.dagger.modules.base;

import com.raju.demo.dagger.PerFragment;
import com.raju.demo.dagger.modules.UsersModule;
import com.raju.demo.ui.fragments.UserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {
    @PerFragment
    @ContributesAndroidInjector(modules = {UsersModule.class})
    abstract UserFragment bindUserFragment();
}
