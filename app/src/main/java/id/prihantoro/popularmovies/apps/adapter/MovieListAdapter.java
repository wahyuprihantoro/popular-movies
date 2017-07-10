package id.prihantoro.popularmovies.apps.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.prihantoro.popularmovies.R;
import id.prihantoro.popularmovies.apps.moviedetail.MovieDetailActivity_;
import id.prihantoro.popularmovies.model.Movie;

/**
 * Created by wahyu on 10 July 2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        CardView cv;
        TextView title, genre;

        public MovieViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }

        public void bind(final Movie movie) {
            Glide.with(context).load(movie.getPosterPath()).into(image);
            title.setText(movie.title);
            genre.setText(movie.getGenres());
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieDetailActivity_.intent(context).movie(movie).start();
                }
            });
        }
    }
}
