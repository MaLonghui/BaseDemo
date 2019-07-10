package com.example.basedemo.mvp;

import com.example.basedemo.api.Api;
import com.example.basedemo.api.ApiService;
import com.example.basedemo.base.basemvp.BasePresenter;
import com.example.basedemo.utils.RetrofitManager;
import com.google.gson.Gson;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;


public class Presenter extends BasePresenter<Contarct.View> implements Contarct.Presenter {
    @Override
    public void getData(String url, Map<String, Object> headMap, Map<String, Object> map, Class clz) {
        ApiService apiService = RetrofitManager.getInstance(Api.BASE_URL).setCreate(ApiService.class);
        apiService.get(url, headMap, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String bean = responseBody.string();
                        Gson gson = new Gson();
                        Object json = gson.fromJson(bean, clz);
                        mView.getView(json);
                    }
                });


    }

    @Override
    public void postData(String url, Map<String, Object> headMap, Map<String, Object> map, Class clz) {

    }

    @Override
    public void putData(String url, Map<String, Object> headMap, Map<String, Object> map, Class clz) {

    }

    @Override
    public void deleteData(String url, Map<String, Object> headMap, Map<String, Object> map, Class clz) {

    }
}
