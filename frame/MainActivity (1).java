package com.example.framelayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView1.setVisibility(ImageView.GONE);
                imageView2.setVisibility(ImageView.VISIBLE);
            } else {
                imageView1.setVisibility(ImageView.VISIBLE);
                imageView2.setVisibility(ImageView.GONE);
            }
        });
    }
}