package com.example.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.aufgabe2.R.id.resultTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Elemente
        TextView inputView = findViewById(R.id.input);
        TextView resultView = findViewById(resultTextView);

        // Rechner mit rekursiven Abstieg
        Calculator calculator = new Calculator();

        // Nutzereingabe
        String input = inputView.getText().toString().trim();

        // Berechnung des Ergebnisses
        double result = calculator.parse(input);

        resultView.setText(String.valueOf(result));
    }
}
