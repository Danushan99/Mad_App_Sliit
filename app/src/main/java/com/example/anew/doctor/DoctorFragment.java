package com.example.anew.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.anew.R;


public class DoctorFragment extends Fragment implements View.OnClickListener {
    private CardView card1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_doctor,container,false);
        card1=(CardView) myView.findViewById(R.id.dcard1);
        card1.setOnClickListener(this);
        return myView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dcard1:
                startActivity(new Intent(this.requireContext(), doctorAppoinment.class));
        }
    }
}