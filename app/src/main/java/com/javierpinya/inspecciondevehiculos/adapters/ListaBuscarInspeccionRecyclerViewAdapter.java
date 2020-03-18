package com.javierpinya.inspecciondevehiculos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;

import java.util.List;

public class ListaBuscarInspeccionRecyclerViewAdapter extends RecyclerView.Adapter<ListaBuscarInspeccionRecyclerViewAdapter.BuscarInspeccion_Holder> {

    private List<String> tractora;
    private List<String> cisterna;
    private List<String> ia;
    private List<String> transportista;
    private int layout;
    private OnItemClickListener listener;


    public ListaBuscarInspeccionRecyclerViewAdapter(List<String> tractora, List<String> cisterna, List<String> ia, List<String> tranportista, int layout, OnItemClickListener listener){
        this.tractora = tractora;
        this.cisterna = cisterna;
        this.ia = ia;
        this.transportista = tranportista;
        this.layout = layout;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BuscarInspeccion_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultado_buscar_inspeccion, parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vh.setLayoutParams(layoutParams);
        return new BuscarInspeccion_Holder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull BuscarInspeccion_Holder holder, int position) {
        String tr;
        String cis;
        String inst;
        String trans;

        tr = tractora.get(position);
        cis = cisterna.get(position);
//        insp = inspeccion.get(position);
        inst = ia.get(position);
        trans = transportista.get(position);

        holder.bind(tr,cis,inst,trans,listener);

    }

    @Override
    public int getItemCount() {
        return tractora.size();
    }

    public class BuscarInspeccion_Holder extends RecyclerView.ViewHolder{
        TextView tvinspeccion,tvTractora, tvCisterna, tvFechaInspeccion, tvCodTrans,tvInstalacion,tvDesTrans,tvConductor;

        public BuscarInspeccion_Holder(@NonNull View itemView) {
            super(itemView);
            tvTractora = itemView.findViewById(R.id.tvTractoraInsp);
            tvCisterna = itemView.findViewById(R.id.tvCisternaInsp);
            tvCodTrans = itemView.findViewById(R.id.tvCodTrans);
            tvInstalacion = itemView.findViewById(R.id.tvInstalacion);
        }

        public void bind(String tractora, String cisterna, String ia, String trans, OnItemClickListener listener){
            tvTractora.setText(tractora);
            tvCisterna.setText(cisterna);
            tvInstalacion.setText(ia);
            tvCodTrans.setText(trans);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(tractora,cisterna,ia,trans, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(String tractora, String cisterna, String ia, String trans, int position);
    }
}
