package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MakananAdaptor.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.tvNamaMakanan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Model_Makanana> listMakanan = new ArrayList<>();
        listMakanan.add(new Model_Makanana("Ayam Goreng", "Gurih dan renyah", 15000, R.drawable.ayam_goreng));
        listMakanan.add(new Model_Makanana("Nasi Goreng", "Pedas dan nikmat", 12000, R.drawable.nasi_goreng));
        listMakanan.add(new Model_Makanana("Bakso", "Kenyal dan lezat", 10000, R.drawable.bakso));
        listMakanan.add(new Model_Makanana("Bubur Ayam", "Gurih dan lumer", 10000, R.drawable.bubur_ayam));
        listMakanan.add(new Model_Makanana("Mie Goreng", "Pedas dan nikmat", 12000, R.drawable.mie_goreng));
        listMakanan.add(new Model_Makanana("Mie Ayam", "Kenyal dan gurih", 9000,R.drawable.mie_ayam));
        listMakanan.add(new Model_Makanana("Burger", "Gurih dan lembut", 25000,R.drawable.burger));
        listMakanan.add(new Model_Makanana("Pizza", "Kenyal dan nikmat", 50000,R.drawable.pizza));
        listMakanan.add(new Model_Makanana("Kentang Goreng", "Lembut dan asin", 10000,R.drawable.kentang_goreng));
        listMakanan.add(new Model_Makanana("Lele Goreng", "Gurih dan renyah", 15000,R.drawable.lele_goreng));

        MakananAdaptor makananAdaptor = new MakananAdaptor(listMakanan, this);
        recyclerView.setAdapter(makananAdaptor);
    }


    @Override
    public void onItemClick(Model_Makanana modelmakanana) {
        Toast.makeText(this, modelmakanana.getNamaMakanan(), Toast.LENGTH_SHORT).show();
        Intent in = new Intent(MainActivity.this, DetailMakanan.class);

        in.putExtra("namaMakanan",modelmakanana.getNamaMakanan());
        in.putExtra("hargaMakanan",modelmakanana.getHargaMakanan());
        in.putExtra("gambar",modelmakanana.getimageResId());
        in.putExtra("deskripsiMakanan", modelmakanana.getDeskripsi());
        startActivity(in);
    }
}

