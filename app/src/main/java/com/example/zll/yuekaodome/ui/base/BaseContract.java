package com.example.zll.yuekaodome.ui.base;

/**
 * Created by zll on 2018/6/29.
 */

public interface BaseContract {
    //抽取v层与p层中的公共方法
    interface BaseView{

    }
    interface BasePresenter<T extends BaseView>{
        void attachView(T view);
        void DatechView();
    }
}
