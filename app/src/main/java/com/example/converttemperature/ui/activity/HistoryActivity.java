package com.example.converttemperature.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.converttemperature.R;
import com.example.converttemperature.dao.HistoryDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Histórico de conversão");
        setContentView(R.layout.activity_history);

        HistoryDAO dao = new HistoryDAO();

        ListView historyList = findViewById(R.id.historyList);
        historyList.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        dao.getList()
                )
        );

        FloatingActionButton celsiusConvertButton = findViewById(R.id.history_new_convert_celsius_fab);
        FloatingActionButton fahrenheitConvertButton = findViewById(R.id.history_new_convert_fahrenheit_fab);
        celsiusConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HistoryActivity.this, FormCelsiusActivity.class));
            }
        });
        fahrenheitConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HistoryActivity.this, FormFahrenheitActivity.class));
            }
        });
    }
}
