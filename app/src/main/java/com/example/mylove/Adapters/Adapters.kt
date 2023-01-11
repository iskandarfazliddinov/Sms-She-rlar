package com.example.mylove.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylove.Data.UserData
import com.example.mylove.databinding.ItemBinding

class Adapters(val data: ArrayList<UserData>,
               val onItemClick: (userData: UserData) -> Unit)
                : RecyclerView.Adapter<Adapters.VH>() {

    inner class VH(val itemUserBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root) {
        fun onBind(data: UserData, position: Int) {
            itemUserBinding.apply {
                textName.text = data.textName
                textInfo.text = data.textInfo

                btnItem.setOnClickListener {
                    onItemClick.invoke(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}