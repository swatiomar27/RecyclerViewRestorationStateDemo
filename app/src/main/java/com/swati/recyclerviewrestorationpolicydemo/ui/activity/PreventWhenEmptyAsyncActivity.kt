package com.swati.recyclerviewrestorationpolicydemo.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swati.recyclerviewrestorationpolicydemo.R
import com.swati.recyclerviewrestorationpolicydemo.api.ApiClient
import com.swati.recyclerviewrestorationpolicydemo.model.DataModel
import com.swati.recyclerviewrestorationpolicydemo.ui.adapter.DataAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreventWhenEmptyAsyncActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    var dataList = ArrayList<DataModel>()
    private lateinit var rvRestoreDemo: RecyclerView
    private val recyclerAdapter by lazy {
        DataAdapter(dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_demo)

        init()
        showProgressBar()
        setupRecyclerView()

        getData()

    }

    private fun init() {
        rvRestoreDemo = findViewById(R.id.rv_restore_demo)
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun setupRecyclerView() {
        rvRestoreDemo.layoutManager = LinearLayoutManager(this)
        rvRestoreDemo.adapter = recyclerAdapter
        rvRestoreDemo.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(
                call: Call<List<DataModel>>?,
                response: Response<List<DataModel>>?
            ) {
                hideProgressBar()
                dataList.addAll(response!!.body()!!)
                recyclerAdapter.updateList(dataList)
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                hideProgressBar()
            }
        })
    }

}