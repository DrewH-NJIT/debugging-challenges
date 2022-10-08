package com.codepath.debuggingchallenges.models

import android.util.Log
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList

class Movie(jsonObject: JSONObject) {
    val title: String = jsonObject.getString("title")
    val posterUrl: String = String.format("https://image.tmdb.org/t/p/w342/%s", jsonObject.getString("poster_path"))
    val rating: Double = jsonObject.getDouble("vote_average")

    companion object {
        fun fromJSONArray(jsonArray: JSONArray): ArrayList<Movie> {
            Log.d("Results", jsonArray.toString())
            val results = ArrayList<Movie>()
            for (i in 0 until jsonArray.length()) {
                try {
                    Log.d("Results", results.toString())
                    results.add(Movie(jsonArray.getJSONObject(i)))

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            Log.d("Results",  results.toString())
            return results
        }
    }
}