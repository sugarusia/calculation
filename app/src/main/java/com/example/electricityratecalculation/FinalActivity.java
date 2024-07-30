package com.example.electricityratecalculation;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView totalTextView = findViewById(R.id.total_text_view);

        int selectedValue1 = getSelectedValue("selected_value1");
        int selectedValue2 = getSelectedValue("selected_value2");

        int total = selectedValue1 + selectedValue2;

        totalTextView.setText(String.valueOf(total));
    }

    private int getSelectedValue(String key) {
        SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }
}
