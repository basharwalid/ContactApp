package com.bashar.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_card)
        var bundle : Bundle? = intent.extras
        if(bundle!=null){

        }
    }
}