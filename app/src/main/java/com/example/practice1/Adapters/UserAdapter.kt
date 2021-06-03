package com.example.practice1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice1.R
import com.example.practice1.model.UsersItem
import kotlinx.android.synthetic.main.users_item.view.*
import wu.seal.jsontokotlin.model.UnSupportJsonException

class UserAdapter: RecyclerView.Adapter<UserAdapter.MyViewHolder>(){
    private var myList = emptyList<UsersItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tvUserName.text = myList[position].login
    }

    override fun getItemCount(): Int {
        return myList.size
    }
    fun setData(newList: List<UsersItem>){
        myList = newList
        notifyDataSetChanged()
    }
}