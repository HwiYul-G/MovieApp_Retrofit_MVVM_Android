package com.example.movieapp_retrofit_mvvm_android.model.data

data class Movies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
