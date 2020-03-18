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

public class ListaBuscarVehiculoRecyclerViewAdapter extends RecyclerView.Adapter<ListaBuscarVehiculoRecyclerViewAdapter.BuscarVehiculo_Holder>{

    private List<String> tractoras;
    private List<String> cisternas;
    private int layout;
    private OnItemClickListener itemClickListener;

    public ListaBuscarVehiculoRecyclerViewAdapter(List<String> tractoras, List<String> cisternas, List<Integer> bloqueoTractoras, List<Integer> bloqueoCisternas, int layout, OnItemClickListener listener){
        this.tractoras = tractoras;
        this.cisternas = cisternas;
        this.layout = layout;
        this.itemClickListener = listener;
    }


    @NonNull
    @Override
    public BuscarVehiculo_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultado_buscar_vehiculos, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vh.setLayoutParams(layoutParams);
        return new BuscarVehiculo_Holder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull BuscarVehiculo_Holder holder, int position) {
        String tractora;
        String cisterna;
        int bloqueoTractora=0;
        int bloqueoCisterna=0;

        tractora = tractoras.get(position);
        cisterna = cisternas.get(position);

        holder.bind(tractora, cisterna, bloqueoTractora, bloqueoCisterna, itemClickListener);

    }

    @Override
    public int getItemCount() {
        return tractoras.size();
    }

    public class BuscarVehiculo_Holder extends RecyclerView.ViewHolder {
        TextView tvTractora, tvCisterna;
        ImageView ivTractora, ivCisterna, ivBloqueoTractora, ivBloqueoCisterna, ivTractoraInspeccionada, ivCisternaInspeccionada;

        public BuscarVehiculo_Holder(@NonNull View itemView) {
            super(itemView);
            tvTractora = itemView.findViewById(R.id.tvTractora);
            tvCisterna = itemView.findViewById(R.id.tvCisterna);
            ivTractora = itemView.findViewById(R.id.ivTractora);
            ivCisterna = itemView.findViewById(R.id.ivCisterna);
            ivTractoraInspeccionada = itemView.findViewById(R.id.ivTractoraInspeccionada);
            ivCisternaInspeccionada = itemView.findViewById(R.id.ivCisternaInspeccionada);

        }

        public void bind(final String tractora, final String cisterna, final int bloqueoTractora, final int bloqueoCisterna, final OnItemClickListener listener){
            this.tvTractora.setText(tractora);
            this.tvCisterna.setText(cisterna);
            this.ivTractoraInspeccionada.setVisibility(View.GONE);
            this.ivCisternaInspeccionada.setVisibility(View.GONE);

            switch (bloqueoTractora){
                case 0:
                    this.ivBloqueoTractora.setVisibility(View.GONE);
                    break;
                case 1:
                    this.ivBloqueoTractora.setImageResource(R.drawable.ic_checked);
                    break;
                case 2:
                    this.ivBloqueoTractora.setImageResource(R.drawable.ic_ban);
                    break;
            }

            switch (bloqueoCisterna){
                case 0:
                    this.ivBloqueoCisterna.setVisibility(View.GONE);
                    break;
                case 1:
                    this.ivBloqueoCisterna.setImageResource(R.drawable.ic_checked);
                    break;
                case 2:
                    this.ivBloqueoCisterna.setImageResource(R.drawable.ic_ban);
                    break;
            }

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(tractora, cisterna, bloqueoTractora, bloqueoCisterna, getAdapterPosition());
                }
            });

        }
    }


    public interface OnItemClickListener{
        void onItemClick(String tractora, String cisterna, int bloqueoTractora, int bloqueoCisterna, int position);
    }


}
