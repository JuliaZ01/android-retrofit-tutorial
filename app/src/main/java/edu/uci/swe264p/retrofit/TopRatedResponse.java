package edu.uci.swe264p.retrofit;
import java.util.*;
import com.google.gson.annotations.SerializedName;

public class TopRatedResponse {
    @SerializedName("results")
    List<Movie> movies;

    public TopRatedResponse(List<Movie> m){
        this.movies = m;
    }
    public List<Movie> getMovies() {
        return movies;
    }
//    @SerializedName("vote_average")
//    private Float voteAverage;
//    @SerializedName("poster_path")
//    private String posterPath;
//    @SerializedName("title")
//    private String title;
//    @SerializedName("release_date")
//    private String releaseDate;
//    @SerializedName("overview")
//    private String overview;
//
//    public TopRatedResponse(Float voteAverage, String posterPath, String title, String releaseDate, String overview) {
//        this.voteAverage = voteAverage;
//        this.posterPath = posterPath;
//        this.title = title;
//        this.releaseDate = releaseDate;
//        this.overview = overview;
//    }
//
//    public Float getVoteAverage() {
//        return voteAverage;
//    }
//
//    public String getPosterPath() {
//        return posterPath;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public String getOverview() {
//        return overview;
//    }
}
