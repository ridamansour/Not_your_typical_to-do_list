package com.example.nyttl;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        LinearLayout accountButton = rootView.findViewById(R.id.accountButton);
        LinearLayout privacyButton = rootView.findViewById(R.id.privacyButton);
        LinearLayout helpButton = rootView.findViewById(R.id.helpButton);
        LinearLayout aboutButton = rootView.findViewById(R.id.aboutButton);

        SwitchCompat darkModeSwitch = rootView.findViewById(R.id.switch1);
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Set the phone to dark mode
                int nightModeFlags = rootView.getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (nightModeFlags != Configuration.UI_MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                     // Optional: Restart the activity for changes to take effect immediately
                }
            } else {
                // Set the phone to light mode
                int nightModeFlags = rootView.getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (nightModeFlags != Configuration.UI_MODE_NIGHT_NO) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    // Optional: Restart the activity for changes to take effect immediately
                }
            }
        });

        accountButton.setOnClickListener(v -> {
            AccountFragment fragment = new AccountFragment();
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        privacyButton.setOnClickListener(v -> {
            PrivacyFragment fragment = new PrivacyFragment();
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        helpButton.setOnClickListener(v -> {
            HelpFragment fragment = new HelpFragment();
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        aboutButton.setOnClickListener(v -> {
            AboutFragment fragment = new AboutFragment();
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return rootView;
    }
}

