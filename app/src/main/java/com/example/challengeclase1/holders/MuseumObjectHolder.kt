package com.example.challengeclase1.holders

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challengeclase1.R

class MuseumObjectHolder(v: View): RecyclerView.ViewHolder(v) {
    private var view: View


    init {
        this.view = v
    }

    fun setTitle(title: String){
        val objectTitle: TextView = view.findViewById(R.id.color_name_title)
        objectTitle.text = title;
    }

    fun setAutor(autor: String){
        val autorText: TextView = view.findViewById(R.id.hexacode_txt)
        autorText.text = autor
    }

    fun setImage(image: String){
        val imageContainer: ImageView = view.findViewById(R.id.color_conainer)
        Glide.with(view.context).load(image).centerCrop().into(imageContainer)
        //imageContainer.background = ColorDrawable(Color.parseColor(image))
    }

    fun getCardLayout() = view.findViewById<CardView>(R.id.card_color_view)
}