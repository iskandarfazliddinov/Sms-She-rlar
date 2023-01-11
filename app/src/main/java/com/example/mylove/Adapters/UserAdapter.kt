package com.example.mylove.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylove.databinding.ItemsaveBinding
import com.example.project_contact.DataBase.UserDatas

class UserAdapter(val data : ArrayList<UserDatas>,
                  val onItemClick: (userdata:UserDatas,position:Int) -> Unit
                  ):RecyclerView.Adapter<UserAdapter.VH>() {

    inner class VH(val  itemUserBinding : ItemsaveBinding):RecyclerView.ViewHolder(itemUserBinding.root){
        fun onBind(data: UserDatas , position: Int){
            itemUserBinding.apply {
                textNames.text = data.textName
                textInfos.text = data.textInfo

                btnItem.setOnClickListener {
                    onItemClick.invoke(data,position)
                }
            }


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemsaveBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position],position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}