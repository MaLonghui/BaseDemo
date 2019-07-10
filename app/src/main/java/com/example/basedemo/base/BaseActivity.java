package com.example.basedemo.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.Action;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder = null;
    private boolean isStatus = false;//是否沉浸式状态栏
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    //初始化数据
    protected abstract void initData();
    //初始化控件
    protected abstract void initView();
    //绑定布局
    protected abstract int initLayoutId();

    /**
     * 无参跳转
     * @param clz
     */
    public void startActivity(Class<? extends Activity> clz){
        startActivity(new Intent(this,clz));
    }

    /**
     * 有参跳转
     * @param clz
     * @param bundle
     */
    public void starActivity(Class<? extends Activity> clz,Bundle bundle){
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
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unbinder = null;
    }
}
