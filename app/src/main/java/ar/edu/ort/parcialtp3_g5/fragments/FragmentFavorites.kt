package ar.edu.ort.parcialtp3_g5.fragments

import android.os.Bundle
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
import ar.edu.ort.parcialtp3_g5.adapter.HomeCharacters

class FragmentFavorites : Fragment() {

    //private lateinit var productsRecyclerView: RecyclerView
    //private lateinit var productList: List<Product>
    private lateinit var title: TextView
    lateinit var activity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = (requireActivity() as AppCompatActivity)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity.supportActionBar?.title = getString(R.string.homeHeader)

        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isFavoritosEnabled = prefs.getBoolean("switchFavoritos",false)
        super.onViewCreated(view, savedInstanceState)
        if(isFavoritosEnabled){
            val recyclerView = view?.findViewById<RecyclerView>(R.id.favorites_recyclerview)
            val adapter = HomeCharacters()

            if (recyclerView != null) {
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager =layoutManager
                recyclerView.adapter = adapter
            }

            title = view.findViewById(R.id.id_textFavorites)

        // Pongo el nombre del usuario en el titulo.
/*
        title.text = "Hola, ${UserSession.userName}, estos son tus personajes favoritos "
*/
      }else{
            title = view.findViewById(R.id.id_textFavorites)
      }
    }

    override fun onStart() {
        super.onStart()
        activity.supportActionBar?.title = getString(R.string.homeHeader)
    }

}