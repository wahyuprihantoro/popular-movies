package id.prihantoro.popularmovies.apps.moviedetail;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.popularmovies.R;
import id.prihantoro.popularmovies.model.Movie;

/**
 * Created by wahyu on 10 July 2017.
 */

@EActivity(R.layout.activity_movie_detail)
public class MovieDetailActivity extends AppCompatActivity {
    @ViewById
    ImageView image;
    @ViewById
    Toolbar toolbar;
    @ViewById
    TextView synopsis;
    @ViewById
    TextView vote;

    @Extra
    Movie movie;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(movie.title);
        Glide.with(this).load(movie.getPosterPath()).into(image);
        synopsis.setText(movie.overview);
        String voteStr = movie.voteAverage + "";
        vote.setText(voteStr);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
