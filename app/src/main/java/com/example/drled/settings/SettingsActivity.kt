package com.example.drled.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.drled.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title = getString(R.string.settings_label)

        //  display the fragment as settings_view
        supportFragmentManager.beginTransaction()
                .replace(R.id.settings_view, SettingsFragment())
                .commit()
    }

}
