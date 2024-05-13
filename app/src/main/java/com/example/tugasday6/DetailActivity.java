package com.example.tugasday6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String jenis, bahan, warna, harga;
    private int gambar;
    private ImageView imgDetail;
    private TextView txtDetailJenis, txtDetailBahan, txtDetailWarna, txtDetailHarga;
    private Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailJenis = findViewById(R.id.txtDetailJenis);
        txtDetailBahan = findViewById(R.id.txtDetailBahan);
        txtDetailWarna = findViewById(R.id.txtDetailWarna);
        txtDetailHarga = findViewById(R.id.txtDetailHarga);
        btnShare = findViewById(R.id.btnShare);

        jenis = getIntent().getStringExtra("jenis");
        bahan = getIntent().getStringExtra("bahan");
        warna = getIntent().getStringExtra("warna");
        harga = getIntent().getStringExtra("harga");
        gambar = getIntent().getIntExtra("gambar", 0);

        txtDetailJenis.setText(jenis);
        txtDetailBahan.setText(bahan);
        txtDetailWarna.setText(warna);
        txtDetailHarga.setText(harga);
        imgDetail.setImageResource(gambar);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        shareImageAndText();
    }

    private void shareImageAndText() {
        Bitmap bitmap = ((BitmapDrawable) imgDetail.getDrawable()).getBitmap();
        String text = txtDetailJenis.getText().toString() + "\n" +
                txtDetailBahan.getText().toString() + "\n" +
                txtDetailWarna.getText().toString() + "\n" +
                txtDetailHarga.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");

        Uri uri = getImageUri(this, bitmap);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Share melalui"));
        } else {
            Toast.makeText(this, "Tidak ada aplikasi yang dapat menangani intent ini", Toast.LENGTH_SHORT).show();
        }
    }
    private Uri getImageUri(Context context, Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }
}