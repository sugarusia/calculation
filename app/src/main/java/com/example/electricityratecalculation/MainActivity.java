package com.example.electricityratecalculation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int selectedValue;
    private int selectedQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // installSplashScreen()を追加
        installSplashScreen();
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Spinner quantitySpinner = findViewById(R.id.quantity_spinner);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.text_view);

        String[] items = {"Option 1", "Option 2", "Option 3"};
        final int[] values = {10, 20, 30};
        Integer[] quantities = {1, 2, 3, 4, 5};

        SpinnerHelper.setupSpinner(this, spinner, items);
        SpinnerHelper.setupSpinner(this, quantitySpinner, quantities);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedValue = values[position];
                updateTextView(textView, items[position], selectedValue, selectedQuantity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("Nothing selected");
            }
        });

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedQuantity = quantities[position];
                updateTextView(textView, items[spinner.getSelectedItemPosition()], selectedValue, selectedQuantity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("Nothing selected");
            }
        });

        button.setOnClickListener(v -> {
            int calculatedValue = selectedValue * selectedQuantity;
            saveSelectedValue(calculatedValue);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    private void installSplashScreen() {
    }

    private void updateTextView(TextView textView, String item, int value, int quantity) {
        textView.setText("Selected: " + item + " (Value: " + value + ", Quantity: " + quantity + ")");
    }

    private void saveSelectedValue(int value) {
        SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("selected_value1", value);
        editor.apply();
    }
}
