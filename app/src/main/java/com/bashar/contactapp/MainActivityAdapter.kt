package com.bashar.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivityAdapter(private val contacts: MutableList<Contact>) :
    RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_tv)
        val phone: TextView = itemView.findViewById(R.id.phone_tv)
        val description: TextView = itemView.findViewById(R.id.description_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.information_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name.text = contact.name
        holder.phone.text = contact.phone
        holder.description.text = contact.description
        holder.itemView.setOnClickListener{
            onItemClickListener?.onClickListener(contact)
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClickListener(contact: Contact)
    }

    fun updateContactsList(contact: Contact) {
        contacts.add(contact)
        notifyItemInserted(contacts.size -1)
    }
}