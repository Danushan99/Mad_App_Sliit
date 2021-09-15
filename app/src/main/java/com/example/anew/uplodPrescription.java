package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class uplodPrescription extends AppCompatActivity {
private Button orderbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplod_prescription);
        orderbtn=findViewById(R.id.ordernow);
        orderbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplodPrescription.this,bookSuccessful.class);
                startActivity(intent);

            }



        });
    }
}