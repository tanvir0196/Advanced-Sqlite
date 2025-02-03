package com.bongoacademy.digitalmoneybag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvFinalBalance,tvTotalExpense, tvAddExpense,tvShowAllDataExpense,tvAddIncome,tvTotalIncome,tvShowAllDataIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFinalBalance = findViewById(R.id.tvFinalBalance);
        tvTotalExpense = findViewById(R.id.tvTotalExpense);
        tvAddExpense = findViewById(R.id.tvAddExpense);
        tvShowAllDataExpense = findViewById(R.id.tvShowAllDataExpense);
        tvAddIncome = findViewById(R.id.tvAddIncome);
        tvTotalIncome = findViewById(R.id.tvTotalIncome);
        tvShowAllDataIncome =findViewById(R.id.tvShowAllDataIncome);

        tvAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddData.class));

            }
        });




    }


    //===================================================================
}