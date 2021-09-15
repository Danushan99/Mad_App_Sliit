package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class ScanFragment extends Fragment implements View.OnClickListener{


    private CardView Scard1,Scar2;//scan card
    public ScanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_scan,container,false);
        Scard1=(CardView) myView.findViewById(R.id.Scard1);
        Scard1.setOnClickListener(this);
        return myView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Scard1:
                startActivity(new Intent(this.requireContext(),ScanBooking.class));
        }
    }
}