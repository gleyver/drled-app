package com.example.drled.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.drled.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(p0: Bundle?, p1: String?) {

        //  Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences)
    }

}
