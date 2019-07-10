package com.example.basedemo.base.basemvp;

public class BasePresenter<V extends BaseContract.BaseView> implements BaseContract.BasePresenter<V> {
    protected V mView;

    @Override
    public void attchView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
