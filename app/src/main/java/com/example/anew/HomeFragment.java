package com.example.anew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.anew.doctor.DoctorFragment;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment  {

    SliderView sliderView;
    int[] images = {R.drawable.slider2,
            R.drawable.slider1,
            R.drawable.slider3,
            R.drawable.slider6,
            R.drawable.slider5,
            R.drawable.slider4};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setContentView(R.layout.fragment_home);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//
//        Button homebtn1 = (Button) view.findViewById(R.id.homebtn1);
//        homebtn1.setOnClickListener(this);

        sliderView = view.findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        // Inflate the layout for this fragment

        return view;
    }
//    @Override
//    public void onClick(View view) {
//        Fragment fragment = null;
//        switch (view.getId()) {
//            case R.id.homebtn1:
//                fragment = new DoctorFragment();
//                replaceFragment(fragment);
//                break;

//            case R.id.phbookButton:
//                fragment = new PhoneBookFragment();
//                replaceFragment(fragment);
//                break;
        }
    //}

//    public void replaceFragment(Fragment someFragment) {
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.content_frame, someFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();



