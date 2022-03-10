package com.example.converttemperature.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.converttemperature.R;
import com.example.converttemperature.dao.HistoryDAO;
import com.example.converttemperature.model.History;

import java.text.DecimalFormat;

public class FormFahrenheitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Fahrenheit para Celsius");
        setContentView(R.layout.activity_form_fahrenheit);

        final HistoryDAO dao = new HistoryDAO();

        final EditText textFieldFahrenheit = findViewById(R.id.activity_fahrenheit_to_celsius_text);
        final TextView showConvertion = findViewById(R.id.show_fahrenheit_to_celsius_convertion);
        Button submitButton = findViewById(R.id.activity_convert_fahrenheit_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = textFieldFahrenheit.getText().toString();
                if (inputValue.isEmpty() || inputValue.contentEquals(".")) {
                    showConvertion.setText("Informe um valor real.");
                } else {
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    String result = decimalFormat.format((Double.parseDouble(inputValue) - 32) / 1.8);

                    History newHistory = new History(
                            result,
                            inputValue,
                            "(" + inputValue + " ºF - 32) / 1.8",
                            "fahrenheit"
                    );
                    dao.save(newHistory);

                    showConvertion.setText(
                            newHistory.getInputValue()
                                    + " Graus Fahrenheit\n\nsão\n\n"
                                    + newHistory.getResult()
                                    + " Graus Celsius"
                                    + "\n\nFormula utilizada:\n"
                                    + newHistory.getCondition()
                    );
                }
            }
        });
    }
}
