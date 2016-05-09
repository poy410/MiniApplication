package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OhDaeKyoung on 2016. 5. 9..
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    List<TStoreProduct> items=new ArrayList<>();


    public void add(TStoreProduct t)
    {
        items.add(t);
        notifyDataSetChanged();
    }
    public void addAll(List<TStoreProduct> items)
    {
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }
    public ProductAdapter() {
        super();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tstore_product,null);
        return new ProductViewHolder(view);
    }
    ProductViewHolder.OnItemClickListener mListenr;
    public void setOnItemClickListener(ProductViewHolder.OnItemClickListener listener)
    {
        mListenr=listener;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.setProduct(items.get(position));
        holder.setOnItemClickListener(mListenr);
    }
}
