package com.lzr.taoke.application;

import android.app.Application;

/**
 * Created by Administrator on 2017/6/15.
 * 1.是整个APP的入口
 * 2.组件的初始化
 * 3.为整个app提供上下文
 */

public class TaoKeApplication extends Application {

    private static TaoKeApplication application = null;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static TaoKeApplication getInstance() {
        return application;
    }

}
