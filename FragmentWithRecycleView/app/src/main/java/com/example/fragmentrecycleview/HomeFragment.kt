package com.example.fragmentrecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    private var itemArrayList: ArrayList<DataModel> = ArrayList()
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        getDataModel()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager =  LinearLayoutManager(context)
                adapter = MyAdapter(itemArrayList)
            }
        }
        return view
    }

    private fun getDataModel(){
        itemArrayList.add(DataModel("Arduino", "R.id.image"))
        itemArrayList.add(DataModel("Website", "R.id.image"))
        itemArrayList.add(DataModel("System", "R.id.image"))
        itemArrayList.add(DataModel("Mobile..", "R.id.image"))
        itemArrayList.add(DataModel("Kiosk.00000000000000000000000000000000000000000000000000000000000000000..", "R.id.image"))
        itemArrayList.add(DataModel("Arduino0...", "R.id.image"))
        itemArrayList.add(DataModel("Website.00000000000000000000000000000000000000000000000000000000000000000..", "R.id.image"))
        itemArrayList.add(DataModel("System00000000000000000000000000000000000000000000000000000000000000000...", "R.id.image"))
        itemArrayList.add(DataModel("Mobile0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000...", "R.id.image"))
        itemArrayList.add(DataModel("Kiosk.00000000000000000000000000000000000000000000000000000000000000000..", "R.id.image"))
    }
}