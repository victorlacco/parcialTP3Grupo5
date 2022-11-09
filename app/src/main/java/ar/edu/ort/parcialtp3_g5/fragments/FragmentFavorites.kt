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
import ar.edu.ort.parcialtp3_g5.adapter.HomeCharactersAdapter
import ar.edu.ort.parcialtp3_g5.api.RickAndMortyService
import ar.edu.ort.parcialtp3_g5.data.RickAndMortyResponse
import ar.edu.ort.parcialtp3_g5.entities.RickAndMortyCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        activity.supportActionBar?.title = getString(R.string.favorites)

        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val isFavoritosEnabled = prefs.getBoolean("switchFavoritos",false)
        super.onViewCreated(view, savedInstanceState)
        if(isFavoritosEnabled){
            val baseURL = getString(R.string.baseURL)
            val api = RickAndMortyService.create(baseURL)  //create service

            //Call Request
            api.getAllCharacters()?.enqueue(object : Callback<RickAndMortyResponse?> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse?>,
                    response: Response<RickAndMortyResponse?>
                ) {
                    val response: RickAndMortyResponse? = (response.body() as RickAndMortyResponse)!!

                    val characters: MutableList<RickAndMortyCharacter>? = response?.results?.toMutableList()

                    val heroes = arrayOfNulls<String>(characters?.size ?: 0)

                    if (characters != null) {
                        val recyclerView = view?.findViewById<RecyclerView>(R.id.favorites_recyclerview)
                        val adapter = HomeCharactersAdapter(characters)

                        if (recyclerView != null) {
                            val layoutManager = LinearLayoutManager(context)
                            recyclerView.layoutManager =layoutManager
                            recyclerView.adapter = adapter
                        }
                        for (i in characters.indices) {
                            heroes[i] = characters[i].status
                        }
                    }
                }

                override fun onFailure(call: Call<RickAndMortyResponse?>, t: Throwable) {

                    //Snackbar.make(findViewById(R.id.recyclerView), t.message.toString(), Snackbar.LENGTH_LONG).show()
                }
            })
      }else{
            title = view.findViewById(R.id.id_textFavorites)
      }
    }

    override fun onStart() {
        super.onStart()
        activity.supportActionBar?.title = getString(R.string.favorites)
    }

}