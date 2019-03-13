package com.example.android.mymall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "hahaadhfula"));
        categoryModelList.add(new CategoryModel("link", "asdwqqww"));
        categoryModelList.add(new CategoryModel("link", "faweadfad"));
        categoryModelList.add(new CategoryModel("link", "bfssbgdhh"));
        categoryModelList.add(new CategoryModel("link", "xcvzcxzczx"));
        categoryModelList.add(new CategoryModel("link", "ytuytutyuty"));
        categoryModelList.add(new CategoryModel("link", "pksgsflgs"));
        categoryModelList.add(new CategoryModel("link", "qwesdc"));
        categoryModelList.add(new CategoryModel("link", "mygxsgzs"));
        categoryModelList.add(new CategoryModel("link", "neafaez"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        return view;
    }

}
