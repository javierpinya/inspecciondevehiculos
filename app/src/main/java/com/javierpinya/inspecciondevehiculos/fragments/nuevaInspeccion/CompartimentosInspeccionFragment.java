package com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;

import java.util.ArrayList;
import java.util.List;


public class CompartimentosInspeccionFragment extends Fragment {

    private DataListener callback;

    private SharedPreferences prefs;

    private List<String> alturarealsonda = new ArrayList<>();
    private List<String> altura96sonda = new ArrayList<>();
    private List<String> cantidadcargada = new ArrayList<>();
    private List<String> cantidad96st = new ArrayList<>();
    private List<String> diferencia = new ArrayList<>();
    private List<String> voltotalplaca = new ArrayList<>();
    private List<String> tag = new ArrayList<>();

    private EditText alturarealsonda1,alturarealsonda2,alturarealsonda3,alturarealsonda4,alturarealsonda5,alturarealsonda6,alturarealsonda7, alturarealsonda8;
    private EditText altura96sonda1,altura96sonda2,altura96sonda3,altura96sonda4,altura96sonda5,altura96sonda6,altura96sonda7,altura96sonda8;
    private EditText cantidadcargada1,cantidadcargada2,cantidadcargada3,cantidadcargada4,cantidadcargada5,cantidadcargada6,cantidadcargada7,cantidadcargada8;
    private EditText cantidad96st1,cantidad96st2,cantidad96st3,cantidad96st4,cantidad96st5,cantidad96st6,cantidad96st7,cantidad96st8;
    private EditText diferencia1,diferencia2,diferencia3,diferencia4,diferencia5,diferencia6,diferencia7,diferencia8;
    private EditText voltotalplaca1,voltotalplaca2,voltotalplaca3,voltotalplaca4,voltotalplaca5,voltotalplaca6,voltotalplaca7,voltotalplaca8;
    private EditText tag1,tag2,tag3,tag4,tag5,tag6,tag7,tag8;

    private Button btn_a_resolucioninspeccion;

    private boolean c1,c2,c3,c4,c5,c6,c7,c8;


