package com.example.anew.medicin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.anew.R;
import com.example.anew.doctor.mediBuy;


public class medicineFragment extends Fragment implements View.OnClickListener {

    private CardView mcard1,mcar2;

    public medicineFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView=inflater.inflate(R.layout.fragment_medicine,container,false);
        mcard1=(CardView) myView.findViewById(R.id.mcard1);
        mcard1.setOnClickListener(this);
        return myView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mcard1:
                startActivity(new Intent(this.requireContext(), mediBuy.class));
        }
    }
}