package ar.edu.ort.parcialtp3_g5.fragments

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import ar.edu.ort.parcialtp3_g5.R


class FragmentLogin : Fragment() {

    private lateinit var vista: View
    private lateinit var txtInputUser: EditText
    private lateinit var txtInputPassword: EditText
    private lateinit var btnGoToHome: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isNightModeEnabled = prefs.getBoolean("switchNightMode",false)
        if(isNightModeEnabled) {
             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_login, container, false)

        txtInputUser = vista.findViewById(R.id.id_txtInputUser)
        txtInputPassword = vista.findViewById(R.id.id_txtInputPassword)
        btnGoToHome = vista.findViewById(R.id.id_buttonGoToHome)

        return vista
    }

    override fun onStart() {
        super.onStart()

        btnGoToHome.setOnClickListener {
            val navController = findNavController()
            navController.navigate(
                FragmentLoginDirections.actionFragmentLoginToFragmentHome(txtInputUser.text.toString())
            )
            hideKeyboard()
        }
    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }
    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    private fun hideKeyboard(){
        val imm: InputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val viewRoot = vista.findViewById<ConstraintLayout>(R.id.id_btn_login)
        imm.hideSoftInputFromWindow(viewRoot.windowToken, 0)
    }
}