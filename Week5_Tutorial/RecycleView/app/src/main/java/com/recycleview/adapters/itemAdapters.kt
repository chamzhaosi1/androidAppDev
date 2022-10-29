package com.recycleview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.recycleview.DataModel
import com.recycleview.R
import com.recycleview.databinding.ItemCustomRowBinding
import com.recycleview.databinding.ItemAnotherCustomRowBinding

class itemAdapters(val context: Context, val items: ArrayList<DataModel>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){


        companion object{
            const val VIEW_TYPE_ONE = 1
            const val VIEW_TYPE_TWO = 2
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val binding = ItemCustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            val anotherBinding = ItemAnotherCustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            if (viewType == VIEW_TYPE_ONE){
                return ViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_custom_row,
                        parent,
                        false
                    ),
                    binding
                )
            }else{
                return AnotherViewHolder(
                    LayoutInflater.from(context).inflate(
                        R.layout.item_another_custom_row,
                        parent,
                        false
                    ),
                    anotherBinding
                )
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
            val item = items.get(position)

            if(holder is ViewHolder){
                holder.tvItem.text = item.itemName

                if (position % 2 == 0){
                    holder.cardViewItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorLightGray
                        )
                    )
                }else {
                    holder.cardViewItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorWhite
                        )
                    )
                }
            }else if(holder is AnotherViewHolder){
                holder.tvAnotherItemName.text = item.itemName

                if (position % 2 == 0){
                    holder.cardViewAnotherItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorLightGray
                        )
                    )
                }else {
                    holder.cardViewAnotherItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorWhite
                        )
                    )
                }
            }
        }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

        override fun getItemCount(): Int{
            return items.size
        }

        class ViewHolder(view: View, binding: ItemCustomRowBinding): RecyclerView.ViewHolder(binding.root){
            val tvItem = binding.tvItemName
            val cardViewItem = binding.cardViewItem
        }


        class AnotherViewHolder(view: View, anotherBinding: ItemAnotherCustomRowBinding): RecyclerView.ViewHolder(anotherBinding.root){
            val tvAnotherItemName = anotherBinding.tvAnotherItemName
            val cardViewAnotherItem = anotherBinding.cardViewAnotherItem
        }

    }