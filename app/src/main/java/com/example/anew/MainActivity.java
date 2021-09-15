package com.example.anew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private OnboardingAdapter onbordingAdapter;
    private LinearLayout layoutOnboardinngIndicators;
    private MaterialButton buttonOnboardingAction;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutOnboardinngIndicators=findViewById(R.id.layoutOnbordingScreenIndicator);
        buttonOnboardingAction=findViewById(R.id.buttonOnbordingAction);


        setupOnboardingItems();
        Objects.requireNonNull(getSupportActionBar()).hide();

        ViewPager2 onbordingViewPager = findViewById(R.id.onboardingViewPager);
        onbordingViewPager.setAdapter(onbordingAdapter);
        setupOnboardingIndicators();
        setCurrentOnbordingIndicator(0);
        onbordingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnbordingIndicator(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(view -> {
            if (onbordingViewPager.getCurrentItem() +1 <onbordingAdapter.getItemCount()) {
                onbordingViewPager.setCurrentItem(onbordingViewPager.getCurrentItem() + 1);
            }
            else{
                startActivity(new Intent(getApplicationContext(),MainScreen.class));
                finish();
            }

        });

    }
        private void setupOnboardingItems(){
        List<OnboardingItem> onboardingItem= new ArrayList<>();

        OnboardingItem itemPayOnline =new OnboardingItem();
        itemPayOnline.setTitle("Book Your Appointment Online");
        itemPayOnline.setDescription("making online appointments to channeling is safe due to prevailing covid-19");
        itemPayOnline.setImage(R.drawable.iconz);

        OnboardingItem itemOnTheway =new OnboardingItem();
        itemOnTheway.setTitle("You Can Order Medicine Online");
        itemOnTheway.setDescription("All types of medical supplies can be purchased in online");
        itemOnTheway.setImage(R.drawable.icony);

        OnboardingItem itemEatTogether =new OnboardingItem();
        itemEatTogether.setTitle("Medical Checkup");
        itemEatTogether.setDescription("You can get all kinds of medical checks by online appointments");
        itemEatTogether.setImage(R.drawable.iconm);

        OnboardingItem medical =new OnboardingItem();
        medical.setTitle("We Can deliver Your Medicine");
        medical.setDescription("We will deliver medicines to you free of charge and as soon as possible");
        medical.setImage(R.drawable.iconx);

        onboardingItem.add(itemPayOnline);
        onboardingItem.add(itemOnTheway);
        onboardingItem.add(itemEatTogether);
        onboardingItem.add(medical);

        onbordingAdapter=new OnboardingAdapter(onboardingItem);

    }

    private
     void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onbordingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8 ,0,8,0);
        for (int i =0 ; i<indicators.length; i++){
            indicators[i]=new ImageView(
                    getApplicationContext()
            );
            indicators[i].setImageDrawable(ContextCompat.getDrawable
                    (getApplicationContext(),R.drawable.onbording_indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardinngIndicators.addView(indicators[i]);
        }

    }
    @SuppressLint("SetTextI18n")
    private void setCurrentOnbordingIndicator(int index){
        int childcount = layoutOnboardinngIndicators.getChildCount();
        for (int i = 0; i<childcount; i++){
            ImageView imageView = (ImageView) layoutOnboardinngIndicators.getChildAt(i);
            if (i == index ) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onbording_indicator_active)
                );
            }else
                {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onbording_indicator_inactive)
                );

                }
            }
        if (index == onbordingAdapter.getItemCount() -1) {
            buttonOnboardingAction.setText("Start");
        }
        else{
            buttonOnboardingAction.setText("Next");
        }
        }


    }
