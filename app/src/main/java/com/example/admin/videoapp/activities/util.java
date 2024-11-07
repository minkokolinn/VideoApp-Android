package com.example.admin.videoapp.activities;

import android.content.Context;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;

/**
 * Created by Admin on 9/14/2018.
 */

public class util {
    public void download(final Context ctxt, String url, String path, final String name){
        PRDownloader.download(url,path,name).build().start(new OnDownloadListener() {
            @Override
            public void onDownloadComplete() {
                Toast.makeText(ctxt, name+" is download complete", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Error error) {

            }
        });
    }
}
