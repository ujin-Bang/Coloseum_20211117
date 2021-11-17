package com.neppplus.coloseum_20211117

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    val mContext = this

    abstract fun sutupEvents()
    abstract  fun setValues()

}