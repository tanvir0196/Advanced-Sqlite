package com.bongoacademy.digitalmoneybag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddData extends AppCompatActivity {

    TextView tvTitle;

    EditText edAmount,edReason;
    Button button;
    DatabaseHelper dbHelper;

    public static boolean EXPENSE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        tvTitle = findViewById(R.id.tvTitle);
        button = findViewById(R.id.button);
        edAmount = findViewById(R.id.edAmount);
        edReason = findViewById(R.id.edReason);
        dbHelper = new DatabaseHelper(this);

        if(EXPENSE == true) tvTitle.setText("Add Expense");



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAmount = edAmount.getText().toString();
                String reason = edReason.getText().toString();

                if (!sAmount.isEmpty()) {
                    double amount = Double.parseDouble(sAmount);

                    if (EXPENSE) {
                        dbHelper.addExpense(amount, reason);
                    } else {
                        dbHelper.addIncome(amount, reason);
                    }

                    finish(); // Close activity to refresh MainActivity UI
                }
            }
        });


    }
    //========================================================

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    //========================================================================
}