package com.adl.ujiandays18
//STEP 2
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val status = getSharedPreferences("absen ",Context.MODE_PRIVATE).getString("status"," ")!!
        if(!status.equals("")){
            txtStatus.setText("CHECK OUT")
        }else{
            txtStatus.setText("CHECK IN")
        }

        btnCheckin.setOnClickListener({
            //jika di klik pindah ke Checkin
            val intent : Intent = Intent(applicationContext,CheckinActivity::class.java)
            startActivity(intent)

        })
        btnHistori.setOnClickListener({
            //jika di klik pindah ke History
            val intent : Intent = Intent(applicationContext,HistoryActivity::class.java)
            startActivity(intent)


        })

        btnLogout.setOnClickListener({
            //selesai
           finish()

        })


    }

    override fun onResume() {
        super.onResume()
        val status = getSharedPreferences("absen ",Context.MODE_PRIVATE).getString("status"," ")!!
        if(!status.equals("")){
            txtStatus.setText("CHECK OUT")
        }else{
            txtStatus.setText("CHECK IN")
        }
    }
}