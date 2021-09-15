package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainScreen extends AppCompatActivity {
private Button buttonLogin;
private Button buttonSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        buttonLogin=findViewById(R.id.buttonLogin);{
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainScreen.this,LoginActivity.class);
                    startActivity(intent);
                }
            });

            buttonSignup=findViewById(R.id.buttonSignup);{
                buttonSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainScreen.this,SignupActivity.class);
                        startActivity(intent);
                    }
                });

    }
    }
}
}