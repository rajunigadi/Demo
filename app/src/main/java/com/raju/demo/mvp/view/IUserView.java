package com.raju.demo.mvp.view;

import com.raju.demo.mvp.model.ListItem;
import com.raju.demo.mvp.view.base.IDataView;

import java.util.List;

public interface IUserView extends IDataView {
    void bindData(List<ListItem> items);
}