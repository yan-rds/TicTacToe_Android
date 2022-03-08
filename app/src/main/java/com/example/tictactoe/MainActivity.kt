package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNextActivity(view: View){
    val intent = Intent(this, GameActivity::class.java)
    startActivity(intent)
    view.setOnClickListener{
        startActivity(intent)
    }

    }
}