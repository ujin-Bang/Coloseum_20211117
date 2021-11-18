package com.neppplus.coloseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.neppplus.coloseum_20211117.databinding.ActivityMainBinding
import com.neppplus.coloseum_20211117.utils.ServerUtil
import org.json.JSONObject

class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setValues()
        setupEvents()



    }

    override fun setupEvents() {

        binding.btnLogin.setOnClickListener {

            binding.btnLogin


            val inputEmail = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()


//            서버에서 이메일 비번이 맞는 계정인지? 로그인 요청
            ServerUtil.postRequestLogIn(inputEmail, inputPw, object : ServerUtil.jsonResponseHandler {
                override fun onResponse(jsonObj: JSONObject) {


                    Log.d("화면에서의 jsonObj",jsonObj.toString())

                    val code = jsonObj.getInt("code")

                    runOnUiThread {

                        if(code == 200) {
                            Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT).show()

//                           message String으로 실패 사유를 알려준다
//                           JSON 파싱으로 추출해서 -> 로그인 실패 대신 서버가 알려준 실패 사유를 띄우자
                            Toast.makeText(mContext, "로그인실패 ", Toast.LENGTH_SHORT).show()
                        }

                    }


                }

            } )
        }
    }

    override fun setValues() {

    }


}