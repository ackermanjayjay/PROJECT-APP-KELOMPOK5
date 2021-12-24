package com.example.coba_firebase;

public class Pelanggan
{
    private String nama;
    private String alamat;
    private String key;

    public Pelanggan() {



    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+alamat +"\n";
    }

    public Pelanggan(String nm, String almt){
        nama = nm;
        alamat = almt;
    }
}
