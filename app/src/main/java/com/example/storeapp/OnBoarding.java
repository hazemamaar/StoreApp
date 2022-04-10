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

    public OnBoarding() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtSkip=view.findViewById(R.id.txtskip);
        ViewPager2 viewPager2 =view.findViewById(R.id.viewpaggersplash);
        SplashScreenRecyclerView splashScreenRecyclerView =new SplashScreenRecyclerView(getActivity());
        viewPager2.setAdapter(splashScreenRecyclerView);
        IndicatorView indicatorView =view.findViewById(R.id.indictor);

        indicatorView.setSliderColor(R.color.labnyy, R.color.darkblue);
        indicatorView.setSliderWidth(40f);
        indicatorView.setSliderHeight(10f);
        indicatorView.setSlideMode(IndicatorSlideMode.WORM);
        indicatorView.setIndicatorStyle(IndicatorStyle.CIRCLE);
        indicatorView.setPageSize(3);
        indicatorView.notifyDataChanged();
        Button btn_next;
        btn_next =view.findViewById(R.id.nxtbtn);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
            }
        });
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
        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(view);

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
}