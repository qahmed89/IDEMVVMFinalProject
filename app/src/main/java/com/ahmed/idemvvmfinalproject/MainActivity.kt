package com.ahmed.idemvvmfinalproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.idemvvmfinalproject.adpater.NewsAdapter
import com.ahmed.idemvvmfinalproject.model.topheadlines.Article
import com.ahmed.idemvvmfinalproject.other.Other
import com.ahmed.idemvvmfinalproject.remote.ApiClient
import com.ahmed.idemvvmfinalproject.repo.NewsRepository
import com.ahmed.idemvvmfinalproject.viewmodel.MyViewModelFactory
import com.ahmed.idemvvmfinalproject.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniltMainActivity()
        observer()
    }

    private fun observer() {
        viewModel.newTopHeadLine.observe(this, { result ->
            if (result.isSuccessful) {
                Log.i("MainActivity", result.body()?.status.toString())
                result.body()?.articles?.let { setupRecycerView(it) }
                progressBar.visibility = View.GONE
            } else {
                Log.i("MainActivity", "error")

            }

        })
    }


   
    private fun iniltMainActivity() {
        val newsViewModelFactory =
            MyViewModelFactory(NewsRepository(ApiClient().createNewsService()))
        viewModel = ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        viewModel.getTopheadLine("us", Other.API_KEY)
    }

    private fun setupRecycerView(list: List<Article>) {
        recyclerView.apply {
            adapter = NewsAdapter(list)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }
}