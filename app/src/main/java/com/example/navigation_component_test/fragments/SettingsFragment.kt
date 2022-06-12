package com.example.navigation_component_test.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.navigation_component_test.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}