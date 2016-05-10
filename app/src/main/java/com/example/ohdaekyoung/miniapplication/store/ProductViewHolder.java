package com.example.ohdaekyoung.miniapplication.store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;
import com.bumptech.glide.Glide;

/**
 * Created by dongja94 on 2016-05-09.
 */
public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView thumbView;
    TextView nameView, descriptionView, scoreView, downloadView, detailView;

    TStoreProduct product;

    public interface OnItemClickListener {
        public void onItemClick(View view, TStoreProduct product);
    }

    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ProductViewHolder(View itemView) {
        super(itemView);
        thumbView = (ImageView)itemView.findViewById(R.id.image_thumb);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        scoreView = (TextView)itemView.findViewById(R.id.text_score);
        downloadView = (TextView)itemView.findViewById(R.id.text_download);
        descriptionView = (TextView)itemView.findViewById(R.id.text_description);
        detailView = (TextView)itemView.findViewById(R.id.text_detail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, product);
                }
            }
        });
    }

    public void setProduct(TStoreProduct product) {
        this.product = product;


        Glide.with(thumbView.getContext()).load(this.product.getThumbnailUrl()).into(thumbView);

        nameView.setText(product.getName());
        descriptionView.setText(product.getDescription());
        scoreView.setText(""+product.getScore());
        downloadView.setText(""+product.getDownloadCount());
        detailView.setText(product.getDetailDescription());
    }
}
