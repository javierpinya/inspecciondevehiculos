package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.ValoracionInspeccionFragment;
import com.javierpinya.inspecciondevehiculos.viewmodels.InspeccionViewModel;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValoracionInspeccionActivity extends AppCompatActivity implements ValoracionInspeccionFragment.DataListener {

    private List<String> cabecera = new ArrayList<>();
    private List<Boolean> checklist = new ArrayList<>();
    private List<String> compartimentos = new ArrayList<>();
    private List<Boolean> cumple_comp = new ArrayList<>();
    private List<String> valoracionString = new ArrayList<>();
    private List<Integer> placa = new ArrayList<>();
    private List<Integer> tag = new ArrayList<>();
    private List<Boolean> valoracionBoolean = new ArrayList<>();
    private List<Integer> pesos = new ArrayList<>();
    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
    private InspeccionViewModel inspeccionViewModel;
    private int num_inspeccion;
    private String cod_inspector = "";

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion_inspeccion);

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        inspeccionViewModel = ViewModelProviders.of(this).get(InspeccionViewModel.class);

        String strDate = dateFormat.format(date);
        String cod_inspector = prefs.getString("cod_inspector", "error_cod_inspector");
        String inspector = prefs.getString("inspector","error_inspector");
        String num_inspeccion = prefs.getString("nuevaInspeccion", "num_inspeccion");

        //num_inspeccion = getrowcount(cod_inspector);


        cabecera.add(prefs.getString("desInstalacion", "errorInstalacion"));
        cabecera.add(cod_inspector + num_inspeccion);
        cabecera.add(cod_inspector);
        cabecera.add(inspector);
        cabecera.add(strDate);
        cabecera.add(null);
        cabecera.add(null);

        cabecera.add(prefs.getString("transportista", "errorTransportista"));
        cabecera.add(prefs.getString("conjunto", "0")); //el conjunto no está en el formulario. campo 8 empezando desde 0. convertir a int
        cabecera.add(prefs.getString("tractora","-"));
        cabecera.add(prefs.getString("cisterna", "-"));
        cabecera.add(prefs.getString("rigido","-"));
        if(prefs.getString("fechaCalRig","").equals("")){
            cabecera.add("01/01/1980");
        }else{
            cabecera.add(prefs.getString("fechaCalRig", "01/01/1980"));
        }
        if(prefs.getString("fechaCalCis","").equals("")){
            cabecera.add("01/01/1980");
        }else{
            cabecera.add(prefs.getString("fechaCalCis", "01/01/1980"));
        }
        cabecera.add(prefs.getString("nombreConductor", "-"));
        if(prefs.getString("codConductor","0").equals("")){
            cabecera.add("0");
        }else {
            cabecera.add(prefs.getString("codConductor", "0")); //convertir a int
        }
        cabecera.add(prefs.getString("suministrador","errorSuminist"));
        cabecera.add(prefs.getString("albaran", "-"));
        cabecera.add(prefs.getString("empresaCalibracion", "-"));
        //En este punto deben ir permiso conducir, etc que son booleanos

        checklist.add(prefs.getBoolean("permisoConducir",false));
        checklist.add(prefs.getBoolean("adrcond",false));
        checklist.add(prefs.getBoolean("itvtrac",false));
        checklist.add(prefs.getBoolean("itvcis",false));
        checklist.add(prefs.getBoolean("adrtrac", false));
        checklist.add(prefs.getBoolean("adrcis",false));
        checklist.add(prefs.getBoolean("fichaSeguridad", false));
        checklist.add(prefs.getBoolean("transpondertrac", false));
        checklist.add(prefs.getBoolean("transpondercis", false));
        checklist.add(prefs.getBoolean("superficieAntides", false));
        checklist.add(prefs.getBoolean("posicionAdecuada", false));
        checklist.add(prefs.getBoolean("frenoEstacionamiento",false));
        checklist.add(prefs.getBoolean("bateriaDesconectada",false));
        checklist.add(prefs.getBoolean("apagallamas", false));
        checklist.add(prefs.getBoolean("movil", false));
        checklist.add(prefs.getBoolean("interrupEmergencia", false));
        checklist.add(prefs.getBoolean("tomatierra",false));
        checklist.add(prefs.getBoolean("mangueraGases", false));
        checklist.add(prefs.getBoolean("purga", false));
        checklist.add(prefs.getBoolean("ropa", false));
        checklist.add(prefs.getBoolean("estanqueidadcisterna",false));
        checklist.add(prefs.getBoolean("estanqueidadvalvulasapi", false));
        checklist.add(prefs.getBoolean("estanqueidadvalvulasfondo", false));
        checklist.add(prefs.getBoolean("estanqueidadcajonvalvulas", false));
        checklist.add(prefs.getBoolean("estanqueidadequipostras", false));
        checklist.add(prefs.getBoolean("recogeralbaran", false));
        checklist.add(prefs.getBoolean("tc2",false));
        checklist.add(prefs.getBoolean("montajeTags", false));
        checklist.add(prefs.getBoolean("bajadaTags", false));
        checklist.add(prefs.getBoolean("lecturaTags", false));

        compartimentos.add(prefs.getString("alturarealsonda1", "-"));
        compartimentos.add(prefs.getString("altura96sonda1","-"));
        compartimentos.add(prefs.getString("cantidadcargada1", "-"));
        compartimentos.add(prefs.getString("cantidad96st1","-"));
        compartimentos.add(prefs.getString("diferencia1", "-"));

        compartimentos.add(prefs.getString("alturarealsonda2", "-"));
        compartimentos.add(prefs.getString("altura96sonda2","-"));
        compartimentos.add(prefs.getString("cantidadcargada2", "-"));
        compartimentos.add(prefs.getString("cantidad96st2","-"));
        compartimentos.add(prefs.getString("diferencia2", "-"));

        compartimentos.add(prefs.getString("alturarealsonda3", "-"));
        compartimentos.add(prefs.getString("altura96sonda3","-"));
        compartimentos.add(prefs.getString("cantidadcargada3", "-"));
        compartimentos.add(prefs.getString("cantidad96st3","-"));
        compartimentos.add(prefs.getString("diferencia3", "-"));

        compartimentos.add(prefs.getString("alturarealsonda4", "-"));
        compartimentos.add(prefs.getString("altura96sonda4","-"));
        compartimentos.add(prefs.getString("cantidadcargada4", "-"));
        compartimentos.add(prefs.getString("cantidad96st4","-"));
        compartimentos.add(prefs.getString("diferencia4", "-"));
        compartimentos.add(prefs.getString("c4_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda5", "-"));
        compartimentos.add(prefs.getString("altura96sonda5","-"));
        compartimentos.add(prefs.getString("cantidadcargada5", "-"));
        compartimentos.add(prefs.getString("cantidad96st5","-"));
        compartimentos.add(prefs.getString("diferencia5", "-"));
        compartimentos.add(prefs.getString("c5_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda6", "-"));
        compartimentos.add(prefs.getString("altura96sonda6","-"));
        compartimentos.add(prefs.getString("cantidadcargada6", "-"));
        compartimentos.add(prefs.getString("cantidad96st6","-"));
        compartimentos.add(prefs.getString("diferencia6", "-"));
        compartimentos.add(prefs.getString("c6_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda7", "-"));
        compartimentos.add(prefs.getString("altura96sonda7","-"));
        compartimentos.add(prefs.getString("cantidadcargada7", "-"));
        compartimentos.add(prefs.getString("cantidad96st7","-"));
        compartimentos.add(prefs.getString("diferencia7", "-"));
        compartimentos.add(prefs.getString("c7_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda8", "-"));
        compartimentos.add(prefs.getString("altura96sonda8","-"));
        compartimentos.add(prefs.getString("cantidadcargada8", "-"));
        compartimentos.add(prefs.getString("cantidad96st8","-"));
        compartimentos.add(prefs.getString("diferencia8", "-"));
        compartimentos.add(prefs.getString("c8_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda9", "-"));
        compartimentos.add(prefs.getString("altura96sonda9","-"));
        compartimentos.add(prefs.getString("cantidadcargada9", "-"));
        compartimentos.add(prefs.getString("cantidad96st9","-"));
        compartimentos.add(prefs.getString("diferencia9", "-"));
        compartimentos.add(prefs.getString("c9_vol_total_placa", "-"));
        compartimentos.add(prefs.getString("alturarealsonda10", "-"));
        compartimentos.add(prefs.getString("altura96sonda10","-"));
        compartimentos.add(prefs.getString("cantidadcargada10", "-"));
        compartimentos.add(prefs.getString("cantidad96st10","-"));
        compartimentos.add(prefs.getString("diferencia10", "-"));
        compartimentos.add(prefs.getString("c10_vol_total_placa", "-"));

        cumple_comp.add(prefs.getBoolean("ok1", false));
        cumple_comp.add(prefs.getBoolean("ok2", false));
        cumple_comp.add(prefs.getBoolean("ok3", false));
        cumple_comp.add(prefs.getBoolean("ok4", false));
        cumple_comp.add(prefs.getBoolean("ok5", false));
        cumple_comp.add(prefs.getBoolean("ok6", false));
        cumple_comp.add(prefs.getBoolean("ok7", false));
        cumple_comp.add(prefs.getBoolean("ok8", false));
        cumple_comp.add(prefs.getBoolean("ok9", false));
        cumple_comp.add(prefs.getBoolean("ok10", false));

        placa.add(prefs.getInt("c1_vol_total_placa", 0));
        placa.add(prefs.getInt("c2_vol_total_placa", 0));
        placa.add(prefs.getInt("c3_vol_total_placa", 0));
        placa.add(prefs.getInt("c4_vol_total_placa", 0));
        placa.add(prefs.getInt("c5_vol_total_placa", 0));
        placa.add(prefs.getInt("c6_vol_total_placa", 0));
        placa.add(prefs.getInt("c7_vol_total_placa", 0));
        placa.add(prefs.getInt("c8_vol_total_placa", 0));
        placa.add(prefs.getInt("c9_vol_total_placa", 0));
        placa.add(prefs.getInt("c10_vol_total_placa", 0));

        tag.add(prefs.getInt("c1_tag", 0));
        tag.add(prefs.getInt("c2_tag", 0));
        tag.add(prefs.getInt("c3_tag", 0));
        tag.add(prefs.getInt("c4_tag", 0));
        tag.add(prefs.getInt("c5_tag", 0));
        tag.add(prefs.getInt("c6_tag", 0));
        tag.add(prefs.getInt("c7_tag", 0));
        tag.add(prefs.getInt("c8_tag", 0));
        tag.add(prefs.getInt("c9_tag", 0));
        tag.add(prefs.getInt("c10_tag", 0));

        //capturar el callback y lanzar la app fotos enviando el dato de la inspeccion para guardar la foto con ese nombre
        valoracionBoolean.add(prefs.getBoolean("inspeccionada", false));
        valoracionBoolean.add(prefs.getBoolean("favorable",false));
        valoracionBoolean.add(prefs.getBoolean("desfavorable",false));
        valoracionBoolean.add(prefs.getBoolean("bloqueo",false));
        valoracionBoolean.add(prefs.getBoolean("revisado", false));
        valoracionBoolean.add(prefs.getBoolean("inspeccion_camara", false));

        if(prefs.getString("fecha_desfavorable", "01/01/1980").equals("")){
            valoracionString.add("01/01/1980");
        }else{
            valoracionString.add(prefs.getString("fecha_desfavorable","01/01/1980"));
        }
        if(prefs.getString("fecha_bloqueo", "01/01/1980").equals("")){
            valoracionString.add("01/01/1980");
        }else{
            valoracionString.add(prefs.getString("fecha_bloqueo","01/01/1980"));
        }
        valoracionString.add(prefs.getString("observaciones",""));
        valoracionString.add(prefs.getString("numero_incidencia1","-"));
        if(prefs.getString("fecha_arnes", "01/01/1980").equals("")){
            valoracionString.add("01/01/1980");
        }else{
            valoracionString.add(prefs.getString("fecha_arnes","01/01/1980"));
        }
        valoracionString.add(prefs.getString("tag_observaciones","-"));

        pesos.add(prefs.getInt("peso_entrada", 0));
        pesos.add(prefs.getInt("peso_salida",0));
        pesos.add(prefs.getInt("producto", 0));
    }

    @Override
    public void takePicture() {
        Intent intent = new Intent();
        intent.setClass(this,FotoActivity.class);
        startActivity(intent);
    }

    public int getrowcount(String cod_inspector){
        return inspeccionViewModel.getRowCount("%" + cod_inspector + "%");
    }

    @Override
    public void guardar() {
        try {
            inspeccionViewModel.insertarInspeccion(new InspeccionEntity(cabecera.get(0),
                    cabecera.get(1),
                    cabecera.get(2),
                    cabecera.get(3),
                    parseador.parse(cabecera.get(4)),
                    null,
                    null,
                    cabecera.get(7),
                    0,
                    cabecera.get(9),
                    cabecera.get(10),
                    cabecera.get(11),
                    parseador.parse(cabecera.get(12)),
                    parseador.parse(cabecera.get(13)),
                    cabecera.get(14),
                    Integer.valueOf(cabecera.get(15)),
                    cabecera.get(16),
                    cabecera.get(17),
                    cabecera.get(18),
                    checklist.get(0),
                    checklist.get(1),
                    checklist.get(2),
                    checklist.get(3),
                    checklist.get(4),
                    checklist.get(5),
                    checklist.get(6),
                    checklist.get(7),
                    checklist.get(8),
                    checklist.get(9),
                    checklist.get(10),
                    checklist.get(11),
                    checklist.get(12),
                    checklist.get(13),
                    checklist.get(14),
                    checklist.get(15),
                    checklist.get(16),
                    checklist.get(17),
                    checklist.get(18),
                    checklist.get(19),
                    checklist.get(20),
                    checklist.get(21),
                    checklist.get(22),
                    checklist.get(23),
                    checklist.get(24),
                    checklist.get(25),
                    checklist.get(26),
                    checklist.get(27),
                    checklist.get(28),
                    checklist.get(29),
                    compartimentos.get(0),
                    compartimentos.get(1),
                    compartimentos.get(2),
                    compartimentos.get(3),
                    compartimentos.get(4),
                    compartimentos.get(5),
                    compartimentos.get(6),
                    compartimentos.get(7),
                    compartimentos.get(8),
                    compartimentos.get(9),
                    compartimentos.get(10),
                    compartimentos.get(11),
                    compartimentos.get(12),
                    compartimentos.get(13),
                    compartimentos.get(14),
                    compartimentos.get(15),
                    compartimentos.get(16),
                    compartimentos.get(17),
                    compartimentos.get(18),
                    compartimentos.get(19),
                    compartimentos.get(20),
                    compartimentos.get(21),
                    compartimentos.get(22),
                    compartimentos.get(23),
                    compartimentos.get(24),
                    compartimentos.get(25),
                    compartimentos.get(26),
                    compartimentos.get(27),
                    compartimentos.get(28),
                    compartimentos.get(29),
                    compartimentos.get(30),
                    compartimentos.get(31),
                    compartimentos.get(32),
                    compartimentos.get(33),
                    compartimentos.get(34),
                    compartimentos.get(35),
                    compartimentos.get(36),
                    compartimentos.get(37),
                    compartimentos.get(38),
                    compartimentos.get(39),
                    compartimentos.get(40),
                    compartimentos.get(41),
                    compartimentos.get(42),
                    compartimentos.get(43),
                    compartimentos.get(44),
                    compartimentos.get(45),
                    compartimentos.get(46),
                    compartimentos.get(47),
                    compartimentos.get(48),
                    compartimentos.get(49),
                    cumple_comp.get(0),
                    cumple_comp.get(1),
                    cumple_comp.get(2),
                    cumple_comp.get(3),
                    cumple_comp.get(4),
                    cumple_comp.get(5),
                    cumple_comp.get(6),
                    cumple_comp.get(7),
                    cumple_comp.get(8),
                    cumple_comp.get(9),
                    placa.get(0),
                    placa.get(1),
                    placa.get(2),
                    placa.get(3),
                    placa.get(4),
                    placa.get(5),
                    placa.get(6),
                    placa.get(7),
                    placa.get(8),
                    placa.get(9),
                    tag.get(0),
                    tag.get(1),
                    tag.get(2),
                    tag.get(3),
                    tag.get(4),
                    tag.get(5),
                    tag.get(6),
                    tag.get(7),
                    tag.get(8),
                    tag.get(9),
                    valoracionBoolean.get(0),
                    valoracionBoolean.get(1),
                    valoracionBoolean.get(2),
                    valoracionBoolean.get(3),
                    valoracionBoolean.get(4),
                    valoracionBoolean.get(5),
                    parseador.parse(valoracionString.get(0)),
                    parseador.parse(valoracionString.get(1)),
                    valoracionString.get(2),
                    valoracionString.get(3),
                    parseador.parse(valoracionString.get(4)),
                    valoracionString.get(5),
                    pesos.get(0),
                    pesos.get(1),
                    pesos.get(2)));
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }catch (ParseException e){
            Toast.makeText(this, "Se ha producido error: " + e.toString(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
