package com.example.anew.scan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.medicin.MedicineModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditScanbooking extends AppCompatActivity {
    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
    EditText name, doctor, date,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_scanbooking);
//firebase initilizing
        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");
        mDatabaseReference.child("Scans").child("MkHtB_sS7UDK6cIEkmT")
                .addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                ScanModel scanModel = dataSnapshot.getValue(ScanModel.class);

                name = findViewById(R.id.docNameEdit);
                doctor = findViewById(R.id.docNameEdit2);
                date = findViewById(R.id.docAuthEdit);
                time = findViewById(R.id.docAuthEdit3);

                assert scanModel != null;
                name.setText(scanModel.getPatientName());
                doctor.setText(scanModel.getDoctorName());
                date.setText(scanModel.getBookingDate());
                time.setText(scanModel.getTime());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                // TODO: Implement this method
                Toast.makeText(EditScanbooking.this,
                        databaseError.getDetails()+" "+databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
          //cLIck
        //edit button
        Button editDetails = findViewById(R.id.btnSubmit);
        editDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MedicineModel medicineModel = new MedicineModel();
                medicineModel.setPatientName(name.getText().toString());
                medicineModel.setPatientAddress(doctor.getText().toString());
                medicineModel.setQuantity(date.getText().toString());
                medicineModel.setQuantity(time.getText().toString());
                FirebaseDatabase.getInstance().getReference("medione").child("Scans")
                        .child("MkHtB_sS7UDK6cIEkmT").setValue(medicineModel);
            }
        });
         //delete Button
        Button delete = findViewById(R.id.btnRemove);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("Scans").child("MkHtB_sS7UDK6cIEkmT")
                        .removeValue().addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Toast.makeText(EditScanbooking.this,"Deleted sucessfuly",
                                Toast.LENGTH_SHORT).show();

                        finish();
                    }
                });
            }
        });
    }
}