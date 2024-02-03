package com.bashar.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.bashar.contactapp.databinding.ActivityMainBinding
import com.bashar.contactapp.databinding.InformationCardBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var viewBinding : InformationCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = InformationCardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val contact = IntentCompat.getParcelableExtra(intent ,Constant.CONTACT , Contact::class.java)
        contact?.let {
            viewBinding.nameTv.text = contact.name
            viewBinding.phoneTv.text = contact.phone
            viewBinding.descriptionTv.text = contact.description
        }
        navigateBack()
    }

    private fun navigateBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}