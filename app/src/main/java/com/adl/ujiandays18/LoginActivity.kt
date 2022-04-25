package com.adl.ujiandays18
//STEP 1
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adl.ujiandays18.model.ResponseLogin
import com.adl.ujiandays18.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener({
            login()
        })

    }
    fun login(){
        RetrofitConfig().getLogin().login("username",txtUser.text.toString()).
        enqueue(object: Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                val username = (response.body() as ResponseLogin).data?.ujianlogin?.get(0)?.username.toString()
                val password = (response.body() as ResponseLogin).data?.ujianlogin?.get(0)?.password.toString()
//ubah di myphp username jadi uniqe viar gak bisa sama
                if (txtUser.text.toString()==username && txtPass.text.toString() == password){
                    //simpan username as cookies step 2
                    val editor:SharedPreferences.Editor = getSharedPreferences("absen",Context.MODE_PRIVATE).edit()
                    editor.putString("username",username)
                    editor.apply()
                    /////////
                    val intent: Intent = Intent(applicationContext,MainMenu::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@LoginActivity,"Maaf Username atau Password Anda Salah",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Toast.makeText(this@LoginActivity,t.localizedMessage.toString(),
                    Toast.LENGTH_LONG).show()


            }

        })
    }

}