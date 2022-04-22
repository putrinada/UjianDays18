package com.adl.ujiandays18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnCheckin.setOnClickListener({
            val intent = Intent(this@MainMenu,CheckinActivity::class.java)
            startActivity(intent)

        })
        btnHistori.setOnClickListener({
            val intent = Intent(this@MainMenu,HistoryActivity::class.java)
            startActivity(intent)


        })

        btnLogout.setOnClickListener({
            val intent = Intent(this@MainMenu,MainActivity::class.java)
            startActivity(intent)

        })


    }
}