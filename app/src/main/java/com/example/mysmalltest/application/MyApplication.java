package com.example.mysmalltest.application;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by zhengyg on 2018/4/23.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Small.preSetUp(this);
    }
}
