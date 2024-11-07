package com.example.admin.videoapp.download;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.request.DownloadRequest;
import com.example.admin.videoapp.R;

/**
 * Created by Admin on 9/14/2018.
 */

public class DownActivity extends AppCompatActivity{
    Button btn;
    ProgressBar pb;
    int downId;
    String url="https://i.vimeocdn.com/video/529927645_640x360.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_activity);
        btn=findViewById(R.id.btn_download);
        pb=findViewById(R.id.pb);
        final String path= Environment.getExternalStorageDirectory().getPath()+"/VideoApp";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downId= PRDownloader.download(url,path,"image.jpg")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                Toast.makeText(DownActivity.this, "Start or resume download", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                Toast.makeText(DownActivity.this, "Cancel download", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                Toast.makeText(DownActivity.this, "Pause download", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long p=progress.currentBytes*100/progress.totalBytes;
                                pb.setProgress((int) p);
                                pb.setIndeterminate(false);
                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                btn.setText("complete");
                            }

                            @Override
                            public void onError(Error error) {
                                Toast.makeText(DownActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        ;
            }
        });
    }
}
