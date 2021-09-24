package com.example.anew.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.User;
import com.example.anew.doctor.bookSuccessful;
import com.example.anew.doctor.doctorAppoinment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    Button registerbtn;
    EditText EditTextname,EditTextemail,EditTextphonenum,EditTextpassword,EditTextrepassword;
    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;

    private FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).hide();
       //firebase

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");

        auth = FirebaseAuth.getInstance();
        registerbtn = findViewById(R.id.RegButton);
        registerbtn.setOnClickListener(this);
        EditTextname= (EditText) findViewById(R.id.name);
        EditTextemail=(EditText)findViewById(R.id.emailid);
        EditTextphonenum=(EditText)findViewById(R.id.phoneNum);
        EditTextpassword =(EditText)findViewById(R.id.passwordReg);
        EditTextrepassword =(EditText)findViewById(R.id.re_password);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.RegButton:
                registerCustomer();
                break;
        }

    }

    public void registerCustomer() {
        String name =EditTextname.getText().toString().trim();
        String email =EditTextemail.getText().toString().trim();
        String phone =EditTextphonenum.getText().toString().trim();
        String password =EditTextpassword.getText().toString().trim();
        String repassword =EditTextrepassword.getText().toString().trim();

        if (name.isEmpty()) {
            EditTextname.setError("User name is required");
            EditTextname.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            EditTextemail.setError("email is required");
            EditTextemail.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            EditTextphonenum.setError("phone is required");
            EditTextphonenum.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            EditTextpassword.setError("password required");
            EditTextpassword.requestFocus();
            return;
        }

        if (repassword.isEmpty()) {
            EditTextrepassword.setError("retype password");
            EditTextrepassword.requestFocus();
            return;
        }



        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){


                    UserModel userModel = new UserModel(name, email, phone, password);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child("mvnSUBWLxUcvcG78rDzkbHwoea72")
                            .setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignupActivity.this,"Register sucessfuly",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else{
                                Toast.makeText(SignupActivity.this,"Register unsucessfuly",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }
            }
        }
        );
    }


}