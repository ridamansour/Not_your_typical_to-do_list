package com.example.nyttl;

import android.app.Activity;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class PasswordResetHelper {
    private final FirebaseAuth mAuth;

    public PasswordResetHelper() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void resetPassword(String email, final Activity activity) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(activity, "Password reset email sent. Please check your email.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(activity, "Failed to send password reset email. Please check the email address.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void resetPassword(String email, final Fragment fragment) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(fragment.requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(fragment.requireContext(), "Password reset email sent. Please check your email.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(fragment.requireContext(), "Failed to send password reset email. Please check the email address.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
