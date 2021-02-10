package edu.uci.swe264p.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "f1f317baeb7d3657d9c487acd7f4a308";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        recyclerView = findViewById(R.id.rvMovieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connect();

    }

    private void connect() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);


        Call<TopRatedResponse> call = movieApiService.getTopMovie(API_KEY);
        call.enqueue(new Callback<TopRatedResponse>() {
            @Override
            public void onResponse(Call<TopRatedResponse> call, Response<TopRatedResponse> response) {
//                int[] ids = {R.id.txtTitle, R.id.txtReleaseDate, R.id.txtPoster,
//                        R.id.txtVote, R.id.txtOverview};
                List<Movie> m = response.body().getMovies();
                List<List<String>> movies = new ArrayList<>();
                for(Movie t: m){
                    movies.add(
                            Arrays.asList(
                                    t.getTitle(),
                                    t.getReleaseDate(),
                                    t.getPosterPath(),
                                    t.getVoteAverage().toString(),
                                    t.getOverview()
                            )
                    );
                }
                recyclerView.setAdapter(new MovieListAdapter(movies));
            }
            @Override
            public void onFailure(Call<TopRatedResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }
}
