package com.bashar.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.bashar.contactapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener{
            intent = Intent(this@MainActivity , InformationActivity::class.java)
            startActivity(intent)
        }

        initRecyclerView()

    }

    private lateinit var adapter : MainActivityAdapter
    private lateinit var contactList : MutableList<Contact>
    private fun initRecyclerView() {
        createContactList()
        adapter = MainActivityAdapter(contactList)
        adapter.onSaveButtonClickListener = object: MainActivityAdapter.OnSaveButtonClickListener{
            override fun onClickListener(position: Int, item: Contact) {

            }
        }
    }
    lateinit var nameEditText : EditText
    lateinit var phoneEditText : EditText
    lateinit var descriptionEditText : EditText

    private fun createContactList() {
        nameEditText = findViewById(R.id.nameEd)
        phoneEditText = findViewById(R.id.phoneEd)
        descriptionEditText = findViewById(R.id.descriptionEd)
        var name1 = nameEditText.toString()
        var phone1 = phoneEditText.toString()
        var description1 = descriptionEditText.toString()
            contactList = arrayListOf()
        for(i in 0..100){
            contactList.add(Contact(name = name1 , phone = phone1 , description = description1 , avatarID = R.drawable.download))
        }
    }
}