package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{
    private List<List<String>> mData;

    MovieListAdapter(List<List<String>> data) {
        this.mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvReleaseDate;
        TextView tvVote;
        TextView tvOverview;
        ImageView ivMovie;
        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvVote = itemView.findViewById(R.id.tvVote);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivMovie = itemView.findViewById(R.id.ivMovie);
        }
    }

    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MovieListAdapter.ViewHolder holder, int position) {
        List<String> movie = mData.get(position);
        holder.tvTitle.setText(movie.get(0));
        holder.tvReleaseDate.setText(movie.get(1));
        holder.tvVote.setText(movie.get(3));
        holder.tvOverview.setText(movie.get(4));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
