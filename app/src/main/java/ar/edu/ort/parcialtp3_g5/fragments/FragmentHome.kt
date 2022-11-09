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
import ar.edu.ort.parcialtp3_g5.adapter.HomeCharactersAdapter
import ar.edu.ort.parcialtp3_g5.api.RickAndMortyService
import ar.edu.ort.parcialtp3_g5.data.RickAndMortyResponse
import ar.edu.ort.parcialtp3_g5.entities.RickAndMortyCharacter
import retrofit2.*

class FragmentHome : Fragment() {
    lateinit var userWelcome: TextView
    lateinit var activity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = (requireActivity() as AppCompatActivity)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.homeHeader)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userWelcome = view.findViewById(R.id.welcomeText)
        userWelcome.text = getString(R.string.welcome, UserSession.userName)

        //////////////////////////////////////////////////////
        //Retrofit
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
                    val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
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


        //////////////////////////////////////////////////////


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