package com.example.ohdaekyoung.miniapplication.store;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;

public class TStoreAppListActivity extends AppCompatActivity {

    String code;
    RecyclerView listView;
    ProductAdapter mAdapter;

    public static final String EXTRA_CATEGORY_CODE = "category_code";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tstore_app_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter=new ProductAdapter();
        mAdapter.setOnItemClickListener(new ProductViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, TStoreProduct product) {
                Intent intent = new Intent(TStoreAppListActivity.this, TStoreDetailActivity.class);
                intent.setData(Uri.parse(product.getWebUrl()));
                startActivity(intent);
            }
        });
        listView=(RecyclerView)findViewById(R.id.rv_app_list);
        listView.setAdapter(mAdapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
        setData();
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
    private void setData() {
        for (int i = 0 ; i < 10 ; i++) {
            TStoreProduct p = new TStoreProduct();
            p.setCategoryPath(code);
            p.setCharge(0);
            p.setDescription("description " + i);
            p.setDetailDescription("detail " + i);
            p.setDownloadCount(i);
            p.setName("name " + i);
            p.setProductId("productid" + i);
            p.setScore(0.0f);
            p.setThumbnailUrl("url");
            p.setTinyUrl("url");
            p.setWebUrl("http://www.tstore.co.kr/userpoc/game/view?pid=0000699882");
            mAdapter.add(p);
        }
    }
}
