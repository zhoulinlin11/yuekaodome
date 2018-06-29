package com.example.zll.yuekaodome.ui.shoppingcar;

import com.example.zll.yuekaodome.bean.SellerBean;
import com.example.zll.yuekaodome.bean.ShopBean;
import com.example.zll.yuekaodome.ui.base.BaseContract;

import java.util.List;

/**
 * Created by zll on 2018/6/29.
 */

public interface ShopCarContract {
    interface View extends BaseContract.BaseView {
        void showCartList(List<SellerBean> groupList, List<List<ShopBean.DataBean.ListBean>> childList);

        void updateCartsSuccess(String msg);

        void deleteCartSuccess(String msg);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getCarts(String uid, String token);

        void updateCarts(String uid, String sellerid, String pid, String num, String selected, String token);

        void deleteCart(String uid, String pid, String token);
    }
}
