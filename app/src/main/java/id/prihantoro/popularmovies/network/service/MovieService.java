package id.prihantoro.popularmovies.network.service;

import id.prihantoro.popularmovies.network.response.ListMovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wahyu on 10 July 2017.
 */

public interface MovieService {
    @GET("movie/popular")
    Call<ListMovieResponse> getPopularMovies(@Query("page") int page);

    @GET("movie/top_rated ")
    Call<ListMovieResponse> getTopRatedMovies(@Query("page") int page);
}
