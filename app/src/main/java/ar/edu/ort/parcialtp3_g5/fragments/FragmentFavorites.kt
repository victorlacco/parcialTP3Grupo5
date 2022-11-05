package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.parcialtp3_g5.R
import ar.edu.ort.parcialtp3_g5.activities.UserSession

class FragmentFavorites : Fragment() {

    //private lateinit var productsRecyclerView: RecyclerView
    //private lateinit var productList: List<Product>
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //productsRecyclerView = view.findViewById(R.id.product_recyclerview)
        title = view.findViewById(R.id.id_textFavorites)

        // Pongo el nombre del usuario en el titulo.
        title.text = "Hola, ${UserSession.userName}, estos son tus personajes favoritos "



    }

}