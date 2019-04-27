package com.bwie.core;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.bwie.activity.MainActivity;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/27 10:46
 * Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new MainActivity());
    }
}
