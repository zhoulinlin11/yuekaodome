package com.example.zll.yuekaodome.module;

import com.example.zll.yuekaodome.net.Api;
import com.example.zll.yuekaodome.net.DeleteCartApi;
import com.example.zll.yuekaodome.net.DeleteCartApiService;
import com.example.zll.yuekaodome.net.ShopCarApi;
import com.example.zll.yuekaodome.net.ShopCarApiService;
import com.example.zll.yuekaodome.net.UpdateCartApi;
import com.example.zll.yuekaodome.net.UpdateCartApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zll on 2018/6/29.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder proviteOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS);
    }
    @Provides
    ShopCarApi proviteShopCar(OkHttpClient.Builder builder){
        ShopCarApiService shopCarApiService = new Retrofit.Builder()
                .baseUrl(Api.jdurl)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ShopCarApiService.class);
        return ShopCarApi.getShopCarApi(shopCarApiService);
    }
    @Provides
    UpdateCartApi provideUpdateCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.jdurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateCartApiService updateCartApiService = retrofit.create(UpdateCartApiService.class);
        return UpdateCartApi.getUpdateCartApi(updateCartApiService);
    }

    @Provides
    DeleteCartApi provideDeleteCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.jdurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DeleteCartApiService deleteCartApiService = retrofit.create(DeleteCartApiService.class);
        return DeleteCartApi.getDeleteCartApi(deleteCartApiService);
    }
}
