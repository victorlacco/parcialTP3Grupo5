package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import ar.edu.ort.parcialtp3_g5.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    class SettingsFragment : PreferenceFragmentCompat() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.user_settings, rootKey)
            (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.settings)

        }

        override fun onStart() {
            super.onStart()
            (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.settings)
        }

    }
}
