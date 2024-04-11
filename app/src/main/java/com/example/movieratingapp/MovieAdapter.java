package com.example.movieratingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private List<Movies> moviesList;

    public MovieAdapter(Context context,List<Movies> movies){
        this.context=context;
        this.moviesList=movies;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
           return  new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movies movie=moviesList.get(position);
        holder.rating.setText(String.valueOf(movie.getRating()));
        holder.title.setText(movie.getTitle().toString());
        holder.type.setText(movie.getType().toString());
        Glide.with(context).load(movie.getPoster()).into(holder.imV);

        holder.cbn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context,DetailedActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("title",movie.getTitle());
                        bundle.putString("Overview",movie.getOverview());
                        bundle.putDouble("rating",movie.getRating());
                        bundle.putString("poster",movie.getPoster());

                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }

                }
        );
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MovieHolder extends  RecyclerView.ViewHolder {
        ImageView imV;
        Button cbn;

        TextView title,rating,type;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imV=itemView.findViewById(R.id.movieImage);
            title=itemView.findViewById(R.id.movieName);
            rating=itemView.findViewById(R.id.movieRatings);
            type=itemView.findViewById(R.id.movieType);
            cbn=itemView.findViewById(R.id.chekOutBtn);
        }
    }
}
