package com.example.challengeclase1.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R
import com.example.challengeclase1.activities.ProfileRecyclersActivity
import com.example.challengeclase1.entities.Color
import com.example.challengeclase1.entities.MuseumObject
import com.example.challengeclase1.holders.ColorHolder
import com.example.challengeclase1.holders.MuseumObjectHolder

class MuseumObjectAdapter(
    val museumObjects: MutableList<MuseumObject>
): RecyclerView.Adapter<MuseumObjectHolder>() {

    //Recibe la vista y la infla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_item,parent,false)
        return (MuseumObjectHolder(view))
    }

    //Devuelve cantidad de elementos de la lista
    override fun getItemCount() = museumObjects.size

    //Permite setear datos
    override fun onBindViewHolder(holder: MuseumObjectHolder, position: Int) {
        val museumObject = museumObjects[position]
        holder.setTitle(museumObject.title)
        holder.setAutor(museumObject.artistDisplayName)
        holder.setImage(museumObject.primaryImageSmall)

        /*holder.getCardLayout().setOnClickListener{
            val intent = Intent(this, ProfileRecyclersActivity::class.java);
            intent.putExtra("alias",aliasInput.text.toString());
            startActivity(intent);
        }*/
    }
}