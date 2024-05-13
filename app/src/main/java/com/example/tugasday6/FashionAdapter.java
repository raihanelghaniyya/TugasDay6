package com.example.tugasday6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.ViewHolder> {
    private ArrayList<FashionModel> fashionModels;
    public Context context;
    public FashionAdapter(ArrayList<FashionModel> fashionModels, Context context) {
        this.fashionModels = fashionModels;
        this.context = context;
    }

    @NonNull
    @Override
    public FashionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_fashion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull FashionAdapter.ViewHolder holder, int position) {
        FashionModel target = fashionModels.get(position);
        holder.jenisFashion.setText(target.getJenis());
        holder.bahanFashion.setText(target.getBahan());
        holder.warnaFashion.setText(target.getWarna());
        holder.hargafashion.setText(target.getHarga());
        holder.gambarFashion.setImageResource(target.getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("jenis", target.getJenis());
                intent.putExtra("bahan", target.getBahan());
                intent.putExtra("warna", target.getWarna());
                intent.putExtra("harga", target.getHarga());
                intent.putExtra("gambar", target.getGambar());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fashionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jenisFashion, bahanFashion, warnaFashion, hargafashion;
        ImageView gambarFashion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jenisFashion = itemView.findViewById(R.id.txtJenisFashion);
            bahanFashion = itemView.findViewById(R.id.txtBahanFashion);
            warnaFashion = itemView.findViewById(R.id.txtWarnaFashion);
            hargafashion = itemView.findViewById(R.id.txtHargaFashion);
            gambarFashion = itemView.findViewById(R.id.imgGambarFashion);
        }
    }
}
