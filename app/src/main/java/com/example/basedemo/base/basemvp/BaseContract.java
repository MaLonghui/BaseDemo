package com.example.basedemo.base.basemvp;

import android.content.Context;

public interface BaseContract {
    interface BaseView{

    }

    interface BasePresenter<V extends BaseView>{
        void attchView(V view);
        void detachView();
    }
}
