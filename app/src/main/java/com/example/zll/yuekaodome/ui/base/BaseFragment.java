package com.example.zll.yuekaodome.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zll.yuekaodome.utils.IBase;

import javax.inject.Inject;

/**
 * Created by zll on 2018/6/29.
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView,IBase {
    @Inject
    protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        mPresenter.attachView(this);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(ContractLayout(), null);
        initView(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.DatechView();
    }
}
