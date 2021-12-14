package com.ahmed.idemvvmfinalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmed.idemvvmfinalproject.model.topheadlines.TopHeadLinesResponse
import com.ahmed.idemvvmfinalproject.remote.ApiClient
import com.ahmed.idemvvmfinalproject.repo.NewsRepository
import retrofit2.Response
import java.util.concurrent.Executors

class NewsViewModel (private val repo :NewsRepository): ViewModel () {
  private  var _newTopHeadLine = MutableLiveData<Response<TopHeadLinesResponse>>()
    val newTopHeadLine :LiveData<Response<TopHeadLinesResponse>> = _newTopHeadLine




    fun getTopheadLine (country : String , apiKey:String ){
        val executors = Executors.newSingleThreadExecutor()
            executors.execute {
                val reslt = repo.getTopHeadLines(country , apiKey)
               _newTopHeadLine.postValue(reslt)
            }
    }




}
class MyViewModelFactory constructor(private val repository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java!!)) {
            NewsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}