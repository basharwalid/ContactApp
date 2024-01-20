package com.bashar.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivityAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : EditText = itemView.findViewById(R.id.nameEd)
        private val phone : EditText = itemView.findViewById(R.id.phoneEd)
        val description : EditText = itemView.findViewById(R.id.descriptionEd)
        var name1 = name.toString()
        var phone1 = phone.toString()
        var desc = description.toString()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name1 = contact.name
        holder.phone1 = contact.phone
        holder.desc = contact.description

        holder.itemView.setOnClickListener{
            onSaveButtonClickListener?.onClickListener(
                position,
                contact
            )
        }
    }
    var onSaveButtonClickListener: OnSaveButtonClickListener?=null
    interface OnSaveButtonClickListener{
        fun onClickListener(position :Int , item:Contact)
    }
}