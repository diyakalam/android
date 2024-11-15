package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Switch;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bCancel, bProceed;
    EditText etFirstName, etLastName, etEmail, etPassword;
    RadioGroup genderRadioGroup;
    CheckBox termsCheckBox;
    Switch notificationSwitch; // Add Switch reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bProceed = findViewById(R.id.proceedButton);
        bCancel = findViewById(R.id.cancelButton);
        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        notificationSwitch = findViewById(R.id.notificationSwitch); // Initialize Switch

        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAllFields()) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }

    private boolean checkAllFields() {
        // Validate First Name
        if (TextUtils.isEmpty(etFirstName.getText())) {
            etFirstName.setError("This field is required");
            return false;
        }

        // Validate Last Name
        if (TextUtils.isEmpty(etLastName.getText())) {
            etLastName.setError("This field is required");
            return false;
        }

        // Validate Email
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email format");
            return false;
        }

        // Validate Password
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            return false;
        } else if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters");
            return false;
        }


        // Validate Gender RadioGroup
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate Terms CheckBox
        if (!termsCheckBox.isChecked()) {
            Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Handle Switch State (optional logic can be added based on the switch state)
        boolean notificationsEnabled = notificationSwitch.isChecked();
        // You can use this state for additional logic if needed

        return true;
    }
}
