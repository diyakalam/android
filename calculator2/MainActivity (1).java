package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class MainActivity extends AppCompatActivity {

    private EditText display;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        setupButtons();
    }

    private void setupButtons() {
        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.buttonDot, R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply,
                R.id.buttonDivide, R.id.buttonEquals, R.id.buttonC
        };
        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> onButtonClick(button));
        }
    }

    private void onButtonClick(Button button) {
        String text = button.getText().toString();
        switch (text) {
            case "C":
                input.setLength(0);
                break;
            case "=":
                calculate();
                break;
            default:
                input.append(text);
                break;
        }
        display.setText(input.toString());
    }

    private void calculate() {
        try {
            Expression expression = new ExpressionBuilder(input.toString()).build();
            double result = expression.evaluate();
            input.setLength(0);
            input.append(result);
        } catch (Exception e) {
            input.setLength(0);
            input.append("error");
        }
    }
}

