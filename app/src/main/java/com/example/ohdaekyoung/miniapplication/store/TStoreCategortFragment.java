package com.example.ohdaekyoung.miniapplication.store;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ohdaekyoung.miniapplication.R;
import com.example.ohdaekyoung.miniapplication.data.TStoreCategory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TStoreCategortFragment extends Fragment {

    RecyclerView listView;
    CategoryAdapter mAdapter;
    public TStoreCategortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tstore_categort, container, false);
        listView=(RecyclerView)view.findViewById(R.id.rv_list);
        listView.setAdapter(mAdapter);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter=new CategoryAdapter();
        mAdapter.setOnItemClickListener(new CategoryViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, TStoreCategory category) {
                Toast.makeText(getContext(),"Code :" + category.getCategoryCode(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),TStoreAppListActivity.class);
                intent.putExtra(TStoreAppListActivity.EXTRA_CATEGORY_CODE, category.getCategoryCode());
                startActivity(intent);


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();

    }

    private void setData() {
        mAdapter.clear();
        for (int i = 0; i < 10; i++) {
            TStoreCategory category = new TStoreCategory();
            category.setCategoryName("Category " + i);
            category.setCategoryCode("Code : " + i);
            mAdapter.add(category);
        }
    }

}
