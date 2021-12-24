package com.example.coba_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Halaman_regis extends AppCompatActivity {
    private DatabaseReference database;

    private Button btSubmit;
    private EditText etNama;
    private EditText etAlamat;
//    private EditText etHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_regis);
        etNama = (EditText) findViewById(R.id.et_namabarang);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        btSubmit = (Button) findViewById(R.id.bt_simpan);

        database = FirebaseDatabase.getInstance().getReference();
//        getSupportActionBar().setTitle("Halaman Register");

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(etNama.getText().toString()) && !isEmpty(etAlamat.getText().toString()))
                    submitBarang(new Pelanggan(etNama.getText().toString(), etAlamat.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.bt_simpan), "Data barang tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNama.getWindowToken(), 0);
            }
        });

    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    private void updateBarang(Pelanggan pelanggan) {
        // kodingan untuk next tutorial ya :p
    }

    private void submitBarang(Pelanggan pelanggan) {

        database.child("pelanggan").push().setValue(pelanggan).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etAlamat.setText("");
//                etHarga.setText("");
                Snackbar.make(findViewById(R.id.bt_simpan), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
                HalamanBeli();
            }
        });
    }
    public void HalamanBeli()
    {
        Intent pindah = new Intent(Halaman_regis.this,Halaman_beli.class);
        startActivity(pindah);
    }
    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, Halaman_regis.class);
//        MainActivity.this, Halaman_admin.class
    }

    }
