package com.bashar.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivityAdapter(val contacts: List<Contact>) :
    RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameEd)
        val phone: TextView = itemView.findViewById(R.id.phoneEd)
        val description: TextView = itemView.findViewById(R.id.descriptionEd)
        val avatarID : ImageView = itemView.findViewById(R.id.card_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name.text = contact.name
        holder.avatarID.setImageResource(contact.avatarID   )

    }
}