package com.example.coba_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Halaman_transaksi extends AppCompatActivity {
    TextView totalTelur
            ,totalMinyak
            ,totalTransaksi
            ,telorku
            ,minyakku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_transaksi);

                totalTelur=(TextView)findViewById(R.id.hasil_barang1);
        telorku=(TextView)findViewById(R.id.hasil_telor);

//        Textview minyak
        minyakku=(TextView)findViewById(R.id.hasil_minyak);
        totalMinyak=(TextView)findViewById(R.id.hasil_barang2);

        totalTransaksi=(TextView)findViewById(R.id.total_harga);
        //        Untuk judul atas
        getSupportActionBar().setTitle("Halaman Transaksi");

//        Hasil Beli Telur
        int dapatTelur=getIntent().getExtras().getInt("HasilTelur");
        String telurku=getIntent().getExtras().getString("");
        totalTelur.setText("Rp."+Integer.toString(dapatTelur));

//        Hasil Beli Minyak
        int dapatMinyak=getIntent().getExtras().getInt("HasilMinyak");
        String minyakku=getIntent().getExtras().getString("");
        totalMinyak.setText("Rp."+Integer.toString(dapatMinyak));

        int total= dapatMinyak+dapatTelur;
        totalTransaksi.setText("Rp."+Integer.toString(total));

    }
    }
