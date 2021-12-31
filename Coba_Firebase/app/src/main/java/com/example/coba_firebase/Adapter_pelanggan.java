package com.example.coba_firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_pelanggan extends RecyclerView.Adapter<Adapter_pelanggan.ViewHolder>
{
private ArrayList<Pelanggan>daftarPelanggan;
private Context context;

public Adapter_pelanggan(ArrayList<Pelanggan>pelanggans,Context ctx)
{
    daftarPelanggan = pelanggans;
    context =ctx;
}
class ViewHolder extends RecyclerView.ViewHolder
{
    TextView tv_Title;

    ViewHolder(View itemView) {
        super(itemView);
        tv_Title=(TextView)itemView.findViewById(R.id.tv_namapelanggan);

    }
}
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelanggan,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String nama = daftarPelanggan.get(position).getNama();

        holder.tv_Title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });
        holder.tv_Title.setText(nama);

    }
    @Override
    public int getItemCount() {
        return daftarPelanggan.size();
    }
}
