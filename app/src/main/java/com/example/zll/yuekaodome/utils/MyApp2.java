package com.example.zll.yuekaodome.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by zll on 2018/6/29.
 */

public class MyApp2 extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Uri uri=Uri.parse((String) path);
        imageView.setImageURI(uri);
    }

    @Override
    public ImageView createImageView(Context context) {
        return new SimpleDraweeView(context);
    }
}
