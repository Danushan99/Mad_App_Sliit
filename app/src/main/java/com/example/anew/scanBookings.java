package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class scanBookings extends AppCompatActivity {
    private Button editbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_bookings);
        editbook=findViewById(R.id.editbtn14);
        editbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }

            private void openActivity1() {//success page button navigation
                Intent intent= new Intent(scanBookings.this,EditScanbooking.class);
                startActivity(intent);

            }
        });
    }
}