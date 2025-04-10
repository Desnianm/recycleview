package com.example.recycleview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetailMakanan extends AppCompatActivity {
    TextView tvNamaMakananDetail;
    TextView tvHargaMakananDetail;
    TextView tvDeskripsiMakanan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_makanan);

        tvNamaMakananDetail = findViewById(R.id.tvNamaMakananDetail);
        tvHargaMakananDetail = findViewById(R.id.tvHargaMakananDetail);
        ImageView gambarDetail = findViewById(R.id.gambarDetail);
        tvDeskripsiMakanan = findViewById(R.id.tvDeskripsiMakanan);


        // Terima data dari intent
        Intent intent = getIntent();
        String nama = intent.getStringExtra("namaMakanan");
        int harga = intent.getIntExtra("hargaMakanan", 0); // Ambil sebagai Int
        int img = intent.getIntExtra("gambar", 0);
        String deskripsi = intent.getStringExtra("deskripsiMakanan");

        // Set data ke tampilan
        tvNamaMakananDetail.setText(nama);
        tvHargaMakananDetail.setText("Rp " + harga); // Tambahkan "Rp " biar jelas
        gambarDetail.setImageResource(img);
        tvDeskripsiMakanan.setText(deskripsi);
    }
}