package com.javierpinya.inspecciondevehiculos.fragments.resultadoBuscarVehiculos;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarRigidoFragment extends Fragment {


    public ResultadoBuscarRigidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_buscar_rigido, container, false);
    }

}
