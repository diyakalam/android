package com.example.navigation;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView nameTextView = findViewById(R.id.name_text_view);
        TextView ageTextView = findViewById(R.id.age_text_view);

        // Get the name and age passed from MainActivity
        String name = getIntent().getStringExtra("NAME");
        String age = getIntent().getStringExtra("AGE");

        nameTextView.setText("Name: " + name);
        ageTextView.setText("Age: " + age);
    }
}