package com.raju.demo.mvp.presenter.base;

import com.raju.demo.mvp.view.base.IDataView;

public interface IListPresenter<V extends IDataView> extends IPresenter {
    void init(V view);
}
