package com.huatec.myapplication.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.huatec.myapplication.R;

public class ImageUtil {

    public static void show(Activity activity, ImageView imageView, String uri) {
        RequestOptions options = getCommonRequestOptions();
        Glide.with(activity).load(uri).apply(options).into(imageView);
    }

    /**
     * 按原始图片长宽比显示
     * @param activity
     * @param uri
     */
    public static void showByScale(Activity activity, final ImageView imageView, String uri){
        Glide.with(activity).load(uri).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {

                int imageHeight = resource.getIntrinsicHeight();
                int imageWidth = resource.getIntrinsicWidth();
                int imageViewWidth = imageView.getMeasuredWidth();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = ((int) imageViewWidth * imageHeight / imageWidth);
                imageView.setImageDrawable(resource);
            }
        });
    }

    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options = new RequestOptions();

        //加载前占位图
        options.placeholder(R.drawable.ic_place_holder);

        //加载错误图
        options.error(R.drawable.ic_place_holder);

        options.centerCrop();

        //测试，禁用所有缓存
        //options.diskCacheStrategy(DiskCacheStrategy.NONE);

        return options;
    }
}
