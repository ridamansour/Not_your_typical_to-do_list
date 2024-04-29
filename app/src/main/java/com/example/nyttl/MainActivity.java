package com.example.nyttl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Authentication
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        // Initialize buttons
        AppCompatButton loginButton = findViewById(R.id.button);
        AppCompatButton signUpButton = findViewById(R.id.button2);

        if (currentUser != null) {
            // User is authenticated, go to the dashboard activity
            Intent dashboardIntent = new Intent (MainActivity.this, DashboardActivity.class);
            startActivity(dashboardIntent);
            finish();
        }
        loginButton.setOnClickListener(v -> {
            //  handle login button click
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        signUpButton.setOnClickListener(v -> {
            // handle sign up button click
            Intent signUpIntent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(signUpIntent);
        });
    }
}