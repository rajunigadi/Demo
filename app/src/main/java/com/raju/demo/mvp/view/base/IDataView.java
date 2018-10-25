package com.raju.demo.mvp.view.base;

public interface IDataView {
    void showLoading();
    void hideLoading();
    void showError(String message);
}