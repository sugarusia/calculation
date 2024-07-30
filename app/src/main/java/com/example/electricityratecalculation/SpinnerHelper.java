package com.example.electricityratecalculation;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerHelper {

    // 汎用的なスピナーの設定メソッド
    public static <T> void setupSpinner(Context context, Spinner spinner, T[] items) {
        ArrayAdapter<T> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
