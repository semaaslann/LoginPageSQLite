package com.nexis.loginanimasyon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor extends RecyclerView.Adapter<MyrecycAdaptor.Myholder> {
    private ArrayList<Gonderi> gonderis;

    public MyrecycAdaptor(ArrayList<Gonderi> gonderis) {
        this.gonderis=gonderis;

    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gonderi_item,parent,false);

        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.adsoyad.setText(gonderis.get(position).getAdsoyad());
        holder.profil.setImageResource(gonderis.get(position).getProfil());
        holder.gonder.setImageResource(gonderis.get(position).getGonderi());

    }

    @Override
    public int getItemCount() {
        return gonderis.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        ImageView profil, gonder;
        TextView adsoyad;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            profil = itemView.findViewById(R.id.imageprofil);
            adsoyad = itemView.findViewById(R.id.txtadsoyad);
            gonder= itemView.findViewById(R.id.imagegonderi);
        }
    }
}
