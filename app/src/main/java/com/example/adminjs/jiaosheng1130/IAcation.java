package com.example.adminjs.jiaosheng1130;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Adminjs on 2017/11/30.
 */

public class IAcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
