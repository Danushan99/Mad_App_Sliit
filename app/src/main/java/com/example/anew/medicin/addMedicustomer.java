package com.example.anew.medicin;

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
import com.example.anew.uplodPrescription;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addMedicustomer extends AppCompatActivity {
    private Button nextbtn;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicustomer);

        EditText name = (EditText) findViewById(R.id.cusname);
        EditText address = (EditText) findViewById(R.id.cusadd);
        EditText phone = (EditText) findViewById(R.id.custxt);
        EditText age = (EditText) findViewById(R.id.cusage);
        TextView quality = (TextView) findViewById(R.id.cusqu);

        FirebaseApp.initializeApp(this);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseInstance.getReference("medione");

        nextbtn=findViewById(R.id.nextbtn12);
        nextbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MedicineModel medicine = new MedicineModel(name.getText().toString(), address.getText().toString(),phone.getText().toString(),
                        age.getText().toString(),"Panadol",quality.getText().toString());
                mDatabaseReference.child("Medicine").child("MkI1k44O_feft_Wu3d2").setValue(medicine).addOnSuccessListener(addMedicustomer.this, new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void mVoid){
                        Intent intent=new Intent(addMedicustomer.this, uplodPrescription.class);
                        startActivity(intent);
                    }
                });


            }



        });
    }
}