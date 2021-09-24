package com.example.anew.doctor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anew.R;

public class bookSuccessful extends AppCompatActivity {

    double balanceAmount, discountAmount, priceAmount = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_successful);

        discountAmount = priceAmount * 0.2;
        balanceAmount = priceAmount - discountAmount;

        TextView Amount = findViewById(R.id.textView21);
        Amount.setText("Price is : "+ priceAmount+"Rs");

        TextView discount = findViewById(R.id.textView22);
        discount.setText("Discount : "+ discountAmount+"Rs");

        TextView Balance  = findViewById(R.id.textView30);
        Balance.setText("Balance : "+ balanceAmount+"Rs");
    }
}