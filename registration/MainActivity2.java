package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        Button btnShowDetails = findViewById(R.id.btnShowDetails);
        btnShowDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "No Username");
                String email = sharedPreferences.getString("email", "No email");
                textView.setText("Username: " + username + "Email: " + email);
            }
        });

    }
}