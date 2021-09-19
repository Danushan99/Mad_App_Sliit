package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class scanBooked extends AppCompatActivity {
    private Button editbook1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_booked);
        editbook1=findViewById(R.id.scanedit);
        editbook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View i) {
                openActivity1();
            }

            private void openActivity1() {//success page button navigation
                Intent intent= new Intent(scanBooked.this,EditScanbooking.class);
                startActivity(intent);

            }
        });}}