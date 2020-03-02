package com.example.latihanfragmen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Heroes> heroesList = new ArrayList<>();

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(ArrayList<Heroes> heroesList) {
        this.heroesList = heroesList;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, int position) {
        final int index = position;
        holder.tv_Name.setText(getHeroesList().get(index).getHeroName());
        holder.tv_Content.setText(getHeroesList().get(index).getHeroContent());
        Glide.with(context).load(getHeroesList().get(index).getHeroImage()).into(holder.ivHero);

        holder.tv_Content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name",getHeroesList().get(index).getHeroName());
                intent.putExtra("content",getHeroesList().get(index).getHeroContent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivHero;
        private TextView tv_Name, tv_Content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_iv);
            tv_Name = itemView.findViewById(R.id.itemhero_tv_name);
            tv_Content = itemView.findViewById(R.id.itemhero_tv_content);
        }
    }
}

