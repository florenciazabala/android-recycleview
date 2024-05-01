package com.example.challengeclase1.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R
import com.example.challengeclase1.entities.Color
import com.example.challengeclase1.holders.ColorHolder

// Conexión entre el modelo y el Holder
//Necesita la lista y el Holder (Caché de la vista, intermedio entre la vista y el código)
class ColorAdapter(
    val colors: MutableList<Color>
): RecyclerView.Adapter<ColorHolder>() {

    //Recibe la vista y la infla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_item,parent,false)
        return (ColorHolder(view))
    }

    //Devuelve cantidad de elementos de la lista
    override fun getItemCount() = colors.size

    //Permite setear datos
    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        val color = colors[position]
        holder.setName(color.name)
        holder.setHexaCode(color.hexaCode)

        holder.getCardLayout().setOnClickListener{
            //R.color.gradient_start = android.graphics.Color.parseColor(color.hexaCode)
        }
    }
}