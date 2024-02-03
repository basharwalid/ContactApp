package com.bashar.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import com.bashar.contactapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initRecyclerView()
    }

    private lateinit var adapter: MainActivityAdapter
    private fun initRecyclerView() {
        adapter = MainActivityAdapter(arrayListOf())
        viewBinding.rvContacts.adapter = adapter
        viewBinding.saveButton.setOnClickListener{
            onSaveClick()
        }
        adapter.onItemClickListener  = object : MainActivityAdapter.OnItemClickListener{
            override fun onClickListener(item: Contact) {
               val intent = Intent(this@MainActivity , InformationActivity::class.java)
                intent.putExtra("content : " , item)
                startActivity(intent)
            }

        }
    }

    private fun onSaveClick() {
        if (viewBinding.nameEd.text.length >= 3 && viewBinding.phoneEd.text.length == 11) {
            adapter.updateContactsList(
                Contact(
                    viewBinding.nameEd.text.toString(),
                    viewBinding.phoneEd.text.toString(),
                    viewBinding.descriptionEd.text.toString()
                )
            )
        }
    }
}