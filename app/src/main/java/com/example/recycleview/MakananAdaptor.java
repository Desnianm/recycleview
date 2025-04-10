package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MakananAdaptor extends RecyclerView.Adapter<MakananAdaptor.ViewHolder> {
    private ArrayList<Model_Makanana> listMakanan;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Model_Makanana makanan);
    }

    public MakananAdaptor(ArrayList<Model_Makanana> listMakanan, OnItemClickListener listener) {
        this.listMakanan = listMakanan;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model_Makanana makanan = listMakanan.get(position);
        holder.tvNamaMakanan.setText(makanan.getNamaMakanan());
        holder.tvDeskripsi.setText(makanan.getDeskripsi());
        holder.tvHargaMakanan.setText("Rp " + makanan.getHargaMakanan());
        holder.imgMakanan.setImageResource(makanan.getimageResId());

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(makanan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMakanan, tvDeskripsi, tvHargaMakanan;
        ImageView imgMakanan;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            tvHargaMakanan = itemView.findViewById(R.id.tvHargaMakanan);
            imgMakanan = itemView.findViewById(R.id.imgMakanan);
        }
    }
}
