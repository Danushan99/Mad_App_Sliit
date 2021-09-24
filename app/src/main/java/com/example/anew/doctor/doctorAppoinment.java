package com.example.anew.doctor;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.anew.DatePikerFragment;
import com.example.anew.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class doctorAppoinment extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button sucsAppoinment;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appoinment);
        sucsAppoinment=findViewById(R.id.btnbookappinment);
        
        EditText name = (EditText) findViewById(R.id.textaddd);
        EditText address = (EditText) findViewById(R.id.bookname3);
        EditText phone = (EditText) findViewById(R.id.bookname4);
        EditText age = (EditText) findViewById(R.id.bookname);
        TextView date = (TextView) findViewById(R.id.textcalender);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");

        sucsAppoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySuc();
            }

            private void openActivitySuc() {//success page button navigation
                AppointmentModel appointment = new AppointmentModel(name.getText().toString(), address.getText().toString(),phone.getText().toString(),
                        age.getText().toString(),date.getText().toString());
                mDatabaseReference.child("Appointments").child("MkHoyezUmubrwwxAv4n").setValue(appointment).addOnSuccessListener(doctorAppoinment.this, new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Intent intent= new Intent(doctorAppoinment.this, bookSuccessful.class);
                        startActivity(intent);
                    }
                });

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