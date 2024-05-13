package com.example.tugasday6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FashionAdapter fashionAdapter;
    private ArrayList<FashionModel> fashionModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recycleView);
        fashionAdapter = new FashionAdapter(fashionModel, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fashionAdapter);
    }

    private void getData(){
        fashionModel = new ArrayList<>();
        fashionModel.add(new FashionModel("Jenis Baju : Kemeja Polos", "Bahan : Katun", "Berwarna Hitam", "Harga : Rp350.000", R.drawable.baju1));
        fashionModel.add(new FashionModel("Jenis Baju : Kemeja Rompi", "Bahan : Katun", "Berwarna Putih Hitam", "Harga : Rp450.000", R.drawable.baju2));
        fashionModel.add(new FashionModel("Jenis Baju : Gamis", "Bahan : Katun", "Berwarna Abu-abu", "Harga : Rp550.000", R.drawable.baju3));
        fashionModel.add(new FashionModel("Jenis Baju : Kemeja Kantor", "Bahan : Katun", "Berwarna Coklat", "Harga : Rp400.000", R.drawable.baju4));
        fashionModel.add(new FashionModel("Jenis Baju : Kemeja Santai", "Bahan : Katun", "Berwarna Abu-abu", "Harga : Rp450.000", R.drawable.baju5));
        fashionModel.add(new FashionModel("Jenis Celana : Jeans", "Bahan : Katun", "Berwarna Hitam", "Harga : Rp450.000", R.drawable.celana1));
        fashionModel.add(new FashionModel("Jenis Celana : Bahan", "Bahan : Katun", "Berwarna Abu-abu", "Harga : Rp350.000", R.drawable.celana2));
        fashionModel.add(new FashionModel("Jenis Celana : Chino", "Bahan : Kapas", "Berwarna Orange", "Harga : Rp350.000", R.drawable.celana3));
        fashionModel.add(new FashionModel("Jenis Celana : Training Pendek", "Bahan : Polyester", "Berwarna Biru", "Harga : Rp200.000", R.drawable.celana4));
        fashionModel.add(new FashionModel("Jenis Celana : Training Panjang", "Bahan : Polyester", "Berwarna Hitam", "Harga : Rp350.000", R.drawable.celana5));
        fashionModel.add(new FashionModel("Jenis Jaket : Kulit", "Bahan : Kulit", "Berwarna Coklat", "Harga : Rp450.000", R.drawable.jaket1));
        fashionModel.add(new FashionModel("Jenis Jaket : Olahraga", "Bahan : Katun", "Berwarna Merah", "Harga : Rp250.000", R.drawable.jaket2));
        fashionModel.add(new FashionModel("Jenis Jaket : Hoodie", "Bahan : Wol", "Berwarna Hitam", "Harga : Rp300.000", R.drawable.jaket3));
        fashionModel.add(new FashionModel("Jenis Jaket : Hoodie", "Bahan : Wol", "Berwarna Merah", "Harga : Rp300.000", R.drawable.jaket4));
        fashionModel.add(new FashionModel("Jenis Jaket : Jeans", "Bahan : Denim", "Berwarna Abu-abu", "Harga : Rp350.000", R.drawable.jaket5));
    }
}