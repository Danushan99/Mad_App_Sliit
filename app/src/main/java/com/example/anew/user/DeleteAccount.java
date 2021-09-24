package com.example.anew.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.SplashScreen;
import com.example.anew.medicin.profileFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteAccount extends AppCompatActivity {
    private Button DleCancel, delete;
    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("Users");

        delete=findViewById(R.id.button6);
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                mDatabaseReference.child("mvnSUBWLxUcvcG78rDzkbHwoea72").removeValue().addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Intent login = new Intent(DeleteAccount.this, SplashScreen.class);
                        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(login);
                    }
                });

            }
        });

        DleCancel = findViewById(R.id.DleCancel);
        DleCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}