package ar.edu.ort.parcialtp3_g5.activities

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ar.edu.ort.parcialtp3_g5.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawer: DrawerLayout
    private lateinit var vista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawerNavigationView()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        nav_view.setupWithNavController(navHostFragment.navController)

        //Busco el Navegación Controller
   /*     navController = Navigation.findNavController(this,R.id.fragmentContainerView)

        //Asigno al Drawer Menu el control de navegación
        vista = findViewById(R.id.nav_view)
        vista.setupWithNavController(navController)

        drawer = findViewById(R.id.drawer_layout_id)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer)
*/
        //Seteo la configuración
        //setupActionBarWithNavController(navController, appBarConfiguration)

        //Dejo un lisener para cuando se produce el cambio de destino unicamente me reemplace el icono.
        navHostFragment.navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        //Fuezo al boton de navegación de la toolbar que solo abra el menú Drawer
        if (drawer_layout_id.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_id.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout_id.openDrawer(GravityCompat.START)
        }

        //Cancelo la navegación
        //return NavigationUI.navigateUp(navController, drawer_layout_id)
        return false
    }


    private fun setupDrawerNavigationView(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val drawerNavView = findViewById<NavigationView>(R.id.nav_view)
        vista = findViewById(R.id.nav_view)
        vista.setupWithNavController(navHostFragment.navController)

        drawer = findViewById(R.id.drawer_layout_id)
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController, drawer)
        drawerNavView.setupWithNavController(navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener{ _, destination, arguments ->
            if(destination.id == R.id.fragmentLogin){
                drawerNavView.visibility = View.GONE
            }else {
                drawerNavView.visibility = View.VISIBLE
            }

            if(destination.id == R.id.fragmentHome){
                arguments?.getString("username")?.let { UserSession.userName = it }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
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