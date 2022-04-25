package com.adl.ujiandays18
//STEP 4
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.ujiandays18.adapter.AbsensiAdapter
import com.adl.ujiandays18.model.ResponseAbsen
import com.adl.ujiandays18.model.TblAbsenItem
import com.adl.ujiandays18.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_history.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivity : AppCompatActivity() {

    lateinit var lstAbsent :List<TblAbsenItem?>
    lateinit var absentAdapter : AbsensiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        loadData()
    }

    private fun loadData() {
        RetrofitConfig().getAbsen().getAllAbsen().enqueue(object:
            Callback<ResponseAbsen> {
            override fun onResponse(call: Call<ResponseAbsen>, response: Response<ResponseAbsen>) {


                lstAbsent = response.body()?.data?.tblAbsen!!

                absentAdapter = ArrayList(lstAbsent)?.let { AbsensiAdapter(it) }
                recycleAbsent.apply {
                    layoutManager = LinearLayoutManager(this@HistoryActivity)
                    adapter = absentAdapter
                }



            }

            override fun onFailure(call: Call<ResponseAbsen>, t: Throwable) {
                Toast.makeText(this@HistoryActivity,t.localizedMessage.toString(),
                    Toast.LENGTH_LONG).show()
            }

        })
    }
}