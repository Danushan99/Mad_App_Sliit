package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class profileFragment extends Fragment implements View.OnClickListener {

    private Button editbtn,deactivBtn,changpaswd;
    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_profile,container,false);
        // for edit profile user fragment
        editbtn=(Button) myView.findViewById(R.id.btnedit1);
        editbtn.setOnClickListener(this);
        //for delete profile user fragment
        deactivBtn=(Button) myView.findViewById(R.id.deactivBtn);
        deactivBtn.setOnClickListener(this);
        //for deActive account from user fragment
        changpaswd=(Button) myView.findViewById(R.id.changpaswd);
        changpaswd.setOnClickListener(this);
        return myView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnedit1:
                startActivity(new Intent(this.requireContext(),EditProfile.class));
                break;
            case R.id.deactivBtn:
                startActivity(new Intent(this.requireContext(),DeleteAccount.class));
                break;
            case R.id.changpaswd:
                startActivity(new Intent(this.requireContext(),passwordReset.class));
                break;
        }
    }
}