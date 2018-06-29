package com.example.zll.yuekaodome.net;

import com.example.zll.yuekaodome.bean.ShopBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zll on 2018/6/29.
 * retrofit
 * 拼接接口的时候常量的接口一定要以/结尾，否则请求出来的数据不是你想要的数据
 *
 */

public interface ShopCarApiService {
    @FormUrlEncoded
    @POST("product/getCarts")
    Observable<ShopBean> getShopService(@Field("uid") String uid,@Field("token") String token);
}
