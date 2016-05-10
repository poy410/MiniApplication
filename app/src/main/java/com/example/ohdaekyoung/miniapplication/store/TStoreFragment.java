package com.example.ohdaekyoung.miniapplication.store;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class TStoreFragment extends Fragment {


    public TStoreFragment() {
        // Required empty public constructor
    }

    FragmentTabHost tabHost;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tstore, container, false);
        tabHost=(FragmentTabHost)view.findViewById(R.id.tabHost);
        tabHost.setup(getContext(),getChildFragmentManager(),android.R.id.tabcontent);

        TabWidget tabWidget=(TabWidget)tabHost.findViewById(android.R.id.tabs);

        View tabHeader = inflater.inflate(R.layout.tab_header, tabWidget, false);
         textView=(TextView)tabHeader.findViewById(R.id.text_title);
        textView.setText("Category");
      //  tabHost.setup(getContext(),getChildFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("category").setIndicator(tabHeader), TStoreCategortFragment.class, null);
        tabHeader = inflater.inflate(R.layout.tab_header, tabWidget, false);
        textView=(TextView)tabHeader.findViewById(R.id.text_title);
        textView.setText("Search");
        tabHost.addTab(tabHost.newTabSpec("search").setIndicator(tabHeader),TStoreSearchFragment.class,null);
        tabHeader = inflater.inflate(R.layout.tab_header, tabWidget, false);
        textView=(TextView)tabHeader.findViewById(R.id.text_title);
        textView.setText("TEST");
        tabHost.addTab(tabHost.newTabSpec("TEST").setIndicator(tabHeader),TStoreTestFragment.class,null);
        return view;
    }

}
