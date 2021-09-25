package com.example.anew.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.SplashScreen;
import com.example.anew.user.DeleteAccount;
import com.example.anew.user.EditProfile;
import com.example.anew.user.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Editdoctorbook extends AppCompatActivity {

    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
    EditText name, doctorName, date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdoctorbook);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");
        mDatabaseReference.child("Appointments").child("MkHoyezUmubrwwxAv4n")
                .addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                AppointmentModel appointmentModel = dataSnapshot.getValue(AppointmentModel.class);

                name = findViewById(R.id.docNameEdit);
                doctorName = findViewById(R.id.docNameEdit2);
                date = findViewById(R.id.docAuthEdit);
                time = findViewById(R.id.docAuthEdit3);

                assert appointmentModel != null;
                name.setText(appointmentModel.getPatientName());
                doctorName.setText(appointmentModel.getDoctorName());
                date.setText(appointmentModel.getBookingDate());
                time.setText(appointmentModel.getTime());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                // TODO: Implement this method
                Toast.makeText(Editdoctorbook.this,
                        databaseError.getDetails()+" "+databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Button editDetails = findViewById(R.id.btnSubmit);
        editDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppointmentModel appointment = new AppointmentModel();
                appointment.setPatientName(name.getText().toString());
                appointment.setDoctorName(doctorName.getText().toString());
                appointment.setBookingDate(date.getText().toString());
                appointment.setTime(time.getText().toString());
                FirebaseDatabase.getInstance().getReference("medione").child("Appointments")
                        .child("MkHoyezUmubrwwxAv4n").setValue(appointment);
            }
        });

        Button delete = findViewById(R.id.btnRemove);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("Appointments").child("MkHoyezUmubrwwxAv4n").removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Toast.makeText(Editdoctorbook.this,
                                "Deleted sucessfuly",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}