package com.example.challengeclase1.holders

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R

// Patron memento: inner class guarda su propio estado interno solo el maneja su estado
// Hace un wrap de la vista, solo el puede acceder a los métodos de la vista y manipularla
class ColorHolder(v: View): RecyclerView.ViewHolder(v) {

    private var view: View


    init {
        this.view = v
    }

    fun setName(name: String){
        val colorNameTitle: TextView = view.findViewById(R.id.color_name_title)
        colorNameTitle.text = name;
    }

    fun setHexaCode(hexaCode: String){
        val colorContainer: ImageView = view.findViewById(R.id.color_conainer)
        val hexaCodeText: TextView = view.findViewById(R.id.hexacode_txt)
        colorContainer.background = ColorDrawable(Color.parseColor(hexaCode))

        hexaCodeText.text = hexaCode
    }

    fun getCardLayout() = view.findViewById<CardView>(R.id.card_color_view)
}