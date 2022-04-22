package com.adl.ujiandays18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adl.ujiandays18.model.ResponsePostLogin
import com.adl.ujiandays18.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUI()

        RetrofitConfig().getLogin().getAllLogin().enqueue(object : Callback<ResponsePostLogin> {
            override fun onResponse(
                call: Call<ResponsePostLogin>,
                response: Response<ResponsePostLogin>
            ) {
                Log.d("Response",response.body().toString())
            }

            override fun onFailure(call: Call<ResponsePostLogin>, t: Throwable) {
                Log.e("error request",t.localizedMessage.toString())
            }

        })

    }
    private fun setUpUI() {
        //   val user = txtUser.text.toString()
        //val password = txtPass.text.toString()
        btnLogin.setOnClickListener({

            RetrofitConfig().getLogin().addData(txtUser.text.toString(),txtPass.text.toString())
                .enqueue(object: Callback<ResponsePostLogin> {
                    override fun onResponse(
                        call: Call<ResponsePostLogin>,
                        response: Response<ResponsePostLogin>
                    ) {
                        Toast.makeText(
                            this@MainActivity, (response.body() as ResponsePostLogin)
                                .message, Toast.LENGTH_LONG
                        ).show()

                        val intent = Intent(this@MainActivity,MainMenu::class.java)
                        startActivity(intent)
                    }

                    override fun onFailure(call: Call<ResponsePostLogin>, t: Throwable) {
                        Log.e("error post data ", t.localizedMessage.toString())

                    }

                })

        })

    }

}