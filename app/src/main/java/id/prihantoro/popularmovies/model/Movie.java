package id.prihantoro.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static id.prihantoro.popularmovies.util.Constant.GENRES;

/**
 * Created by wahyu on 10 July 2017.
 */

public class Movie implements Serializable{
    @SerializedName("vote_count")
    public int voteCount;
    @SerializedName("id")
    public int id;
    @SerializedName("video")
    public boolean video;
    @SerializedName("vote_average")
    public float voteAverage;
    @SerializedName("title")
    public String title;
    @SerializedName("popularity")
    public float popularity;
    @SerializedName("poster_path")
    public String posterPath;
    @SerializedName("original_language")
    public String originalLanguage;
    @SerializedName("original_title")
    public String originalTitle;
    @SerializedName("genre_ids")
    public List<Integer> genreIds = new ArrayList<>();
    @SerializedName("backdrop_path")
    public String backdropPath;
    @SerializedName("adult")
    public boolean adult;
    @SerializedName("overview")
    public String overview;
    @SerializedName("release_date")
    public String releaseDate;

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w500" + posterPath;
    }

    public String getGenres() {
        String genre = "";
        for (int i = 0; i < genreIds.size(); i++) {
            genre += GENRES.get(genreIds.get(i)) + (i < genreIds.size() - 1 ? ", " : "");
        }

        return genre;
    }
}
