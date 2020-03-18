package com.javierpinya.inspecciondevehiculos.fragments.menu;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private SharedPreferences prefs;
    private String user;
    private TextView tvPuesto,tvUsuario;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        prefs = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        user = prefs.getString("user","usuario");
        tvPuesto = view.findViewById(R.id.profileActivityTvPuesto);
        tvUsuario = view.findViewById(R.id.profileActivityTvName);
        tvUsuario.setText(user);

        return view;
    }

}
