package com.example.challengeclase1.fragments.recycleview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R
import com.example.challengeclase1.activities.MuseumObjectDetail
import com.example.challengeclase1.adapters.ColorAdapter
import com.example.challengeclase1.adapters.MuseumObjectAdapter
import com.example.challengeclase1.entities.Color
import com.example.challengeclase1.entities.MuseumObject
import com.example.challengeclase1.listeners.OnViewProfile
import com.example.challengeclase1.service.MuseumServiceImpl

class RecycleView1Fragment : Fragment(), OnViewProfile {

    //var colorsList: MutableList<Color> = ArrayList();
    val museumObjects = MuseumServiceImpl.getItems();

    lateinit var recyclerView: RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    //lateinit var colorAdapter: RecyclerView.Adapter<*>
    lateinit var museumAdapter: RecyclerView.Adapter<*>

    lateinit var view1: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_recycle_view1, container, false)
        recyclerView = view1.findViewById(R.id.recycler_1)
        return view1
    }

    override fun onStart() {
        super.onStart()

        //fillColorList()

        recyclerView.setHasFixedSize(true) //Ancho fijo

        manager = LinearLayoutManager(context) //Horizontal o vertical
        //colorAdapter = ColorAdapter(colorsList)
        museumAdapter = MuseumObjectAdapter(museumObjects, this)

        recyclerView.layoutManager = manager
        //recyclerView.adapter = colorAdapter
        recyclerView.adapter = museumAdapter

    }

    override fun onViewItemDetail(museumObject: MuseumObject){
        val intent = Intent(context, MuseumObjectDetail::class.java);
        intent.putExtra("museumItem",museumObject);
        startActivity(intent);
    }

    /*fun fillColorList() {
        colorsList.add(Color("purple", "#DA8DD7"))
        colorsList.add(Color("blue", "#4e67c4"))
        colorsList.add(Color("yellow", "#ffffaa"))
        colorsList.add(Color("red", "#DFA999"))
        colorsList.add(Color("green", "#09909e"))
        colorsList.add(Color("purple", "#DA8DD7"))
        colorsList.add(Color("blue", "#4e67c4"))
        colorsList.add(Color("yellow", "#ffffaa"))
        colorsList.add(Color("red", "#DFA999"))
        colorsList.add(Color("green", "#09909e"))
    }*/
}