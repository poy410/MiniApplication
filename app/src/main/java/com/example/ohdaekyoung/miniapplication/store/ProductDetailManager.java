package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;


public class ProductDetailManager extends RecyclerView.Adapter<RecyclerView.ViewHolder> { //네가지 타입 모두 쓰기위해
    public static final int VIEW_TYPED_HEADER = 1;
    public static final int VIEW_TYPE_TITLE = 2;
    public static final int VIEW_TYPE_PREVIEW = 3;
    public static final int VIEW_TYPE_MODEL = 4;
    TStoreProduct product; // 얘가 데이터니까

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return VIEW_TYPED_HEADER;
        position--;
        if (product.getPreviewUrlList().size() > 0) {
            if (position == 0) return VIEW_TYPE_TITLE;
            position--;
            if (position < product.getPreviewUrlList().size()) {
                return VIEW_TYPE_PREVIEW;
            }
            position -= product.getPreviewUrlList().size();
        }
        if (product.getModels().modelList.size() > 0) {
            if (position == 0) return VIEW_TYPE_TITLE;
            position--;
            if (position < product.getModels().modelList.size()) {
                return VIEW_TYPE_MODEL;
            }
            position -= product.getModels().modelList.size();
        }

        throw new IllegalArgumentException("invalid position");
    }


    public void setProduct(TStoreProduct product) {
        this.product = product;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            if(product==null) {
                Log.i("heheh","hehe");

            }
            ProductViewHolder h = (ProductViewHolder)holder;
            h.setProduct(product);
            return;
        }
        position--;
        if (product.getPreviewUrlList().size() > 0) {
            if (position == 0) {
                TitleViewHolder h = (TitleViewHolder) holder;
                h.setTitle("Preview");
                return;
            }
            position--;
            if (position < product.getPreviewUrlList().size()) {
                ImageViewHolder h = (ImageViewHolder) holder;
                h.setPreviewImage(product.getPreviewUrlList().get(position));
                return;
            }
            position -= product.getPreviewUrlList().size();
        }
        if (product.getModels().modelList.size() > 0) {
            if (position == 0) {
                TitleViewHolder h = (TitleViewHolder) holder;
                h.setTitle("model");
                return;

            }
            position--;
            if (position < product.getModels().modelList.size()) {
                ModelViewHolder h = (ModelViewHolder) holder;
                h.setModel(product.getModels().modelList.get(position));
                return;
            }
            position -= product.getModels().modelList.size();
        }

        throw new IllegalArgumentException("invalid position");

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_TITLE: {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
                return new TitleViewHolder(view);
            }
            case VIEW_TYPE_MODEL: {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, null);
                return new ModelViewHolder(view);
            }
            case VIEW_TYPED_HEADER: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tstore_product, null);
                return new ProductViewHolder(view);
            }

            case VIEW_TYPE_PREVIEW: {
                View view = new ImageView(parent.getContext());
                return new ImageViewHolder(view);
            }
        }
        throw new IllegalArgumentException("invalid position");
    }



    @Override
    public int getItemCount() {
        if(product==null)return 0;
        int size=1;
        if(product.getPreviewUrlList().size()>0)
        {
            size+=1;
            size+= product.getPreviewUrlList().size();
        }
        if (product.getModels().modelList.size() > 0) {
            size += 1;
            size += product.getModels().modelList.size();
        }
        return size;
    }
}
