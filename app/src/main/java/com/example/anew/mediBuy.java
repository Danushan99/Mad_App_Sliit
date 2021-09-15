package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mediBuy extends AppCompatActivity {
    private Button nextpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_buy);
        nextpage=findViewById(R.id.buynow);
        nextpage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mediBuy.this,addMedicustomer.class);
                startActivity(intent);

            }



        });
    }
}