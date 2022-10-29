package com.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.LinearLayoutManager
import com.recycleview.adapters.itemAdapters
import com.recycleview.databinding.ActivityMainBinding
import java.util.Date


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleViewItems.layoutManager = LinearLayoutManager(this)

        val itemAdapters = itemAdapters(this, getItemsList())

        binding.recycleViewItems.adapter = itemAdapters
    }

    private fun getItemsList(): ArrayList<DataModel>{
        val list = ArrayList<DataModel>()

        list.add(DataModel("Item 1 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 2 ViewType 2", itemAdapters.VIEW_TYPE_TWO))
        list.add(DataModel("Item 3 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 4 ViewType 2", itemAdapters.VIEW_TYPE_TWO))
        list.add(DataModel("Item 5 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 6 ViewType 2", itemAdapters.VIEW_TYPE_TWO))
        list.add(DataModel("Item 7 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 8 ViewType 2", itemAdapters.VIEW_TYPE_TWO))
        list.add(DataModel("Item 9 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 10 ViewType 2", itemAdapters.VIEW_TYPE_TWO))
        list.add(DataModel("Item 11 ViewType 1", itemAdapters.VIEW_TYPE_ONE))
        list.add(DataModel("Item 12 ViewType 2", itemAdapters.VIEW_TYPE_TWO))


        return list
    }
}
