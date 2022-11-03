package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ar.edu.ort.parcialtp3_g5.R

class FragmentLogin : Fragment() {

    lateinit var vista: View
    lateinit var btnGoToHome: Button
    private lateinit var userEmailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        btnGoToHome = vista.findViewById(R.id.id_buttonGoToHome)

        //txtInputUser = vista.findViewById(R.id.usrEmail)

        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val continueButton = view.findViewById<Button>(R.id.id_buttonGoToHome)
        userEmailEditText = view.findViewById(R.id.usrEmail)
        passwordEditText = view.findViewById(R.id.usrPassword)

        // Button listener
        continueButton.setOnClickListener {

            // Navigation to home screen
            navController.navigate(
                FragmentLoginDirections.loginToHome(
                    userEmailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            )
        }
    }

    override fun onStart() {
        super.onStart()
        activity?.title = "Login"
        btnGoToHome.setOnClickListener {
        val action = FragmentLoginDirections.loginToHome(userEmailEditText.text.toString(),
            passwordEditText.text.toString())
        vista.findNavController().navigate(action)

        }

    }

}