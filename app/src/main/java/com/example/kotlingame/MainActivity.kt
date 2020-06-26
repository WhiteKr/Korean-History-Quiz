package com.example.kotlingame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            val intent = Intent(this, IngameActivity::class.java)
            startActivity(intent)
            finish()
        }
        quitBtn.setOnClickListener {
            exitProcess(-1)
        }
    }
}