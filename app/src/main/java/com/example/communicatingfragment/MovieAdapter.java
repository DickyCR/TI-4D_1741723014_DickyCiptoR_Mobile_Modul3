package com.example.communicatingfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.communicatingfragment.Interface.OnMovieClick;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.ViewHolder>{
    private List<MovieModel> listMovieModel;
    private FragmentManager fragmentManager;
    private Context mContext;
    OnMovieClick listener;

    public MovieAdapter(List<MovieModel> listMovieModel, FragmentManager fragmentManager, Context mContext, OnMovieClick listener) {
        this.listMovieModel = listMovieModel;
        this.fragmentManager = fragmentManager;
        this.mContext = mContext;
        this.listener = listener;
    }

    public void SetListModel(List<MovieModel> listMovieModel){
        this.listMovieModel = listMovieModel;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item_satuan,parent,false);
        ViewHolder mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MovieModel movieModel = listMovieModel.get(position);
        holder.tvJudul.setText(movieModel.getJudul());
        holder.tvRating.setText(mContext.getResources().getString(R.string.rating)
        +" : "+movieModel.getRatingScore());
        Glide.with(holder.itemView.getContext()).load(movieModel.getPoster()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(listMovieModel.get(holder.getAdapterPosition()),holder.getAdapterPosition());
            }
        });

    }


    @Override
    public int getItemCount() {
        return listMovieModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvJudul;
            private TextView tvRating;
            private ImageView imageView;

            public ViewHolder(@NonNull View itemView){
                super(itemView);
                tvJudul = itemView.findViewById(R.id.tvJudul);
                tvRating = itemView.findViewById(R.id.tvRating);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
