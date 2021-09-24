package com.example.anew.scan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.doctor.AppointmentModel;
import com.example.anew.doctor.bookSuccessful;
import com.example.anew.doctor.doctorAppoinment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScanBooking extends AppCompatActivity {
    private Button Reservesucess,res;// reserve now to success
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_booking);
        Reservesucess=findViewById(R.id.btnbookscan);
        res=findViewById(R.id.cancelButton);

        EditText name = (EditText) findViewById(R.id.textaddd);
        EditText address = (EditText) findViewById(R.id.bookname3);
        EditText phone = (EditText) findViewById(R.id.bookname4);
        EditText age = (EditText) findViewById(R.id.bookname);
        TextView date = (TextView) findViewById(R.id.textcalender);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");

        Reservesucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySuc();
            }

            private void openActivitySuc() {//success page button navigation
                ScanModel scan = new ScanModel("X-ray" ,name.getText().toString(), address.getText().toString(),phone.getText().toString(),
                        age.getText().toString(),"13/03/2021");
                mDatabaseReference.child("Scans").child("MkHtB_sS7UDK6cIEkmT").setValue(scan).addOnSuccessListener(ScanBooking.this, new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Intent intent= new Intent(ScanBooking.this, bookSuccessful.class);
                        startActivity(intent);
                    }
                });

            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteActivity();
            }

            private void deleteActivity() {//success page button navigation
                Intent intent= new Intent(ScanBooking.this, ScanFragment.class);
                startActivity(intent);
                finish();
            }
        });





    }

}