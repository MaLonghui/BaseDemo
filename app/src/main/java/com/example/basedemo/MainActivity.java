package com.example.basedemo;

import android.content.Context;
import android.os.Bundle;

import com.example.basedemo.api.Api;
import com.example.basedemo.base.basemvp.BaseMvpActivity;
import com.example.basedemo.bean.ListBean;
import com.example.basedemo.mvp.Contarct;
import com.example.basedemo.mvp.Presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseMvpActivity<Contarct.View,Contarct.Presenter> implements Contarct.View {

    @Override
    protected Contarct.Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
        Map<String,Object> nHeadMap = new HashMap<>();
        Map<String,Object> nMap = new HashMap<>();
        mPresenter.getData(Api.LIST,nHeadMap,nMap, ListBean.class);
    }



    @Override
    public void getView(Object o) {
        ListBean listBean = (ListBean) o;
        List<ListBean.DataBean> data = listBean.getData();
        showToast(data.get(1).getNews_title());

    }



}
