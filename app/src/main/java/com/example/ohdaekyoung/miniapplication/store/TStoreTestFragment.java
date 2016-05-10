package com.example.ohdaekyoung.miniapplication.store;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreProduct;


public class TStoreTestFragment extends Fragment {

    // TODO: Rename and change types and number of parameters
    ProductAdapter mAdapter;
    RecyclerView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter=new ProductAdapter();
        setData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tstore_test, container, false);
        listView=(RecyclerView)view.findViewById(R.id.rv_list_test);
        listView.setAdapter(mAdapter);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    public void setData(){
            Log.i("testtest","haha");
               for (int i = 0 ; i < 10 ; i++) {
           TStoreProduct p = new TStoreProduct();
            p.setCategoryPath("DP000501");
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
