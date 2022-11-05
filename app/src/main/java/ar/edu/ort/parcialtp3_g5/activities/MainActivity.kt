package ar.edu.ort.parcialtp3_g5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.parcialtp3_g5.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawer: DrawerLayout
    private lateinit var vista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Busco el Navegación Controller
        navController = Navigation.findNavController(this,R.id.fragmentContainerView)

        //Asigno al Drawer Menu el control de navegación
        vista = findViewById(R.id.nav_view)
        vista.setupWithNavController(navController)

        drawer = findViewById(R.id.drawer_layout_id)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer)

        //Seteo la configuración
        //setupActionBarWithNavController(navController, appBarConfiguration)

        //Dejo un lisener para cuando se produce el cambio de destino unicamente me reemplace el icono.
        //navController.addOnDestinationChangedListener { _, _, _ ->
        //    supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
        //}
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer)
    }

}

/*

    CODIGO PARA LA EJECUCION DE ENDPOINTS

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listview)

        val baseURL = "https://rickandmortyapi.com/"

        //Create Service
        val api = RickAndMortyService.create(baseURL)

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
                    for (i in characters.indices) {
                        heroes[i] = characters[i].status
                    }
                }

                listView.adapter = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_list_item_1,
                    heroes
                )
            }

            override fun onFailure(call: Call<RickAndMortyResponse?>, t: Throwable) {
                Snackbar.make(findViewById(R.id.listview), t.message.toString(), Snackbar.LENGTH_LONG).show()
            }
        })

    }

*/