package com.example.converttemperature.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.converttemperature.R;
import com.example.converttemperature.dao.HistoryDAO;
import com.example.converttemperature.model.History;

import java.text.DecimalFormat;

public class FormCelsiusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Celsius para Fahrenheit");
        setContentView(R.layout.activity_form_celsius);

        final HistoryDAO dao = new HistoryDAO();

        final EditText textFieldCelsius = findViewById(R.id.activity_celsius_to_fahrenheit_text);
        final TextView showConvertion = findViewById(R.id.show_celsius_to_fahrenheit_convertion);
        Button submitButton = findViewById(R.id.activity_convert_celsius_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = textFieldCelsius.getText().toString();
                if (inputValue.isEmpty() || inputValue.contentEquals(".")) {
                    showConvertion.setText("Informe um valor real.");
                } else {
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    String result = decimalFormat.format((Double.parseDouble(inputValue) * 1.8) + 32);

                    History newHistory = new History(
                            result,
                            inputValue,
                            "(" + inputValue + " ºC * 1.8) + 32",
                            "celsius"
                    );
                    dao.save(newHistory);

                    showConvertion.setText(
                            newHistory.getInputValue()
                                    + " Graus Celsius\n\nsão\n\n"
                                    + newHistory.getResult()
                                    + " Graus Fahrenheit"
                                    + "\n\nFormula utilizada:\n"
                                    + newHistory.getCondition()
                    );
                }
            }
        });
    }
}