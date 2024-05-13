package com.example.tugasday6;

public class FashionModel {
    public String jenis;
    public String bahan;
    public String warna;
    public String harga;
    public int gambar;

    public FashionModel(String jenis, String bahan, String warna, String harga, int gambar) {
        this.jenis = jenis;
        this.bahan = bahan;
        this.warna = warna;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
