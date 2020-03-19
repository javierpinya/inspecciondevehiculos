package com.javierpinya.inspecciondevehiculos.fragments.menu;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.activities.BuscarInspeccionActivity;
import com.javierpinya.inspecciondevehiculos.activities.BuscarTodoActivity;
import com.javierpinya.inspecciondevehiculos.activities.BuscarVehiculoActivity;
import com.javierpinya.inspecciondevehiculos.activities.CabeceraInspeccionActivity;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.activities.SincronizarActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment{

    private ImageButton buscarCamion;
    private ImageButton buscarInspeccion;
    private ImageButton nuevaInspeccion;
    private ImageButton calculadora;
    private ImageButton sincronizar;
    private ImageView oleoducto;
    private ImageView buscarTodo;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_simple, container, false);

        buscarCamion = view.findViewById(R.id.imageBuscarCamion);
        buscarInspeccion = view.findViewById(R.id.imageBuscarInspeccion);
        nuevaInspeccion = view.findViewById(R.id.imageNuevaInspeccion);
        calculadora = view.findViewById(R.id.imageCalculadora);
        sincronizar = view.findViewById(R.id.ib_sync);
        buscarTodo = view.findViewById(R.id.buscartodo);


        buscarCamion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BuscarVehiculoActivity.class);
                startActivity(intent);
            }
        });

        buscarInspeccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BuscarInspeccionActivity.class);
                startActivity(intent);
            }
        });

        nuevaInspeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), CabeceraInspeccionActivity.class);
                startActivity(intent);
            }
        });

        sincronizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SincronizarActivity.class);
                startActivity(intent);
            }
        });

        buscarTodo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BuscarTodoActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
