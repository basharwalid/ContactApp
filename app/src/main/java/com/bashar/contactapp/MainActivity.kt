package com.bashar.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.bashar.contactapp.databinding.ActivityContactRecyclerviewBinding
import com.bashar.contactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactRecyclerviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityContactRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        initRecyclerView()
    }

    lateinit var adapter: MainActivityAdapter
    lateinit var nameText: EditText
    lateinit var phoneText: EditText

    private fun initRecyclerView() {
        adapter = MainActivityAdapter(createContactList())
        binding.rvContacts.adapter = adapter
        nameText = findViewById(R.id.nameEd)
        phoneText = findViewById(R.id.phoneEd)

    }

    private var name = nameText.text.toString()
    private var phoneString = phoneText.text.toString()
    private var av = R.drawable.download

    private fun createContactList(): List<Contact> {
        val contactList = arrayListOf<Contact>()
        for (i in 0..100) {
            contactList.add(
                Contact(name = name , phone = phoneString , avatarID = av)
            )
        }
        return contactList
    }
}