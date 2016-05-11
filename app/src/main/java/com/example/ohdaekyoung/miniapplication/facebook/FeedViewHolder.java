package com.example.ohdaekyoung.miniapplication.facebook;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.FacebookFeed;

/**
 * Created by Tacademy on 2016-05-11.
 */
public class FeedViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public FeedViewHolder(View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.text_feed);
    }
    public void setFacebookFeed(FacebookFeed feed){
        textView.setText(feed.story!=null?feed.story : feed.message);
    }
}
