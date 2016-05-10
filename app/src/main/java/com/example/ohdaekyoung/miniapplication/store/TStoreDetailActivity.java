package com.example.ohdaekyoung.miniapplication.store;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;
import com.example.ohdaekyoung.miniapplication.manager.NetworkManager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.Request;

public class TStoreDetailActivity extends AppCompatActivity {
    WebView webView;
    RecyclerView listview;
    ProductDetailManager mAdapter;
    GridLayoutManager manager;
    String productId;
    public static final String EXTRA_PRODUCT_ID="product_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tstore_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        mAdapter=new ProductDetailManager();
        manager=new GridLayoutManager(this,2);  //
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) { //포지션에 따라 한칸을 차지할거냐 두칸을 차지할거냐
                int type=mAdapter.getItemViewType(position);
                if(type==ProductDetailManager.VIEW_TYPED_HEADER || type==ProductDetailManager.VIEW_TYPE_TITLE)
                {return 2;}
                else{
                    return 1;
                }
            }
        });
        listview=(RecyclerView)findViewById(R.id.rv_list_detail);
        listview.setAdapter(mAdapter);
        listview.setLayoutManager(manager);
        Intent intent=getIntent();
        productId=intent.getStringExtra(EXTRA_PRODUCT_ID);

            setData();

        //    Uri uri=getIntent().getData();

    //    webView=(WebView)findViewById(R.id.webview);
    //    webView.setWebViewClient(new WebViewClient());
    //    webView.setWebChromeClient(new WebChromeClient());
    //    webView.loadUrl(uri.toString());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    private void setData() {

            NetworkManager.getInstance().getTStoreSearchProductDetail(this, productId, new NetworkManager.OnResultListener<TStoreProduct>() {
                @Override
                public void onSuccess(Request request, TStoreProduct result) {
                    mAdapter.setProduct(result);
                }

                @Override
                public void onFail(Request request, IOException exception) {

                }
            });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
