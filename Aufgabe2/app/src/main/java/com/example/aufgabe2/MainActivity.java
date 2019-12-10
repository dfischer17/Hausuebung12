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
        EditText inputView = findViewById(R.id.input);
        TextView resultView = findViewById(resultTextView);

        // Einzelne Zeichen der Eingabe
        char[] inputCharacters = inputView.toString().trim().toCharArray();

        int result = inputCharacters[0];

        // Zeichen durchlaufen und result erhöhen/erniedrigen
        for (int i = 1; i < inputCharacters.length; i++) {
            if (inputCharacters[i] == '+') {
                result += inputCharacters[i + 1];
                i++;
            }
            else {
                result += inputCharacters[i + 1];
                i--;
            }
        }

        resultView.setText(result);
    }
}
