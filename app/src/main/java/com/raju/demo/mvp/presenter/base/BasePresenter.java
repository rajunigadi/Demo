package com.raju.demo.mvp.presenter.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.raju.demo.mvp.view.base.IDataView;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends IDataView> implements IListPresenter<V> {

    private V view;
    protected CompositeDisposable disposable = new CompositeDisposable();

    protected BasePresenter() {

    }

    @Override
    public void init(@NonNull V view) {
        this.disposable = new CompositeDisposable();
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        if(disposable!=null){
            disposable.clear();
            disposable = null;
        }
        this.view = null;
    }

    protected final V getView() {
        return view;
    }

    @CallSuper
    protected void showLoading() {
        view.showLoading();
    }

    @CallSuper
    protected void hideLoading() {
        view.hideLoading();
    }
}


