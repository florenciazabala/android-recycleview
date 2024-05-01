package com.example.challengeclase1.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.challengeclase1.R
import com.example.challengeclase1.fragments.FirstFragmentDirections
import com.example.challengeclase1.fragments.SecondFragmentDirections
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.tabs.TabLayout

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)

        val welcomeGreeting: TextView = findViewById(R.id.welcome_title);

        val alias = intent.getStringExtra("alias")
        welcomeGreeting.text = getString(R.string.welcome_title, alias);

        val tab: TabLayout = findViewById(R.id.tab_layout);
        val dayNightSwitch: MaterialSwitch = findViewById(R.id.day_nigth_switch);

        /*Si tengo más de 2 tabs necesito conocer el tab anterior seleccionado.
        Puedo suponer que se inicia siempre en la posición 0? y al seleccionar una tab actualizarlo
        El evento unselected no sé si es asincrónico */

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val navController = findNavController(R.id.fragmentContainerView);

                if (tab != null) {
                    when(tab.position){
                        0 -> {
                            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                            navController.navigate(action);
                        }
                        1 -> {
                            Log.d("Tab-profile", "Selected tab: " + tab.position.toString())
                            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                            //navController.popBackStack()
                            navController.navigate(action);
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