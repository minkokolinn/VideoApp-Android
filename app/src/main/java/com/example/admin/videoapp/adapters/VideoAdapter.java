package com.example.admin.videoapp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.videoapp.R;
import com.example.admin.videoapp.models.Hits;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Admin on 9/14/2018.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder>{
    Context ctxt;
    List<Hits> hits;

    public VideoAdapter(Context ctxt, List<Hits> hits) {
        this.ctxt = ctxt;
        this.hits = hits;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(ctxt).inflate(R.layout.sample_view,parent,false);
        return new VideoHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        final Hits h=hits.get(position);
        String picId=h.getPicture_id();
        String imgurl="https://i.vimeocdn.com/video/"+picId+"_640x360.jpg";
        Log.d("abc",imgurl);
        Picasso pic=new Picasso.Builder(ctxt).listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                Log.e("hello123",exception.getMessage());
            }
        }).build();
        pic.load(imgurl).placeholder(R.drawable.ph1)
                .error(R.drawable.video).into(holder.iv);
if(!h.getUserImageURL().isEmpty()) {
    Picasso.with(ctxt).load(h.getUserImageURL()).into(holder.civ);
}

        holder.tv.setText(h.getUser());

        holder.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc.onPlayClick(h.getVideos().getMedium().getUrl());
            }
        });
        holder.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc.onDownloadClick(h.getVideos().getMedium().getUrl());
            }
        });

    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{
        CircleImageView civ;
        TextView tv;
        ImageButton btnPlay,btnDown;
        ImageView iv;
        public VideoHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_sv);
            civ=itemView.findViewById(R.id.civ_sv);
            tv=itemView.findViewById(R.id.tv_name_sv);
            btnPlay=itemView.findViewById(R.id.btn_play_sv);
            btnDown=itemView.findViewById(R.id.btn_download_sv);
        }
    }
    public void setonCustomClick(onCustomClick cc){
        this.cc=cc;
    }

    onCustomClick cc;
    public interface onCustomClick{
        void onPlayClick(String url);
        void onDownloadClick(String url);
    }
}
