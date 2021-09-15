package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ScanBooking extends AppCompatActivity {
    private Button Reservesucess,res;// reserve now to success




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_booking);
        Reservesucess=findViewById(R.id.btnbookscan);
        res=findViewById(R.id.cancelButton);


        Reservesucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySuc();
            }

            private void openActivitySuc() {//success page button navigation
                Intent intent= new Intent(ScanBooking.this,bookSuccessful.class);
                startActivity(intent);

            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteActivity();
            }

            private void deleteActivity() {//success page button navigation
                Intent intent= new Intent(ScanBooking.this,ScanFragment.class);
                startActivity(intent);
                finish();
            }
        });





    }

}