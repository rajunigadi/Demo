package com.raju.demo.mvp.api;

import com.raju.demo.mvp.model.ListItem;
import com.raju.demo.mvp.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface UsersApi {
    @POST("users")
    Observable<List<User>> getUsers();
}
