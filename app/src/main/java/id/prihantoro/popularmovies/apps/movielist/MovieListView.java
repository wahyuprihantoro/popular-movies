package id.prihantoro.popularmovies.apps.movielist;

import java.util.List;

import id.prihantoro.popularmovies.model.Movie;

/**
 * Created by wahyu on 10 July 2017.
 */

public interface MovieListView {
    void showListMovies(List<Movie> movies);

    void showError(String s);
}
