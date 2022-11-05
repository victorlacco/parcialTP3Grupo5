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
import androidx.navigation.fragment.findNavController
import ar.edu.ort.parcialtp3_g5.R

class FragmentLogin : Fragment() {

    private lateinit var vista: View
    private lateinit var txtInputUser: EditText
    private lateinit var txtInputPassword: EditText
    private lateinit var btnGoToHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_login, container, false)

        return vista
    }

    override fun onStart() {
        super.onStart()

        val navController = findNavController()

        btnGoToHome = vista.findViewById(R.id.id_buttonGoToHome)

        txtInputUser = vista.findViewById(R.id.id_txtInputUser)

        txtInputPassword = vista.findViewById(R.id.id_txtInputPassword)

        btnGoToHome.setOnClickListener {

            navController.navigate(
                FragmentLoginDirections.actionFragmentLoginToFragmentHome(txtInputUser.toString())
            )

        }

    }

}