package com.example.basedemo.mvp;

import com.example.basedemo.base.basemvp.BaseContract;

import java.util.Map;

public class Contarct {
    public interface View extends BaseContract.BaseView{
        void getView(Object o);
    }

    public interface Presenter extends BaseContract.BasePresenter<View>{
        void getData(String url, Map<String,Object> headMap,Map<String,Object> map,Class clz);
        void postData(String url, Map<String,Object> headMap,Map<String,Object> map,Class clz);
        void putData(String url, Map<String,Object> headMap,Map<String,Object> map,Class clz);
        void deleteData(String url, Map<String,Object> headMap,Map<String,Object> map,Class clz);

    }
}
