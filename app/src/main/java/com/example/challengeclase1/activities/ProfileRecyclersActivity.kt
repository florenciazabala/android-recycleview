package com.example.challengeclase1.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R
import com.example.challengeclase1.entities.Color
import com.google.android.material.tabs.TabLayout
import androidx.navigation.findNavController
import com.example.challengeclase1.fragments.recycleview.RecycleView1FragmentDirections
import com.example.challengeclase1.fragments.recycleview.RecycleView2FragmentDirections

class ProfileRecyclersActivity : AppCompatActivity() {
    var colorsList: MutableList<Color> = ArrayList();

    lateinit var recyclerView: RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var colorAdapter: RecyclerView.Adapter<*>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_recyclers)

        val welcomeGreeting: TextView = findViewById(R.id.welcome_title);

        val alias = intent.getStringExtra("alias")
        welcomeGreeting.text = getString(R.string.welcome_title, alias);

        val tab: TabLayout = findViewById(R.id.tab_layout_r);

        /*Si tengo más de 2 tabs necesito conocer el tab anterior seleccionado.
        Puedo suponer que se inicia siempre en la posición 0? y al seleccionar una tab actualizarlo
        El evento unselected no sé si es asincrónico */

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val navController = findNavController(R.id.fragment_container_colors);

                if (tab != null) {
                    when(tab.position){
                        0 -> {
                            Log.d("Tab-profile", "Selected tab: " + tab.position.toString())
                            val action = RecycleView2FragmentDirections.actionRecycleView2FragmentToRecycleView1Fragment()
                            navController.navigate(action);
                        }
                        1 -> {
                            Log.d("Tab-profile", "Selected tab: " + tab.position.toString())
                            try {
                                val action = RecycleView1FragmentDirections.actionRecycleView1FragmentToRecycleView2Fragment()
                                navController.navigate(action);
                            }catch(e: Error){
                                Log.d("Tab-error", e.stackTraceToString())
                            }
                            //navController.popBackStack()

                        }
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    Log.d("Tab-profile", "Unselected tab: " + tab.position.toString())
                }
            }
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}