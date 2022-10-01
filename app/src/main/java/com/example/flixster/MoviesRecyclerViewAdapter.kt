package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class MoviesRecyclerViewAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener? )
    : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>(){

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<TextView>(R.id.movie_title) as TextView
        val mMovieOverview: TextView = mView.findViewById<TextView>(R.id.movie_overview) as TextView
        val mMovieImage: ImageView = mView.findViewById<ImageView>(R.id.movie_image) as ImageView

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.fragment_movie, parent, false)
        // Return a new holder instance
        return MovieViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // Get the data model based on position
        val movie = movies[position]

        // Set item views based on your views and data model
        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieOverview.text = movie.overview

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/"+movie.movieImageUrl)
            .override(133,200)
            .placeholder(R.drawable.movie_placeholder)
            .error(R.drawable.movie_placeholder)
            .centerInside()
            .into(holder.mMovieImage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }


}