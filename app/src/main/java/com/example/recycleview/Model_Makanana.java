package com.example.recycleview;

public class Model_Makanana {
    private String namaMakanan;
    private String deskripsi;
    private int hargaMakanan;
    private int imageResId;

    public Model_Makanana(String namaMakanan,String deskripsi,int hargaMakanan,int imageResId){
        this.namaMakanan = namaMakanan;
        this.deskripsi = deskripsi;
        this.hargaMakanan = hargaMakanan;
        this.imageResId = imageResId;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public  String getDeskripsi(){
        return  deskripsi;
    }
    public  int getHargaMakanan(){
        return  hargaMakanan;
    }
    public int getimageResId() {
        return imageResId;
    }
}

