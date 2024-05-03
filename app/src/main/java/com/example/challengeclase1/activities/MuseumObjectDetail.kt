package com.example.challengeclase1.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.challengeclase1.R
import com.example.challengeclase1.entities.MuseumObject

import com.bumptech.glide.Glide

class MuseumObjectDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_museum_object_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val museoItem = intent.getParcelableExtra<MuseumObject>("museumItem")

        val imageContainer: ImageView = findViewById(R.id.imageView3);
        val image: String? = museoItem?.primaryImageSmall
        Glide.with(this).load(image).centerCrop().into(imageContainer)

        val title: String? = museoItem?.title
        val artistDisplayName: String? = museoItem?.artistDisplayName

        val titleContainer: TextView = findViewById(R.id.textView3);
        val artistnameContainer: TextView = findViewById(R.id.textView4);

        titleContainer.text = title
        artistnameContainer.text = artistDisplayName

    }
}

