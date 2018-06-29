package com.example.zll.yuekaodome.ui.base;

/**
 * Created by zll on 2018/6/29.
 * P层实现View接口方便与Activitty进行交互
 * 实现
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T>{


    protected T mView;
    @Override
    public void attachView(T view) {
        if (view!=null){
            this.mView=view;
        }

    }

    @Override
    public void DatechView() {
        if (mView!=null){
            mView=null;
        }
    }
}
