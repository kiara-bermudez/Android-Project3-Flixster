package com.example.flixster

import com.google.gson.annotations.SerializedName

/**
 * The Model for storing a single movie from the MovieDB API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */
class Movie {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null

    @JvmField
    @SerializedName("poster_path")
    var movieImageUrl: String? = null
}