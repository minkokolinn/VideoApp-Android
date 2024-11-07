package com.example.admin.videoapp.download;

import android.app.Application;

import com.downloader.PRDownloader;

/**
 * Created by Admin on 9/14/2018.
 */

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        PRDownloader.initialize(getApplicationContext());
    }
}
