package id.prihantoro.popularmovies.dagger.module;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.prihantoro.popularmovies.network.service.MovieService;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static id.prihantoro.popularmovies.util.Constant.API_KEY;
import static id.prihantoro.popularmovies.util.Constant.BASE_URL;


/**
 * Created by wahyu on 13 June 2017.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl url = original.url()
                        .newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build();
                Request request = original.newBuilder()
                        .url(url)
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        return client;
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public MovieService getMovieService(Retrofit retrofit) {
        return retrofit.create(MovieService.class);
    }
}
