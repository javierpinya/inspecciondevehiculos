package com.javierpinya.inspecciondevehiculos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;

import java.util.List;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.VehiculosAdapter_Holder>{


    private List<String> matT;
    private List<String> matC;
    private int layout;
    private OnItemClickListener itemClickListener;

    public VehiculosAdapter(List<String> matT, List<String> matC, int layout, OnItemClickListener listener){
        this.matT = matT;
        this.matC = matC;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public VehiculosAdapter_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent,false);
        VehiculosAdapter_Holder vh = new VehiculosAdapter_Holder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculosAdapter_Holder holder, int position) {

        holder.bind(matT.get(position), matC.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return matT.size();
    }

    public static class VehiculosAdapter_Holder extends RecyclerView.ViewHolder {
        public TextView tvTractora, tvCisterna;
        public ImageView ivTractora, ivCisterna;

        public VehiculosAdapter_Holder(@NonNull View itemView) {
            super(itemView);


            this.tvTractora = itemView.findViewById(R.id.tvTractora);
            this.tvCisterna = itemView.findViewById(R.id.tvCisterna);
            this.ivTractora = itemView.findViewById(R.id.ivTractora);
            this.ivCisterna = itemView.findViewById(R.id.ivCisterna);
        }


        public void bind(final String matT, final String matC, final OnItemClickListener listener){

            this.tvTractora.setText(matT);
            this.tvCisterna.setText(matC);
            this.ivCisterna.setImageResource(R.drawable.ic_oil_tank);
            this.ivTractora.setImageResource(R.drawable.ic_frontal_truck);  //Habría que cambiarlo en el futuro, discriminando entre tractora y rígido

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(matT,matC,getAdapterPosition());
                }
            });



        }
    }

    public interface OnItemClickListener{
        void onItemClick(String matT, String matC,int position);
    }
}


