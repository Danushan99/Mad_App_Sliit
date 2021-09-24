package com.example.anew.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {

    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
    EditText name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("Users");
        mDatabaseReference.child("mvnSUBWLxUcvcG78rDzkbHwoea72").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                name = findViewById(R.id.textView9);
                name.setText(userModel.getName());

                email = findViewById(R.id.textView11);
                email.setText(userModel.getEmail());

                phone = findViewById(R.id.textView13);
                phone.setText(userModel.getPhoneNo());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                // TODO: Implement this method
                Toast.makeText(EditProfile.this, databaseError.getDetails()+" "+databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

        Button editProfile = findViewById(R.id.button6);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = new UserModel(name.getText().toString(), email.getText().toString(), phone.getText().toString(),"");
                FirebaseDatabase.getInstance().getReference("Users")
                        .child("mvnSUBWLxUcvcG78rDzkbHwoea72")
                        .setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(EditProfile.this,"Edited sucessfuly",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(EditProfile.this,"Register unsucessfuly",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}