package com.example.ohdaekyoung.miniapplication.store;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ohdaekyoung.miniapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TStoreFragment extends Fragment {


    public TStoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tstore, container, false);
    }

}
