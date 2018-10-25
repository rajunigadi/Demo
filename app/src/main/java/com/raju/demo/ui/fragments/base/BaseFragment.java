package com.raju.demo.ui.fragments.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raju.demo.mvp.presenter.base.IPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public abstract class BaseFragment<P extends IPresenter> extends Fragment {

    @Inject
    protected P presenter;

    private Unbinder unbinder;
    private int layoutId;
    private String title;

    protected BaseFragment(int layoutId, String title) {
        this.layoutId = layoutId;
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        /*setupToolBar();*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder !=null){
            unbinder.unbind();
            unbinder = null;
        }
        if(presenter != null) {
            presenter.destroy();
        }
    }
}

