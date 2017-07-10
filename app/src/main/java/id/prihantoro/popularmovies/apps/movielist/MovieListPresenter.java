package id.prihantoro.popularmovies.apps.movielist;

import java.util.List;

import javax.inject.Inject;

import id.prihantoro.popularmovies.dagger.component.DaggerPresenterComponent;
import id.prihantoro.popularmovies.model.Movie;
import id.prihantoro.popularmovies.network.response.ListMovieResponse;
import id.prihantoro.popularmovies.network.service.MovieService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wahyu on 10 July 2017.
 */

public class MovieListPresenter {
    @Inject
    MovieService service;

    MovieListView view;

    public MovieListPresenter(MovieListView view) {
        this.view = view;
        DaggerPresenterComponent.builder().build().inject(this);
    }

    public void getPopularMovies(int page) {
        service.getPopularMovies(page).enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().results;
                    view.showListMovies(movies);
                } else {
                    view.showError("Something wrong was occured!");
                }
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                view.showError("Something wrong was occured!");
            }
        });
    }

    public void getTopRatedMovies(int page) {
        service.getTopRatedMovies(page).enqueue(new Callback<ListMovieResponse>() {
            @Override
            public void onResponse(Call<ListMovieResponse> call, Response<ListMovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().results;
                    view.showListMovies(movies);
                } else {
                    view.showError("Something wrong was occured!");
                }
            }

            @Override
            public void onFailure(Call<ListMovieResponse> call, Throwable t) {
                view.showError("Something wrong was occured!");
            }
        });
    }
}
