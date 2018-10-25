package com.raju.demo.mvp.presenter;

import com.google.gson.Gson;
import com.raju.demo.mvp.api.UsersApi;
import com.raju.demo.mvp.model.ListItem;
import com.raju.demo.mvp.model.User;
import com.raju.demo.mvp.presenter.base.BasePresenter;
import com.raju.demo.mvp.view.IUserView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UserPresenter extends BasePresenter<IUserView> {

    @Inject
    Gson gson;

    private UsersApi api;

    @Inject
    UserPresenter(UsersApi api) {
        this.api = api;
    }

    public void getUsers() {
        if(getView() != null) {
            getView().showLoading();
        }
        disposable.add(api.getUsers()
                .map(new Function<List<User>, List<ListItem>>() {
                    @Override
                    public List<ListItem> apply(List<User> users) throws Exception {
                        List<ListItem> listItems = new ArrayList<>();
                        listItems.addAll(users);
                        return listItems;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ListItem>>() {
                    @Override
                    public void accept(List<ListItem> listItems) throws Exception {
                        getView().bindData(listItems);
                        getView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showError(throwable.getMessage());
                        getView().hideLoading();
                    }
                }));
    }
}
