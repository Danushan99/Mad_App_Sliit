package com.example.anew.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.DashbordActivity;
import com.example.anew.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
private Button buttonLogin;
private TextView newAcco2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        buttonLogin = (Button) findViewById(R.id.Login);

        buttonLogin.setOnClickListener(this);
        newAcco2 = (TextView) findViewById(R.id.newAcco2);
        newAcco2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Login:
                startActivity(new Intent(LoginActivity.this, DashbordActivity.class));
                break;
            case R.id.newAcco2:
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                break;
        }

    }
}
