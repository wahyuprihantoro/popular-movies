package id.prihantoro.popularmovies.util;

import java.util.HashMap;

/**
 * Created by wahyu on 10 July 2017.
 */

public class Constant {
    public static final String API_KEY = "6922802189611c62c2869c2fc70ca89f";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final HashMap<Integer, String> GENRES = new HashMap<Integer, String>() {{
        {
            put(28, "Action");
            put(12, "Adventure");
            put(16, "Animation");
            put(35, "Comedy");
            put(80, "Crime");
            put(99, "Documentary");
            put(18, "Drama");
            put(10751, "Family");
            put(14, "Fantasy");
            put(36, "History");
            put(27, "Horror");
            put(10402, "Music");
            put(9648, "Mystery");
            put(10749, "Romance");
            put(878, "Science Fiction");
            put(10770, "TV Movie");
            put(53, "Thriller");
            put(10752, "War");
            put(37, "TV Western");
        }
    }};
}
