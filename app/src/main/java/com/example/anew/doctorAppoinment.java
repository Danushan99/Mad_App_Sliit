package com.example.anew;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class doctorAppoinment extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button sucsAppoinment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appoinment);
        sucsAppoinment=findViewById(R.id.btnbookappinment);
        sucsAppoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySuc();
            }

            private void openActivitySuc() {//success page button navigation
                Intent intent= new Intent(doctorAppoinment.this,bookSuccessful.class);
                startActivity(intent);
            }
        });


        Button button=(Button) findViewById(R.id.buttoncalender);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePiker= new DatePikerFragment();
                datePiker.show(getSupportFragmentManager(),"date Picker");
            }
        });


    };


        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String CurrentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView =(TextView)findViewById(R.id.textcalender);
        textView.setText(CurrentDateString);
        
    }


}