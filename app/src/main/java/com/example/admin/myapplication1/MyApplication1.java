package com.example.admin.myapplication1;

import android.app.Application;

import com.sendbird.android.SendBird;

import static android.provider.UserDictionary.Words.APP_ID;

/**
 * Created by Admin on 4/12/2018.
 */

public class MyApplication1 extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SendBird.init("ADF01B55-A322-48BE-9A7B-F49F7F327F28", this);
    }
}
