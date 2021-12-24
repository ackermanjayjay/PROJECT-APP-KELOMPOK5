package com.example.coba_firebase;

public class Barang
{
    private String namabarang;
    private String hargaBarang;
    private String unit;
    private String key;


    public Barang()
    {

    }

    public String getUnit() {

        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getBeli() {
        return hargaBarang;
    }

    public void setBeli(String beli) {
        this.hargaBarang = beli;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
public  String toString()
    {
        return " "+namabarang+"\n"+
                " "+hargaBarang+"\n"+
                " "+unit;
    }
    public Barang(String nbr,  String hbr,String nit) {
        namabarang = nbr;
        hargaBarang = hbr;
        unit=nit;
    }
}
