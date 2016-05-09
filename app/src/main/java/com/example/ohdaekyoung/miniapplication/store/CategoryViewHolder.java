package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.data.TStoreCategory;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;

/**
 * Created by OhDaeKyoung on 2016. 5. 9..
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {
    TextView nameView;
    TStoreCategory category;

    public interface OnItemClickListener{
        public void onItemClick(View view, TStoreCategory category);
    }
    public CategoryViewHolder(View itemView) {
        super(itemView);
        nameView=(TextView)itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)
                {
                    mListener.onItemClick(v, category);
                }
            }
        });
    }
    OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }

    public void setCategory(final TStoreCategory category)
    {
        this.category=category;
        nameView.setText(this.category.getCategoryName());

    }
}
