package com.example.anew.medicin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;
import com.example.anew.doctor.AppointmentModel;
import com.example.anew.doctor.Editdoctorbook;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditMediOrders extends AppCompatActivity {

    DatabaseReference mDatabaseReference;
    FirebaseDatabase mFirebaseInstance;
    EditText name, address, quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medi_orders);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");
        mDatabaseReference.child("Medicine").child("MkI1k44O_feft_Wu3d2")
                .addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                MedicineModel appointmentModel = dataSnapshot.getValue(MedicineModel.class);

                name = findViewById(R.id.docNameEdit2);
                address = findViewById(R.id.docAuthEdit);
                quantity = findViewById(R.id.ss5);

                assert appointmentModel != null;
                name.setText(appointmentModel.getPatientName());
                address.setText(appointmentModel.getPatientAddress());
                quantity.setText(appointmentModel.getQuantity());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                // TODO: Implement this method
                Toast.makeText(EditMediOrders.this,
                        databaseError.getDetails()+" "+databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

        Button editDetails = findViewById(R.id.btnSubmit);
        editDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MedicineModel medicineModel = new MedicineModel();
                medicineModel.setPatientName(name.getText().toString());
                medicineModel.setPatientAddress(address.getText().toString());
                medicineModel.setQuantity(quantity.getText().toString());
                FirebaseDatabase.getInstance().getReference("medione").child("Medicine")
                        .child("MkI1k44O_feft_Wu3d2").setValue(medicineModel);
            }
        });

        Button delete = findViewById(R.id.btnRemove);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("Medicine").child("MkI1k44O_feft_Wu3d2")
                        .removeValue().addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Toast.makeText(EditMediOrders.this,"Deleted sucessfuly"
                                ,Toast.LENGTH_SHORT).show();

                        finish();
                    }
                        });
            }
        });
    }
}