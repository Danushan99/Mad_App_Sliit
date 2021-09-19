package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class myBagFragment extends Fragment implements View.OnClickListener{
    private CardView bagcard1,bagcard2,bagcard3;




    public myBagFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.fragment_my_bag,container,false);
        bagcard1=(CardView) myView.findViewById(R.id.bagcard1);
        bagcard2=(CardView) myView.findViewById(R.id.bagcard2);
        bagcard3=(CardView) myView.findViewById(R.id.bagcard3);
        bagcard1.setOnClickListener(this);
        bagcard2.setOnClickListener(this);
        bagcard3.setOnClickListener(this);

        return myView;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case
                R.id.bagcard1:
                startActivity(new Intent(this.requireContext(),doctorBookings.class));
                break;
            case
                 R.id.bagcard2:
             startActivity(new Intent(this.requireContext(),mediOrders.class));
             break;

            case R.id.bagcard3:
                startActivity(new Intent(this.requireContext(),scanBooked.class));
                break;

        }
    }
}