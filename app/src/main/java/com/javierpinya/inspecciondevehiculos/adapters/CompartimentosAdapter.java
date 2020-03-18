package com.javierpinya.inspecciondevehiculos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.TplcprtEntity;

import java.util.List;

public class CompartimentosAdapter extends RecyclerView.Adapter<CompartimentosAdapter.ViewHolder> {

    private List<TplcprtEntity> compartimentos_list;
    private int layout;


    public CompartimentosAdapter(List<TplcprtEntity> compartimentos_list, int layout){
        this.compartimentos_list = compartimentos_list;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(compartimentos_list.get(position));
    }


    @Override
    public int getItemCount() {
        return compartimentos_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView numcomp,capacidad,tag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numcomp = itemView.findViewById(R.id.comp1);
            capacidad = itemView.findViewById(R.id.capacidad1);
            tag = itemView.findViewById(R.id.tag1);
        }

        public void bind(final TplcprtEntity compartimentos){
            this.numcomp.setText(String.valueOf(compartimentos_list.get(getAdapterPosition()).getCod_compartimento()));
            this.capacidad.setText(String.valueOf(compartimentos_list.get(getAdapterPosition()).getCan_capacidad()));
            this.tag.setText(compartimentos_list.get(getAdapterPosition()).getCod_tag_cprt());
        }
    }
}
