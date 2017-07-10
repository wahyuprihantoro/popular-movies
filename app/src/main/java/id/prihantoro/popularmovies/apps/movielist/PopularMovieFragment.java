package id.prihantoro.popularmovies.apps.movielist;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import id.prihantoro.popularmovies.R;
import id.prihantoro.popularmovies.apps.adapter.MovieListAdapter;
import id.prihantoro.popularmovies.model.Movie;


/**
 * Created by wahyu on 10 July 2017.
 */

@EFragment(R.layout.fragment_popular_movie)
public class PopularMovieFragment extends Fragment implements MovieListView {
    private static final int PAGE_SIZE = 20;
    @ViewById
    RecyclerView rv;


    MovieListAdapter adapter;
    List<Movie> movies;
    GridLayoutManager layoutManager;

    MovieListPresenter presenter;

    int currentpage;
    boolean isLoading;

    RecyclerView.OnScrollListener listerner = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

            if (!isLoading) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    @AfterViews
    void init() {
        presenter = new MovieListPresenter(this);

        isLoading = false;
        movies = new ArrayList<>();
        adapter = new MovieListAdapter(getContext(), movies);
        layoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
        rv.addOnScrollListener(listerner);

        presenter.getPopularMovies(1);
        currentpage = 1;
    }

    private void loadMoreItems() {
        isLoading = true;
        Toast.makeText(getContext(), "Load new page!", Toast.LENGTH_SHORT).show();
        presenter.getPopularMovies(currentpage);
    }

    @Override
    public void showListMovies(List<Movie> movies) {
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();
        currentpage++;
        isLoading = false;
    }

    @Override
    public void showError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        if (currentpage > 1) {
            currentpage--;
        }
        isLoading = false;
    }
}
