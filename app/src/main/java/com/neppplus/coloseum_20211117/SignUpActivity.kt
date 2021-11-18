package com.neppplus.coloseum_20211117

import android.widget.Toast
import com.neppplus.coloseum_20211117.utils.ServerUtil

class SignUpActivity {


}


 fun setupEvents( ) {
     binding.btnOk.setOnClickListener {

         val inputEmail = binding.edtEmail.text.toString()

         val inputPw = binding.edtPassword.text.toString()
         val inputNickname = binding.edtNickname.text.toString()


//
         ServerUtil.putRequestSignUp(inputEmail,inputPw,inputNickname, object :ServerUtil.JsonResponseHandler) {
            override fun onResponse(jsonObj: JSONObject) {

                val code = jsonObj.getInt("code")

                if( code == 200) {
             }
                else {

//                    실패 -> 서버가 알려주는 "message"에 담긴 실패 사유를 토스트로
                    val message = jsonObj.getString("message")

                    runOnUiThread {

                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                    }

                }


                }

         }

     }
 }