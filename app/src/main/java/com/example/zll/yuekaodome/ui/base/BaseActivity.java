package com.example.zll.yuekaodome.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zll.yuekaodome.utils.IBase;

import javax.inject.Inject;

/**
 * Created by zll on 2018/6/29.
 *
 */

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView,IBase {
    @Inject
    protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(ContractLayout());
        inject();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.DatechView();
        }

    }

    @Override
    public void initView(View view) {

    }
}
