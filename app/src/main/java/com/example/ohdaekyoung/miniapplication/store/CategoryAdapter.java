package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohdaekyoung.miniapplication.data.TStoreCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OhDaeKyoung on 2016. 5. 9..
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    List<TStoreCategory> items=new ArrayList<>();

    public void add(TStoreCategory t)
    {
        items.add(t);
        notifyDataSetChanged();
    }
    public void addAll(List<TStoreCategory> item){
        this.items.addAll(item);
        notifyDataSetChanged();
    }
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }

    public CategoryAdapter() {
        super();
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.setCategory(items.get(position));
        holder.setOnItemClickListener(mListner);

    }
    CategoryViewHolder.OnItemClickListener mListner;
    public void setOnItemClickListener(CategoryViewHolder.OnItemClickListener listener)
    {
        mListner=listener;
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,null);
        return new CategoryViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }





    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
