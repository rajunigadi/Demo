package com.raju.demo.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raju.demo.R;
import com.raju.demo.mvp.model.ListItem;
import com.raju.demo.mvp.model.User;

import java.util.List;

import timber.log.Timber;

public class PageAdapter extends PagerAdapter {

    private final List<ListItem> items;

    public PageAdapter(@NonNull List<ListItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items!= null && !items.isEmpty()?items.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 0.83f;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ListItem listItem = items.get(position);
        if (listItem instanceof User) {
            final User user = (User) items.get(position);
            View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_page_item,
                    container, false);
            itemView.setTag(position);
            setUIData(itemView, user);
            container.addView(itemView);
            return itemView;
        }

        throw new IllegalStateException("ListItem should be of Match");
    }

    private void setUIData(View view, final User match) {
        final CardView mCardView = (CardView) view.findViewById(R.id.card_view);
        TextView tvUser = (TextView) view.findViewById(R.id.tv_user);

        tvUser.setText(match.getLogin());

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timber.d("Card clicked");
            }
        });
    }
}
