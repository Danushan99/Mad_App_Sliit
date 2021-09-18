package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteAccount extends AppCompatActivity {
    private Button DleCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);
        DleCancel=findViewById(R.id.DleCancel);
        DleCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DeleteAccount.this,profileFragment.class);
                startActivity(intent);
                finish();

            }



        });
    }

}