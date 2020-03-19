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

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {

    private List<TplcprtEntity> tags_list;
    private int layout;


    public TagsAdapter(List<TplcprtEntity> tags_list, int layout){
        this.tags_list = tags_list;
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
        holder.bind(tags_list.get(position));
    }


    @Override
    public int getItemCount() {
        return tags_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView numcomp,matricula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numcomp = itemView.findViewById(R.id.compartimento1_tag);
            matricula = itemView.findViewById(R.id.matricula1_tag);
        }

        public void bind(final TplcprtEntity tags){
            this.numcomp.setText(String.valueOf(tags_list.get(getAdapterPosition()).getCod_compartimento()));
            this.matricula.setText(tags_list.get(getAdapterPosition()).getMatricula());
        }
    }
}
