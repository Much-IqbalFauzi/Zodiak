package com.example.zodiak;


import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class dataControl extends RecyclerView.Adapter<dataControl.ListViewHolder>{
    private ArrayList<dataM> listdataM;
    public dataControl(ArrayList<dataM> list){
        this.listdataM=list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_horoskop, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataControl.ListViewHolder holder, int position) {
        final dataM zodiak = listdataM.get(position);

        Glide.with(holder.itemView.getContext())
                .load(zodiak.getImg())
                .apply(new RequestOptions().override(150, 150))
                .into(holder.viewPhoto);
        holder.viewNama.setText(zodiak.getNama());
        holder.viewTgl.setText(zodiak.getTgl());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lengkap = new Intent(view.getContext(), detail_horoskop.class);
                lengkap.putExtra("jeneng", zodiak.getNama());
                lengkap.putExtra("tanggal", zodiak.getTgl());
                lengkap.putExtra("information", zodiak.getKet());
                lengkap.putExtra("foto", zodiak.getImg());
                view.getContext().startActivity(lengkap);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdataM.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView viewPhoto;
        TextView viewNama, viewTgl;
        RelativeLayout layout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPhoto = itemView.findViewById(R.id.view_photo);
            viewNama = itemView.findViewById(R.id.view_nama_zodiak);
            viewTgl = itemView.findViewById(R.id.view_tanggal);
            layout = itemView.findViewById(R.id.daftar_horoskop);
        }
    }


}
