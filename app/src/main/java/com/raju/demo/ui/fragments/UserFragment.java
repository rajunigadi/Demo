package com.raju.demo.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.raju.demo.R;
import com.raju.demo.mvp.model.ListItem;
import com.raju.demo.mvp.model.User;
import com.raju.demo.mvp.presenter.UserPresenter;
import com.raju.demo.mvp.view.IUserView;
import com.raju.demo.ui.adapters.UsersAdapter;
import com.raju.demo.ui.adapters.base.ClickableItemTarget;
import com.raju.demo.ui.adapters.base.ItemClickListener;
import com.raju.demo.ui.adapters.delegate.base.DelegatingAdapter;
import com.raju.demo.ui.custom.SimpleDividerItemDecoration;
import com.raju.demo.ui.fragments.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class UserFragment extends BaseFragment<UserPresenter> implements IUserView, ItemClickListener<User> {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    UsersAdapter adapter;

    public UserFragment() {
        super(R.layout.fragment_users, "Today's Match");
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(recyclerView != null) {
            setupRecyclerView();
            setupAdapter(recyclerView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.init(this);
            presenter.getUsers();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(presenter != null)
            presenter.destroy();
    }

    @Override
    public void showLoading() {
        if(progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideLoading() {
        if(progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String message) {
        Timber.d(message);
    }

    @Override
    public void onClick(User user, int position, View view) {
        Timber.d("User clicked");
    }

    @Override
    public void bindData(List<ListItem> listItems) {
        adapter.refactorItems(listItems);

        /*if(viewPager.getAdapter() == null){
            CardAdapter cardAdapter = new CardAdapter(matchList);
            viewPager.setAdapter(cardAdapter);

            viewPager.setClipToPadding(false);
            viewPager.setPageMargin(marginBtwTabs);
            viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
                @Override public void transformPage(View page, float position) {
                    if (viewPager.getCurrentItem() == 0) {
                        page.setTranslationX(starPadding);
                    } else if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1) {
                        page.setTranslationX(-starPadding);
                    } else {
                        page.setTranslationX(middlePadding);
                    }
                }
            });
        }*/
    }

    protected void setupRecyclerView() {
        if(recyclerView != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        }
    }

    protected void setupAdapter(RecyclerView recyclerView) {
        if (recyclerView.getAdapter() != adapter) {
            recyclerView.setAdapter(adapter);

            if (adapter instanceof ClickableItemTarget) {
                @SuppressWarnings("unchecked")
                ClickableItemTarget<User> target = (ClickableItemTarget<User>) adapter;
                target.setItemClickListener(this);
            }

            if (adapter instanceof DelegatingAdapter) {
                adapter.setup();
            }
        }
    }
}