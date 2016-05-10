package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.data.TStorePhoneModel;

/**
 * Created by Tacademy on 2016-05-10.
 */
public class ModelViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ModelViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }

    TStorePhoneModel model;

    public void setModel(TStorePhoneModel model) {
        this.model = model;
        textView.setText(model.modelName + "(" + model.modelCode + ")");
    }
}