package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
}