package com.example.challengeclase1.fragments.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeclase1.R
import com.example.challengeclase1.adapters.ColorAdapter
import com.example.challengeclase1.entities.Color

class RecycleView2Fragment : Fragment() {
    var colorsList: MutableList<Color> = ArrayList();

    lateinit var recyclerView: RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var colorAdapter: RecyclerView.Adapter<*>

    lateinit var view2: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view2 = inflater.inflate(R.layout.fragment_recycle_view2, container, false)
        return  view2
    }

    override fun onStart() {
        super.onStart()

        fillColorList()
        recyclerView = view2.findViewById(R.id.recicle_view_2)
        recyclerView.setHasFixedSize(true) //Ancho fijo

        manager = LinearLayoutManager(context) //Horizontal o vertical
        colorAdapter = ColorAdapter(colorsList)

        recyclerView.layoutManager = manager
        recyclerView.adapter = colorAdapter
    }


    fun fillColorList(){
        colorsList.add(Color("blue","#4e67c4"))
        colorsList.add(Color("green","#09909e"))
        colorsList.add(Color("purple","#DA8DD7"))
        colorsList.add(Color("yellow","#ffffaa"))
        colorsList.add(Color("red","#DFA999"))
        colorsList.add(Color("purple","#DA8DD7"))
        colorsList.add(Color("blue","#4e67c4"))
        colorsList.add(Color("yellow","#ffffaa"))
        colorsList.add(Color("red","#DFA999"))
        colorsList.add(Color("green","#09909e"))
    }
}