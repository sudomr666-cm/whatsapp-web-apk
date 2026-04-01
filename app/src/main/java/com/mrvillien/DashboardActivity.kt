package com.mrvillien

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
    }

    fun openWhatsApp(v: android.view.View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
