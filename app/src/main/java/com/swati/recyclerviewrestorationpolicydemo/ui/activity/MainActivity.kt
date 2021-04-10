package com.swati.recyclerviewrestorationpolicydemo.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.swati.recyclerviewrestorationpolicydemo.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allowAsync = findViewById<TextView>(R.id.allow_async)
        val allowSync = findViewById<TextView>(R.id.allow_sync)
        val preventWhenEmptyAsync = findViewById<TextView>(R.id.prevent_when_empty_async)
        val preventWhenEmptySync = findViewById<TextView>(R.id.prevent_when_empty_sync)
        val prevent = findViewById<TextView>(R.id.prevent)

        allowAsync.setOnClickListener(this)
        allowSync.setOnClickListener(this)
        preventWhenEmptyAsync.setOnClickListener(this)
        preventWhenEmptySync.setOnClickListener(this)
        prevent.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.allow_async -> {
                val intent = Intent(this, AllowAsyncActivity::class.java)
                startActivity(intent)
            }
            R.id.allow_sync -> {
                val intent = Intent(this, AllowSyncActivity::class.java)
                startActivity(intent)
            }
            R.id.prevent_when_empty_async -> {
                val intent = Intent(this, PreventWhenEmptyAsyncActivity::class.java)
                startActivity(intent)
            }
            R.id.prevent_when_empty_sync -> {
                val intent = Intent(this, PreventWhenEmptySyncActivity::class.java)
                startActivity(intent)
            }
            R.id.prevent -> {
                val intent = Intent(this, PreventActivity::class.java)
                startActivity(intent)
            }
        }
    }
}