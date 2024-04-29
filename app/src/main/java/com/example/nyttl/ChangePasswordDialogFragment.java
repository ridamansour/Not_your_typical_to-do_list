package com.example.nyttl;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class ChangePasswordDialogFragment extends DialogFragment {
    private PasswordResetHelper passwordResetHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passwordResetHelper = new PasswordResetHelper();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Change Password")
                .setMessage("Do you want to change your password?")
                .setPositiveButton("Yes", (dialog, id) -> {
                    // Get the current user's email
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String userEmail = Objects.requireNonNull(user).getEmail();

                    if (userEmail != null) {
                        // Call the password reset method with the user's email
                        passwordResetHelper.resetPassword(userEmail, requireActivity());
                    }
                })
                .setNegativeButton("No", (dialog, id) -> {
                    // Close the dialog when the user selects "No"
                    dialog.dismiss();
                });
        return builder.create();
    }
}