    public CompartimentosInspeccionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_compartimentos_inspeccion, container, false);



        prefs = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        String inspeccion = prefs.getString("nuevaInspeccion", "errorInspeccion");

        final SharedPreferences.Editor editor_comp = prefs.edit();

        alturarealsonda1 = view.findViewById(R.id.alturarealsonda1);
        alturarealsonda2 = view.findViewById(R.id.alturarealsonda2);
        alturarealsonda3 = view.findViewById(R.id.alturarealsonda3);
        alturarealsonda4 = view.findViewById(R.id.alturarealsonda4);
        alturarealsonda5 = view.findViewById(R.id.alturarealsonda5);
        alturarealsonda6 = view.findViewById(R.id.alturarealsonda6);
        alturarealsonda7 = view.findViewById(R.id.alturarealsonda7);
        alturarealsonda8 = view.findViewById(R.id.alturarealsonda8);

        altura96sonda1 = view.findViewById(R.id.altura96sonda1);
        altura96sonda2 = view.findViewById(R.id.altura96sonda2);
        altura96sonda3 = view.findViewById(R.id.altura96sonda3);
        altura96sonda4 = view.findViewById(R.id.altura96sonda4);
        altura96sonda5 = view.findViewById(R.id.altura96sonda5);
        altura96sonda6 = view.findViewById(R.id.altura96sonda6);
        altura96sonda7 = view.findViewById(R.id.altura96sonda7);
        altura96sonda8 = view.findViewById(R.id.altura96sonda8);

        cantidadcargada1 = view.findViewById(R.id.cantidadcargada1);
        cantidadcargada2 = view.findViewById(R.id.cantidadcargada2);
        cantidadcargada3 = view.findViewById(R.id.cantidadcargada3);
        cantidadcargada4 = view.findViewById(R.id.cantidadcargada4);
        cantidadcargada5 = view.findViewById(R.id.cantidadcargada5);
        cantidadcargada6 = view.findViewById(R.id.cantidadcargada6);
        cantidadcargada7 = view.findViewById(R.id.cantidadcargada7);
        cantidadcargada8 = view.findViewById(R.id.cantidadcargada8);

        cantidad96st1 = view.findViewById(R.id.cantidad96st1);
        cantidad96st2 = view.findViewById(R.id.cantidad96st2);
        cantidad96st3 = view.findViewById(R.id.cantidad96st3);
        cantidad96st4 = view.findViewById(R.id.cantidad96st4);
        cantidad96st5 = view.findViewById(R.id.cantidad96st5);
        cantidad96st6 = view.findViewById(R.id.cantidad96st6);
        cantidad96st7 = view.findViewById(R.id.cantidad96st7);
        cantidad96st8 = view.findViewById(R.id.cantidad96st8);

        diferencia1 = view.findViewById(R.id.diferencia1);
        diferencia2 = view.findViewById(R.id.diferencia2);
        diferencia3 = view.findViewById(R.id.diferencia3);
        diferencia4 = view.findViewById(R.id.diferencia4);
        diferencia5 = view.findViewById(R.id.diferencia5);
        diferencia6 = view.findViewById(R.id.diferencia6);
        diferencia7 = view.findViewById(R.id.diferencia7);
        diferencia8 = view.findViewById(R.id.diferencia8);

        voltotalplaca1 = view.findViewById(R.id.voltotalplaca1);
        voltotalplaca2 = view.findViewById(R.id.voltotalplaca2);
        voltotalplaca3 = view.findViewById(R.id.voltotalplaca3);
        voltotalplaca4 = view.findViewById(R.id.voltotalplaca4);
        voltotalplaca5 = view.findViewById(R.id.voltotalplaca5);
        voltotalplaca6 = view.findViewById(R.id.voltotalplaca6);
        voltotalplaca7 = view.findViewById(R.id.voltotalplaca7);
        voltotalplaca8 = view.findViewById(R.id.voltotalplaca8);

        tag1 = view.findViewById(R.id.tag1);
        tag2 = view.findViewById(R.id.tag2);
        tag3 = view.findViewById(R.id.tag3);
        tag4 = view.findViewById(R.id.tag4);
        tag5 = view.findViewById(R.id.tag5);
        tag6 = view.findViewById(R.id.tag6);
        tag7 = view.findViewById(R.id.tag7);
        tag8 = view.findViewById(R.id.tag8);


        btn_a_resolucioninspeccion = view.findViewById(R.id.btn_a_resolucioninspeccion);

        btn_a_resolucioninspeccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (alturarealsonda1.getText().length()>0 && cantidadcargada1.getText().length()>0 && Integer.valueOf(alturarealsonda1.getText().toString())>Integer.valueOf(cantidadcargada1.getText().toString())){
                    c1 = true;
                }else{
                    c1 = false;
                }

                if (alturarealsonda2.getText().length()>0 && cantidadcargada2.getText().length()>0 && Integer.valueOf(alturarealsonda2.getText().toString())>Integer.valueOf(cantidadcargada2.getText().toString())){
                    c2 = true;
                }else{
                    c2 = false;
                }

                if (alturarealsonda3.getText().length()>0 && cantidadcargada3.getText().length()>0 && Integer.valueOf(alturarealsonda3.getText().toString())>Integer.valueOf(cantidadcargada3.getText().toString())){
                    c3 = true;
                }else{
                    c3 = false;
                }

                if (alturarealsonda4.getText().length()>0 && cantidadcargada4.getText().length()>0 && Integer.valueOf(alturarealsonda4.getText().toString())>Integer.valueOf(cantidadcargada4.getText().toString())){
                    c4 = true;
                }else{
                    c4 = false;
                }

                if (alturarealsonda5.getText().length()>0 && cantidadcargada5.getText().length()>0 && Integer.valueOf(alturarealsonda5.getText().toString())>Integer.valueOf(cantidadcargada5.getText().toString())){
                    c5 = true;
                }else{
                    c5 = false;
                }

                if (alturarealsonda6.getText().length()>0 && cantidadcargada6.getText().length()>0 && Integer.valueOf(alturarealsonda6.getText().toString())>Integer.valueOf(cantidadcargada6.getText().toString())){
                    c6 = true;
                }else{
                    c6 = false;
                }

                if (alturarealsonda7.getText().length()>0 && cantidadcargada7.getText().length()>0 && Integer.valueOf(alturarealsonda7.getText().toString())>Integer.valueOf(cantidadcargada7.getText().toString())){
                    c7 = true;
                }else{
                    c7 = false;
                }

                if (alturarealsonda8.getText().length()>0 && cantidadcargada8.getText().length()>0 && Integer.valueOf(alturarealsonda8.getText().toString())>Integer.valueOf(cantidadcargada8.getText().toString())){
                    c8 = true;
                }else{
                    c8 = false;
                }


                alturarealsonda.add(alturarealsonda1.getText().toString());
                alturarealsonda.add(alturarealsonda2.getText().toString());
                alturarealsonda.add(alturarealsonda3.getText().toString());
                alturarealsonda.add(alturarealsonda4.getText().toString());
                alturarealsonda.add(alturarealsonda5.getText().toString());
                alturarealsonda.add(alturarealsonda6.getText().toString());
                alturarealsonda.add(alturarealsonda7.getText().toString());
                alturarealsonda.add(alturarealsonda8.getText().toString());

                editor_comp.putString("alturarealsonda1",alturarealsonda1.getText().toString());
                editor_comp.putString("alturarealsonda2",alturarealsonda2.getText().toString());
                editor_comp.putString("alturarealsonda3",alturarealsonda3.getText().toString());
                editor_comp.putString("alturarealsonda4",alturarealsonda4.getText().toString());
                editor_comp.putString("alturarealsonda5",alturarealsonda5.getText().toString());
                editor_comp.putString("alturarealsonda6",alturarealsonda6.getText().toString());
                editor_comp.putString("alturarealsonda7",alturarealsonda7.getText().toString());
                editor_comp.putString("alturarealsonda8",alturarealsonda8.getText().toString());

                altura96sonda.add(altura96sonda1.getText().toString());
                altura96sonda.add(altura96sonda2.getText().toString());
                altura96sonda.add(altura96sonda3.getText().toString());
                altura96sonda.add(altura96sonda4.getText().toString());
                altura96sonda.add(altura96sonda5.getText().toString());
                altura96sonda.add(altura96sonda6.getText().toString());
                altura96sonda.add(altura96sonda7.getText().toString());

                editor_comp.putString("altura96sonda1",altura96sonda1.getText().toString());
                editor_comp.putString("altura96sonda2",altura96sonda2.getText().toString());
                editor_comp.putString("altura96sonda3",altura96sonda3.getText().toString());
                editor_comp.putString("altura96sonda4",altura96sonda4.getText().toString());
                editor_comp.putString("altura96sonda5",altura96sonda5.getText().toString());
                editor_comp.putString("altura96sonda6",altura96sonda6.getText().toString());
                editor_comp.putString("altura96sonda7",altura96sonda7.getText().toString());
                editor_comp.putString("altura96sonda8",altura96sonda8.getText().toString());

                cantidadcargada.add(cantidadcargada1.getText().toString());
                cantidadcargada.add(cantidadcargada2.getText().toString());
                cantidadcargada.add(cantidadcargada3.getText().toString());
                cantidadcargada.add(cantidadcargada4.getText().toString());
                cantidadcargada.add(cantidadcargada5.getText().toString());
                cantidadcargada.add(cantidadcargada6.getText().toString());
                cantidadcargada.add(cantidadcargada7.getText().toString());
                cantidadcargada.add(cantidadcargada8.getText().toString());

                editor_comp.putString("cantidadcargada1",cantidadcargada1.getText().toString());
                editor_comp.putString("cantidadcargada2",cantidadcargada2.getText().toString());
                editor_comp.putString("cantidadcargada3",cantidadcargada3.getText().toString());
                editor_comp.putString("cantidadcargada4",cantidadcargada4.getText().toString());
                editor_comp.putString("cantidadcargada5",cantidadcargada5.getText().toString());
                editor_comp.putString("cantidadcargada6",cantidadcargada6.getText().toString());
                editor_comp.putString("cantidadcargada7",cantidadcargada7.getText().toString());
                editor_comp.putString("cantidadcargada8",cantidadcargada8.getText().toString());

                cantidad96st.add(cantidad96st1.getText().toString());
                cantidad96st.add(cantidad96st2.getText().toString());
                cantidad96st.add(cantidad96st3.getText().toString());
                cantidad96st.add(cantidad96st4.getText().toString());
                cantidad96st.add(cantidad96st5.getText().toString());
                cantidad96st.add(cantidad96st6.getText().toString());
                cantidad96st.add(cantidad96st7.getText().toString());
                cantidad96st.add(cantidad96st8.getText().toString());

                editor_comp.putString("cantidad96st1",cantidad96st1.getText().toString());
                editor_comp.putString("cantidad96st2",cantidad96st2.getText().toString());
                editor_comp.putString("cantidad96st3",cantidad96st3.getText().toString());
                editor_comp.putString("cantidad96st4",cantidad96st4.getText().toString());
                editor_comp.putString("cantidad96st5",cantidad96st5.getText().toString());
                editor_comp.putString("cantidad96st6",cantidad96st6.getText().toString());
                editor_comp.putString("cantidad96st7",cantidad96st7.getText().toString());
                editor_comp.putString("cantidad96st8",cantidad96st8.getText().toString());

                diferencia.add(diferencia1.getText().toString());
                diferencia.add(diferencia2.getText().toString());
                diferencia.add(diferencia3.getText().toString());
                diferencia.add(diferencia4.getText().toString());
                diferencia.add(diferencia5.getText().toString());
                diferencia.add(diferencia6.getText().toString());
                diferencia.add(diferencia7.getText().toString());
                diferencia.add(diferencia8.getText().toString());

                editor_comp.putString("diferencia1",diferencia1.getText().toString());
                editor_comp.putString("diferencia2",diferencia2.getText().toString());
                editor_comp.putString("diferencia3",diferencia3.getText().toString());
                editor_comp.putString("diferencia4",diferencia4.getText().toString());
                editor_comp.putString("diferencia5",diferencia5.getText().toString());
                editor_comp.putString("diferencia6",diferencia6.getText().toString());
                editor_comp.putString("diferencia7",diferencia7.getText().toString());
                editor_comp.putString("diferencia8",diferencia8.getText().toString());

                voltotalplaca.add(voltotalplaca1.getText().toString());
                voltotalplaca.add(voltotalplaca2.getText().toString());
                voltotalplaca.add(voltotalplaca3.getText().toString());
                voltotalplaca.add(voltotalplaca4.getText().toString());
                voltotalplaca.add(voltotalplaca5.getText().toString());
                voltotalplaca.add(voltotalplaca6.getText().toString());
                voltotalplaca.add(voltotalplaca7.getText().toString());
                voltotalplaca.add(voltotalplaca8.getText().toString());

                editor_comp.putString("voltotalplaca1",voltotalplaca1.getText().toString());
                editor_comp.putString("voltotalplaca2",voltotalplaca2.getText().toString());
                editor_comp.putString("voltotalplaca3",voltotalplaca3.getText().toString());
                editor_comp.putString("voltotalplaca4",voltotalplaca4.getText().toString());
                editor_comp.putString("voltotalplaca5",voltotalplaca5.getText().toString());
                editor_comp.putString("voltotalplaca6",voltotalplaca6.getText().toString());
                editor_comp.putString("voltotalplaca7",voltotalplaca7.getText().toString());
                editor_comp.putString("voltotalplaca8",voltotalplaca8.getText().toString());

                tag.add(tag1.getText().toString());
                tag.add(tag2.getText().toString());
                tag.add(tag3.getText().toString());
                tag.add(tag4.getText().toString());
                tag.add(tag5.getText().toString());
                tag.add(tag6.getText().toString());
                tag.add(tag7.getText().toString());
                tag.add(tag8.getText().toString());

                editor_comp.putString("tag1",tag1.getText().toString());
                editor_comp.putString("tag2",tag2.getText().toString());
                editor_comp.putString("tag3",tag3.getText().toString());
                editor_comp.putString("tag4",tag4.getText().toString());
                editor_comp.putString("tag5",tag5.getText().toString());
                editor_comp.putString("tag6",tag6.getText().toString());
                editor_comp.putString("tag7",tag7.getText().toString());
                editor_comp.putString("tag8",tag8.getText().toString());

                editor_comp.putBoolean("ok1",c1);
                editor_comp.putBoolean("ok2",c2);
                editor_comp.putBoolean("ok3",c3);
                editor_comp.putBoolean("ok4",c4);
                editor_comp.putBoolean("ok5",c5);
                editor_comp.putBoolean("ok6",c6);
                editor_comp.putBoolean("ok7",c7);
                editor_comp.putBoolean("ok8",c8);

                editor_comp.apply();

                siguiente();
            }
        });

        return view;
    }


    public void siguiente(){
        callback.sendData();
    }

    public interface DataListener{
        void sendData();
    }

}
