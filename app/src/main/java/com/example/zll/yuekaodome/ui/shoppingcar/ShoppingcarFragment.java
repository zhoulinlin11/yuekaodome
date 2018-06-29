package com.example.zll.yuekaodome.ui.shoppingcar;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.zll.yuekaodome.R;
import com.example.zll.yuekaodome.bean.SellerBean;
import com.example.zll.yuekaodome.bean.ShopBean;
import com.example.zll.yuekaodome.ponenter.DaggerHttpModulePonenter;

import com.example.zll.yuekaodome.ui.base.BaseFragment;
import com.example.zll.yuekaodome.ui.shoppingcar.adapter.ElvShopcartAdapter;

import java.util.List;

/**
 * Created by zll on 2018/6/29.
 */

public class ShoppingcarFragment extends BaseFragment<ShopCarPresenter> implements ShopCarContract.View {
    private ExpandableListView mElv;
    /**
     * 全选
     */
    private CheckBox mCbAll;
    /**
     * 合计：
     */
    private TextView mTvMoney;
    /**
     * 去结算：
     */
    private TextView mTvTotal;
    private ElvShopcartAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mPresenter.getCarts("12879","10401FFDCD75934C322C4A5C81931740");
    }


    @Override
    public int ContractLayout() {
        return R.layout.fragment_shoppingcar;
    }

    @Override
    public void inject() {
        DaggerHttpModulePonenter.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        mElv = (ExpandableListView)view.findViewById(R.id.elv);
        mCbAll = (CheckBox) view.findViewById(R.id.cbAll);
        mTvMoney = (TextView) view.findViewById(R.id.tvMoney);
        mTvTotal = (TextView) view.findViewById(R.id.tvTotal);

        mCbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null) {
                    adapter.changeAllState(mCbAll.isChecked());
                }
            }
        });

    }



    @Override
    public void showCartList(List<SellerBean> groupList, List<List<ShopBean.DataBean.ListBean>> childList) {
        //判断所有商家是否全部选中
        mCbAll.setChecked(isSellerAddSelected(groupList));

        //创建适配器
        adapter = new ElvShopcartAdapter(getContext(), groupList, childList, mPresenter);
        mElv.setAdapter(adapter);
        //获取数量和总价
        String[] strings = adapter.computeMoneyAndNum();
        mTvMoney.setText("总计：" + strings[0] + "元");
        mTvTotal.setText("去结算("+strings[1]+"个)");
        //        //默认展开列表
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);
        }

    }


    @Override
    public void updateCartsSuccess(String msg) {
        if (adapter!=null){
            adapter.updataSuccess();
        }
    }

    @Override
    public void deleteCartSuccess(String msg) {
        //调用适配器里的delSuccess()方法
        if (adapter!=null){
            adapter.delSuccess();
        }
    }

    /**
     * 判断所有商家是否全部选中
     *
     * @param groupList
     * @return
     */
    private boolean isSellerAddSelected(List<SellerBean> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            SellerBean sellerBean = groupList.get(i);
            if (!sellerBean.isSelected()) {
                return false;
            }
        }
        return true;
    }
}