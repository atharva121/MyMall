package com.example.android.mymall;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    ////////// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    ////////// Banner Slider

    ////////// Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdConatiner;
    ////////// Strip ad

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


        ////////// Banner Slider
        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.custom_error_icon, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.logo, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.green_email, "#5e0606"));

        sliderModelList.add(new SliderModel(R.drawable.red_email, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.app_icon, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.cart_black, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.profile_placeholder, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.home_icon, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.custom_error_icon, "#5e0606"));

        sliderModelList.add(new SliderModel(R.drawable.logo, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.green_email, "#5e0606"));
        sliderModelList.add(new SliderModel(R.drawable.red_email, "#5e0606"));
        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);
        bannerSliderViewPager.setCurrentItem(currentPage);
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
        ////////// Banner Slider

        ////////// Strip Ad
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdConatiner = view.findViewById(R.id.strip_ad_container);
        stripAdImage.setImageResource(R.drawable.profile_placeholder);
        stripAdConatiner.setBackgroundColor(Color.parseColor("#5e0606"));
        ////////// Strip Ad

        return view;
    }

    ////////// Banner Slider
    private void pageLooper(){
        if (currentPage == sliderModelList.size() - 2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
        if (currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }
    ////////// Banner Slider


}
