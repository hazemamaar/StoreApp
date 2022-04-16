package com.example.storeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;


public class OnBoarding extends Fragment {

    private  TextView txtSkip;
    private ViewPager2 viewPager2 ;
    private IndicatorView indicatorView;
    private NavController navController;
    private SplashScreenRecyclerView splashScreenRecyclerView ;
    private Button btn_next;

    public OnBoarding() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        indicatorinit();
        viewPager2Scrolling();

            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btn_next.getText().equals("Next")){
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);}
                    else {
                        navController.navigate(R.id.action_onBoarding_to_registration);
                    }
                }
            });

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_onBoarding_to_registration);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false);
    }

    void init(View view){
       txtSkip=view.findViewById(R.id.txtskip);
       viewPager2 =view.findViewById(R.id.viewpaggersplash);
       indicatorView =view.findViewById(R.id.indictor);
        btn_next =view.findViewById(R.id.nxtbtn);
       navController = Navigation.findNavController(view);
       splashScreenRecyclerView =new SplashScreenRecyclerView(getActivity());
       viewPager2.setAdapter(splashScreenRecyclerView);
    }
    @SuppressLint("ResourceAsColor")
    void indicatorinit(){
        indicatorView.setSliderColor(R.color.whiteB, R.color.white);
        indicatorView.setSliderWidth(40F);
        indicatorView.setSliderHeight(10f);
        indicatorView.setSlideMode(IndicatorSlideMode.WORM);
        indicatorView.setIndicatorStyle(IndicatorStyle.ROUND_RECT);
        indicatorView.setPageSize(3);
        indicatorView.notifyDataChanged();
    }
    void viewPager2Scrolling(){
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                indicatorView.onPageScrolled( position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==2){
                    btn_next.setText("Get Start");
                }else{
                    btn_next.setText("Next");
                }
                indicatorView.onPageSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}