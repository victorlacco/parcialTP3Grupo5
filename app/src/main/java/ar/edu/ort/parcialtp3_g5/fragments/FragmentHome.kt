package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.parcialtp3_g5.R
import ar.edu.ort.parcialtp3_g5.activities.UserSession
import ar.edu.ort.parcialtp3_g5.adapter.HomeCharacters

class FragmentHome : Fragment() {
    private lateinit var userEditText: String
    private lateinit var passwordEditText: String
    lateinit var userWelcome: TextView
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var activity: AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = (requireActivity() as AppCompatActivity)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.homeHeader)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = HomeCharacters()

        if (recyclerView != null) {
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager =layoutManager
            recyclerView.adapter = adapter
        }
        userWelcome = view.findViewById(R.id.welcomeText)
        userWelcome.text = getString(R.string.welcome, UserSession.userName)
    }
    override fun onStart() {
        super.onStart()

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        activity.supportActionBar?.title = getString(R.string.homeHeader)


        Log.d("Test",prefs.getBoolean("switchNightMode",false).toString())
        Log.d("Test",prefs.getBoolean("switchBuscador",false).toString())
        Log.d("Test",prefs.getBoolean("switchFavoritos",false).toString())
    }
}