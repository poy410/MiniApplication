package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-05-10.
 */
public class TitleViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public TitleViewHolder(View itemView) {
        super(itemView);
        textView=(TextView)itemView;
    }
    public void setTitle(String title){
        textView.setText(title);
    }
}
