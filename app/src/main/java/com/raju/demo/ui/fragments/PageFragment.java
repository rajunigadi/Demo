package com.raju.demo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raju.demo.R;

import butterknife.ButterKnife;

public class PageFragment extends Fragment {

    public static PageFragment newInstance() {
        return new PageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Compartilhar");
        return view;
    }
}