package com.example.ohdaekyoung.miniapplication.facebook;

import android.hardware.camera2.params.Face;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.FacebookFeed;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Tacademy on 2016-05-11.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {
    List<FacebookFeed> items=new ArrayList<>();
    public void addAll(List<FacebookFeed> items){
        this.items=items;
        notifyDataSetChanged();
    }
    public void add(FacebookFeed item){

    }
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.setFacebookFeed(items.get(position));
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_facebook_feed,null);
        return new FeedViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
