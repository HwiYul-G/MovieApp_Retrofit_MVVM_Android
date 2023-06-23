package com.example.movieapp_retrofit_mvvm_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp_retrofit_mvvm_android.model.data.Movies
import com.example.movieapp_retrofit_mvvm_android.model.data.Result
import com.example.movieapp_retrofit_mvvm_android.model.repo.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// MVVM 아키텍쳐를 위해서, live-data를 가진 ViewModel 클래스가 필요하다.
class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object  : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}