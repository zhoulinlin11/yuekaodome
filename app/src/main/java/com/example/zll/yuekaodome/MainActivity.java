package com.example.zll.yuekaodome;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.zll.yuekaodome.adapter.MyFragmentAdapter;
import com.example.zll.yuekaodome.fragment.ClassifyFragment;
import com.example.zll.yuekaodome.fragment.FindFragment;
import com.example.zll.yuekaodome.fragment.HomePageFragment;
import com.example.zll.yuekaodome.fragment.MineFragment;
import com.example.zll.yuekaodome.ui.shoppingcar.ShoppingcarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private ViewPager flcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);
        //找到控件
        rg = findViewById(R.id.rg);
        flcontent = findViewById(R.id.flcontent);


        List<Fragment> list=new ArrayList<>();
        list.add(new HomePageFragment());
        list.add(new ClassifyFragment());
        list.add(new FindFragment());
        list.add(new ShoppingcarFragment());
        list.add(new MineFragment());
        flcontent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg.check(R.id.homepage);
                        break;
                    case 1:
                        rg.check(R.id.classify);
                        break;
                    case 2:
                        rg.check(R.id.find);
                        break;
                    case 3:
                        rg.check(R.id.shoppingcar);
                        break;
                    case 4:
                        rg.check(R.id.mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        flcontent.setAdapter(adapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.homepage:
                        flcontent.setCurrentItem(0);
                        break;
                    case R.id.classify:
                        flcontent.setCurrentItem(1);
                        break;
                    case R.id.find:
                        flcontent.setCurrentItem(2);
                        break;
                    case R.id.shoppingcar:
                        flcontent.setCurrentItem(3);
                        break;
                    case R.id.mine:
                        flcontent.setCurrentItem(4);
                        break;
                }
            }
        });

    }
}
