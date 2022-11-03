package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentOnAttachListener
import androidx.navigation.findNavController
import ar.edu.ort.parcialtp3_g5.R

class FragmentLogin : Fragment() {

    lateinit var vista: View
    lateinit var btnGoToHome: Button
    lateinit var txtInputUser: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_login, container, false)

        btnGoToHome = vista.findViewById(R.id.id_buttonGoToHome)

        txtInputUser = vista.findViewById(R.id.id_txtInputUser)

        return vista
    }

    override fun onStart() {
        super.onStart()

        activity?.title = "Login"

        btnGoToHome.setOnClickListener {

        val action = FragmentLoginDirections.actionFragmentLoginToFragmentHome()

        vista.findNavController().navigate(action)

        }

    }

}