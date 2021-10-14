package com.example.retrofit_api

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofit_api.RecyclerAdapter.*

class RecyclerAdapter (private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var movieList : List<Movie> = listOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
        }


        override fun getItemCount(): Int {
        return movieList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.tvMovieName.text = movieList[position].login
                Glide.with(context).load(movieList[position].avatar_url)
                .apply(RequestOptions().centerCrop())
                .into(holder.image)
        }

        fun setMovieListItems(movieList: List<Movie>){
            this.movieList = movieList
            notifyDataSetChanged()
        }

       inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
            val tvMovieName: TextView = itemView.findViewById(R.id.login)
            val image: ImageView = itemView.findViewById(R.id.avatar_url)
        }


}