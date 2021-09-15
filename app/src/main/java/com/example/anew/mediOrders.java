package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mediOrders extends AppCompatActivity {
private Button editord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_orders);
        editord=findViewById(R.id.ordedi1);
        editord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }

            private void openActivity3() {//success page button navigation
                Intent intent= new Intent(mediOrders.this,EditMediOrders.class);
                startActivity(intent);

            }
        });
    }
}