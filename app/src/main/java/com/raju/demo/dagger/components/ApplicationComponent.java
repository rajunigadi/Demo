package com.raju.demo.dagger.components;

import com.raju.demo.MyApp;
import com.raju.demo.dagger.modules.base.ActivityModule;
import com.raju.demo.dagger.modules.base.ApplicationModule;
import com.raju.demo.dagger.modules.base.FragmentsModule;
import com.raju.demo.dagger.modules.base.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityModule.class,
        FragmentsModule.class,
        NetworkModule.class

})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApp app);

        ApplicationComponent build();
    }

    void inject(MyApp app);
}

