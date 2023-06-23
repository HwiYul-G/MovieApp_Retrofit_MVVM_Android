package com.example.movieapp_retrofit_mvvm_android.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp_retrofit_mvvm_android.model.data.Result
import com.example.movieapp_retrofit_mvvm_android.databinding.MovieLayoutBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    // Retrofit으로 받아온 영화 list 정보를 담을 배열
    private var movieList = ArrayList<Result>()
    fun setMovieList(movieList : List<Result>){
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {}

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${movieList[position].poster_path}")
            .into(holder.binding.movieImage)

        holder.binding.movieName.text = movieList[position].title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}