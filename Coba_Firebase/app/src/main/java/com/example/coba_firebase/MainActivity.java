package com.example.coba_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button login,register;
EditText nama,pass_ku;
String admin="Reza";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama=findViewById(R.id.txt_nama);
        pass_ku=findViewById(R.id.txt_pass);
        login=findViewById(R.id.btn_login);
        register=findViewById(R.id.btn_regsiter);
        getSupportActionBar().setTitle("Halaman Login");

        register.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                halamanRegister();
            }
        }));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Control khusus Admin login
                    if(nama.getText().toString().equals("Reza")) {
                        Intent admin = new Intent(MainActivity.this, Halaman_admin.class);
                        admin.putExtra("Nama", nama.getText().toString());
                        startActivity(admin);
                    }
                 else
                    {
                    halamanhome();
                }
            }
        });
    }
    public void halamanRegister()
    {
        Intent pindah_register = new Intent(MainActivity.this, Halaman_regis.class);
        startActivity(pindah_register);
    }
    public void halamanhome()
    {
        if(nama.length()==0 )
        {
            nama.requestFocus();
            nama.setError("Masukkan nama anda");


        }
        else if(pass_ku.length()==0)
        {
            pass_ku.requestFocus();
            pass_ku.setError("Masukkan Password anda");
        }
        else
        {
            Intent home = new Intent(MainActivity.this, Halaman_home.class);
            home.putExtra("Nama", nama.getText().toString());
            startActivity(home);


        }

        }
}