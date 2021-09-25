package com.example.anew.medicin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.anew.user.DeleteAccount;
import com.example.anew.R;
import com.example.anew.user.EditProfile;
import com.example.anew.user.UserModel;
import com.example.anew.user.passwordReset;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profileFragment extends Fragment implements View.OnClickListener {

    private Button editbtn,deactivBtn,changpaswd;
    TextView name, email, phone;
    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
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

        FirebaseApp.initializeApp(getContext());
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("Users");
        mDatabaseReference.child("mvnSUBWLxUcvcG78rDzkbHwoea72").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                name = myView.findViewById(R.id.textView9);
                name.setText(userModel.getName());

                email = myView.findViewById(R.id.textView11);
                email.setText(userModel.getEmail());

                phone = myView.findViewById(R.id.textView20);
                phone.setText(userModel.getPhoneNo());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // TODO: Implement this method
                Toast.makeText(getContext(), databaseError.getDetails() + " " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return myView;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnedit1:
                startActivity(new Intent(this.requireContext(), EditProfile.class));
                break;
            case R.id.deactivBtn:
                startActivity(new Intent(this.requireContext(), DeleteAccount.class));
                break;
            case R.id.changpaswd:
                startActivity(new Intent(this.requireContext(), passwordReset.class));
                break;
        }
    }

}