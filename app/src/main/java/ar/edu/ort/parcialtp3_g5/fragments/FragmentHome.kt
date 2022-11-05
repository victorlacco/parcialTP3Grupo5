package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import ar.edu.ort.parcialtp3_g5.R

class FragmentHome : Fragment() {
    private lateinit var userEditText: String
    private lateinit var passwordEditText: String
    lateinit var userWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userWelcome = view.findViewById(R.id.welcomeText)
        userWelcome.text = getString(R.string.welcome, "[insertar-nombre]")
    }
    override fun onStart() {
        super.onStart()

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())


        Log.d("Test",prefs.getBoolean("switchNightMode",false).toString())
        Log.d("Test",prefs.getBoolean("switchBuscador",false).toString())
        Log.d("Test",prefs.getBoolean("switchFavoritos",false).toString())
    }
}