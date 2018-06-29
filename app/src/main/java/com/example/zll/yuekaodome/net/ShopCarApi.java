package com.example.zll.yuekaodome.net;

import com.example.zll.yuekaodome.bean.ShopBean;

import java.util.IllegalFormatCodePointException;

import dagger.Reusable;
import io.reactivex.Observable;

/**
 * Created by zll on 2018/6/29.
 * 单例模式是为了保证只有一个单例实例
 */

public class ShopCarApi {
private static ShopCarApi shopCarApi;
private ShopCarApiService shopCarApiService;

    public ShopCarApi(ShopCarApiService shopCarApiService) {
        this.shopCarApiService = shopCarApiService;
    }
    public static ShopCarApi getShopCarApi(ShopCarApiService shopCarApiService){
        if (shopCarApi==null){
            shopCarApi=new ShopCarApi(shopCarApiService);
        }
        return shopCarApi;
    }
    public Observable<ShopBean> getshopService(String uid,String token){
        return shopCarApiService.getShopService(uid, token);
    }
}
