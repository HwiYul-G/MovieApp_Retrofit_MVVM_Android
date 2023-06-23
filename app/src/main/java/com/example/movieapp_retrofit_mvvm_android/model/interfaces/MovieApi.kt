package com.example.movieapp_retrofit_mvvm_android.model.interfaces

import com.example.movieapp_retrofit_mvvm_android.model.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// endpoint에서 popular movies의 list를 회수하는 get메소드 딱 한 개뿐인 인터페이스.
interface MovieApi {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}