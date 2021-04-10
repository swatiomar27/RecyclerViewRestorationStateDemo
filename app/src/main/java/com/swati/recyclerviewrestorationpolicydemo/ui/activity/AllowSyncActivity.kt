package com.swati.recyclerviewrestorationpolicydemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swati.recyclerviewrestorationpolicydemo.R
import com.swati.recyclerviewrestorationpolicydemo.ui.adapter.RestoreDemoAdapter

class AllowSyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_demo)

        val rvRestoreDemo = findViewById<RecyclerView>(R.id.rv_restore_demo)
        val stringList = ArrayList<String>()
        for (i in 1..100) {
            stringList.add("Number $i")
        }
        val recyclerAdapter = RestoreDemoAdapter(stringList)
        rvRestoreDemo.layoutManager = LinearLayoutManager(this)
        rvRestoreDemo.adapter = recyclerAdapter
        rvRestoreDemo.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.ALLOW
    }
}