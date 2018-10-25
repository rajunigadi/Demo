package com.raju.demo.dagger.modules;

import com.raju.demo.mvp.api.UsersApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class UsersModule {
    @Provides
    UsersApi providesUsersApi(Retrofit retrofit) {
        return retrofit.create(UsersApi.class);
    }
}
