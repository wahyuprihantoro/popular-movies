package id.prihantoro.popularmovies.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import id.prihantoro.popularmovies.apps.movielist.MovieListPresenter;
import id.prihantoro.popularmovies.dagger.module.NetworkModule;
import id.prihantoro.popularmovies.network.service.MovieService;

/**
 * Created by wahyu on 14 June 2017.
 */

@Component(modules = NetworkModule.class)
@Singleton
public interface PresenterComponent {
    MovieService getMovieService();

    void inject(MovieListPresenter fragment);
}
