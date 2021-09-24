package com.example.anew.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;

public class doctorBookings extends AppCompatActivity {
 private Button edititemsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_bookings);
        edititemsBtn = (Button) findViewById(R.id.edititemsBtn1);
        edititemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, Editdoctorbook.class);
        startActivity(intent);
    }
}
