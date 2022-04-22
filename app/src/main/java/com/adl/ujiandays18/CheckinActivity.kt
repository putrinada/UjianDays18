package com.adl.ujiandays18

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.adl.ujiandays18.model.ResponsePostAbsen
import com.adl.ujiandays18.service.RetrofitConfig
import com.github.drjacky.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_checkin.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class CheckinActivity : AppCompatActivity() {

    lateinit var photoURI: Uri //upload image

    // step aktifin kamera
    private  val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK){
                val uri = it.data?.data!!
                // masukin photo

                photo.setImageURI(uri)

                //upload image
                photoURI=uri
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)


        btnCamera.setOnClickListener({ cameraLauncher.launch(
            ImagePicker.with(this)
                .crop()
                .cameraOnly()
                .maxResultSize(480, 800, true)
                .createIntent()
        )

        })

        btnLoginfoto.setOnClickListener({
            RetrofitConfig().getAbsen().addDataAndImage(createRB("uti"),uploadImage(photoURI,"datafoto"))
                .enqueue(
                    object : Callback<ResponsePostAbsen> {
                        override fun onResponse(
                            call: Call<ResponsePostAbsen>,
                            response: Response<ResponsePostAbsen>
                        ) {
                            Toast.makeText(
                                this@CheckinActivity, (response.body() as ResponsePostAbsen)
                                    .message, Toast.LENGTH_LONG
                            ).show()
                        }

                        override fun onFailure(call: Call<ResponsePostAbsen>, t: Throwable) {
                            Log.e("error post data ", t.localizedMessage.toString())
                        }

                    })
        })

    }
    ///upload image
    fun createRB(data:String): RequestBody {
        return RequestBody.create(MultipartBody.FORM,data)
    }

    fun uploadImage(uri: Uri, param: String): MultipartBody.Part {
        val file: File = File(uri.path)
        val rb: RequestBody =  file.asRequestBody("image/jpeg".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(param,file.name,rb)
    }
}