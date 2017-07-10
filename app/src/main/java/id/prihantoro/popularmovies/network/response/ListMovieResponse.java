package id.prihantoro.popularmovies.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import id.prihantoro.popularmovies.model.Movie;

/**
 * Created by wahyu on 10 July 2017.
 */

public class ListMovieResponse {
    @SerializedName("page")
    public int page;
    @SerializedName("total_results")
    public int totalResults;
    @SerializedName("total_pages")
    public int totalPages;
    @SerializedName("results")
    public List<Movie> results = new ArrayList<>();
}
