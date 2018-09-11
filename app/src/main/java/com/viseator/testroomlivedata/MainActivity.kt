package com.viseator.testroomlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button

class MainActivity : AppCompatActivity() {
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AccountManager.login(User().apply {
            userName = "user1"
            uid = System.currentTimeMillis().toString()
        })
        button.setOnClickListener {
            AccountManager.login(User().apply {
                userName = "user${i++}"
                uid = System.currentTimeMillis().toString()
            })
        }
    }
}
