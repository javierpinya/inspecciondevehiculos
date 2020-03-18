package com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.javierpinya.inspecciondevehiculos.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValoracionInspeccionFragment extends Fragment {

    private ImageButton foto;
    private Button guardar;

    private CheckBox inspeccionada,favorable,desfavorable,bloqueo,revisado,inspeccion_camara;
    private EditText fecha_desfavorable,fecha_bloqueo,fecha_revisado;
    private MultiAutoCompleteTextView observaciones;

    private DataListener callback;

    private FloatingActionButton fab;
    private SharedPreferences prefs;



    public ValoracionInspeccionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (DataListener)context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_valoracion_inspeccion, container, false);

        prefs = Objects.requireNonNull(getActivity()).getSharedPreferences("preferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor_valoracion = prefs.edit();

        inspeccionada = view.findViewById(R.id.inspeccionada);
        favorable = view.findViewById(R.id.favorable);
        desfavorable = view.findViewById(R.id.desfavorable);
        bloqueo = view.findViewById(R.id.bloqueo);
        revisado = view.findViewById(R.id.revisada);
        inspeccion_camara = view.findViewById(R.id.camara);
        fecha_bloqueo = view.findViewById(R.id.fecha_bloqueo);
        fecha_revisado = view.findViewById(R.id.fecha_revisada);
        fecha_desfavorable = view.findViewById(R.id.fecha_desfavorable);
        observaciones = view.findViewById(R.id.observaciones);

        //foto = view.findViewById(R.id.img_lanzarfoto);
        fab = view.findViewById(R.id.fab);
        guardar = view.findViewById(R.id.btn_guardar);

        if(favorable.isChecked()){
            desfavorable.setChecked(false);
        }
        if(desfavorable.isChecked()){
            favorable.setChecked(false);
        }

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                callback.takePicture();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                editor_valoracion.putBoolean("inspeccionada",inspeccionada.isChecked());
                editor_valoracion.putBoolean("favorable",favorable.isChecked());
                editor_valoracion.putBoolean("desfavorable",desfavorable.isChecked());
                editor_valoracion.putBoolean("bloqueo",bloqueo.isChecked());
                editor_valoracion.putBoolean("revisado",revisado.isChecked());
                editor_valoracion.putBoolean("inspeccion_camara", inspeccion_camara.isChecked());
                if(!fecha_desfavorable.getText().toString().isEmpty()){
                    editor_valoracion.putString("fecha_desfavorable", fecha_desfavorable.getText().toString());
                }else{
                    editor_valoracion.putString("fecha_desfavorable", null);
                }
                if(!fecha_bloqueo.getText().toString().isEmpty()){
                    editor_valoracion.putString("fecha_bloqueo", fecha_bloqueo.getText().toString());
                }else{
                    editor_valoracion.putString("fecha_bloqueo", null);
                }
                if(!fecha_revisado.getText().toString().isEmpty()){
                    editor_valoracion.putString("fecha_revisada", fecha_revisado.getText().toString());
                }else{
                    editor_valoracion.putString("fecha_revisada", null);
                }
                editor_valoracion.apply();
                callback.guardar();

            }
        });


        return view;
    }

    public interface DataListener{
        void takePicture();
        void guardar();
    }



}
