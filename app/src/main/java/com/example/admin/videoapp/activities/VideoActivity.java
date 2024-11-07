package com.example.admin.videoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.videoapp.R;
import com.example.admin.videoapp.adapters.VideoAdapter;
import com.example.admin.videoapp.models.Hits;
import com.example.admin.videoapp.models.Video;
import com.example.admin.videoapp.networks.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 9/14/2018.
 */

public class VideoActivity extends AppCompatActivity{
    RecyclerView rv;
    String str="https://pixabay.com/";
    util u;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        rv=findViewById(R.id.rv_va);
        rv.setLayoutManager(new LinearLayoutManager(VideoActivity.this));
        u=new util();
        Intent i=getIntent();
        Bundle bd=i.getExtras();
        String findword=bd.getString("abc");

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(str)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api=retrofit.create(ApiService.class);
        api.getVideo("10109852-f12434a85e5f8601c1214df2d",findword,"true").enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                if(response.isSuccessful()){
                    Video v=response.body();
                    List<Hits> h=v.getHits();
                    VideoAdapter adapter=new VideoAdapter(VideoActivity.this,h);
                    rv.setAdapter(adapter);
                    adapter.setonCustomClick(new VideoAdapter.onCustomClick() {
                        @Override
                        public void onPlayClick(String url) {
                            Intent i=new Intent(VideoActivity.this,PlayActivity.class);
                            Bundle bd=new Bundle();
                            bd.putString("abc",url);
                            i.putExtras(bd);
                            startActivity(i);
                        }

                        @Override
                        public void onDownloadClick(String url) {
String path= Environment.getExternalStorageDirectory().getPath()+"/VideoApp";
                            String[] name=url.split("external/");
                            Log.d("abc",name[1]);
                            String[] n2=name[1].split("\\?");
                            Log.d("abc",n2[0]);
                            u.download(VideoActivity.this,url,path,n2[0]);

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                Toast.makeText(VideoActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
