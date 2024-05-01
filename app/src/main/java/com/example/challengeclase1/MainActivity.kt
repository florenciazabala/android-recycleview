package com.example.challengeclase1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.challengeclase1.activities.ProfileActivity
import com.example.challengeclase1.activities.ProfileRecyclersActivity
import com.example.challengeclase1.entities.MuseumObject
import com.example.challengeclase1.entities.MuseumObjects
import com.example.challengeclase1.fragments.FirstFragmentDirections
import com.example.challengeclase1.service.ActivityServiceApiBuilder
import com.example.challengeclase1.service.MuseumService
import com.example.challengeclase1.service.MuseumServiceImpl
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var registerButton: Button = findViewById(R.id.register_btn);
        var aliasInput: TextInputEditText = findViewById(R.id.alias_input);

        registerButton.setOnClickListener(){
            val intent = Intent(this,ProfileRecyclersActivity::class.java);
            intent.putExtra("alias",aliasInput.text.toString());
            startActivity(intent);
        }

    }
}