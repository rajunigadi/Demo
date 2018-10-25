package com.raju.demo.ui.adapters;

import com.raju.demo.ui.adapters.delegate.UsersDelegate;
import com.raju.demo.ui.adapters.delegate.base.AdapterDelegate;
import com.raju.demo.ui.adapters.delegate.base.DelegatingListAdapter;
import com.raju.demo.ui.adapters.delegate.base.ListAdapterDelegate;

import javax.inject.Inject;

public class UsersAdapter extends DelegatingListAdapter {

    @Inject
    UsersAdapter() {

    }

    @Override
    protected AdapterDelegate[] createDelegates() {
        return new ListAdapterDelegate[]{
                new UsersDelegate()
        };
    }
}