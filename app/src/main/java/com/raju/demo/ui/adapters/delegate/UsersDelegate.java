package com.raju.demo.ui.adapters.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raju.demo.R;
import com.raju.demo.mvp.model.User;
import com.raju.demo.ui.adapters.base.ViewAdapterHolder;
import com.raju.demo.ui.adapters.delegate.base.ListAdapterDelegate;

import butterknife.BindView;

public class UsersDelegate extends ListAdapterDelegate<User> {

    public UsersDelegate() {
        super(R.layout.layout_user_item, User.class);
    }

    @Override
    protected final RecyclerView.ViewHolder formViewHolder(@NonNull View v) {
        return new UsersDelegate.UserViewHolder(v);
    }

    class UserViewHolder extends AdapterViewHolder implements ViewAdapterHolder<User> {

        UserViewHolder(View view) {
            super(view);
        }

        @Override
        public void setData(User user, int position) {
            tvUser.setText(user.getLogin());
        }

        @BindView(R.id.tv_name)
        TextView tvUser;
    }
}
