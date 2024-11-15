package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigateButton = findViewById(R.id.navigate_button);

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Archana";  // Hardcoded name
                String age = "22";          // Hardcoded age
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);
                startActivity(intent);
            }
        });
    }
}
