package com.example.admin.videoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.admin.videoapp.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by Admin on 9/14/2018.
 */

public class PlayActivity extends AppCompatActivity{
    JzvdStd player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        player=findViewById(R.id.play_pa);
        Intent i=getIntent();
        Bundle bd=i.getExtras();
        String url=bd.getString("abc");

        if (url != null) {
            player.setUp(url,"Video",Jzvd.SCREEN_WINDOW_FULLSCREEN);
            player.thumbImageView.setImageDrawable(getResources().getDrawable(R.drawable.ph1));
        }
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
