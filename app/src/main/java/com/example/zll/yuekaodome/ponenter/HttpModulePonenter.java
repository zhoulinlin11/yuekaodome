package com.example.zll.yuekaodome.ponenter;

import com.example.zll.yuekaodome.ui.shoppingcar.ShoppingcarFragment;
import com.example.zll.yuekaodome.module.HttpModule;

import dagger.Component;

/**
 * Created by zll on 2018/6/29.
 */
@Component(modules = HttpModule.class)
public interface HttpModulePonenter {
    void inject(ShoppingcarFragment shoppingcarFragment);
}
