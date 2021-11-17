package com.neppplus.coloseum_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neppplus.coloseum_20211117.databinding.ActivityMainBinding
import com.neppplus.coloseum_20211117.utils.ServerUtil

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


            val inputEmail = binding.edtEmail.text.toString()
            val inputPw = binding.edtPassword.text.toString()


//            서버에서 이메일 비번이 맞는 계정인지? 로그인 요청
            ServerUtil.postRequestLogIn(inputEmail, inputPw)
        }
    }

    override fun setValues() {

    }


}