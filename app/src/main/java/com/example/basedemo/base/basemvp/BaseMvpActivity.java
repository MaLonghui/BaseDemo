package com.example.basedemo.base.basemvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basedemo.base.BaseActivity;

public abstract class BaseMvpActivity<V extends BaseContract.BaseView, T extends BaseContract.BasePresenter<V>> extends AppCompatActivity implements BaseContract.BaseView {

    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attchView((V) this);
        initData();
    }

    protected abstract void initData();

    protected abstract T initPresenter();
    /**
     * 有参跳转
     * @param clz
     * @param bundle
     */
    public void starActivity(Class<? extends Activity> clz, Bundle bundle){
        Intent intent = new Intent(this,clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Toast
     * @param msg
     */
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}


