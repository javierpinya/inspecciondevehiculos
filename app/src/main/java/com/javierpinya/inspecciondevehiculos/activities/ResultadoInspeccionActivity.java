package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.fragments.buscador.BuscarInspeccionFragment;
import com.javierpinya.inspecciondevehiculos.viewmodels.InspeccionViewModel;

import java.util.ArrayList;
import java.util.List;

public class ResultadoInspeccionActivity extends AppCompatActivity {

    private String matT,matC,inspeccion;
    private TextView nuevaInspeccionres,tv_inspectorres,tv_instalacionres,tv_desinstalacionres,tv_transportistares,
                    albaranres,fechaarnesres,empresacalibracion,tractora,rigido,cisterna,fechacalibracionrig,
                    fechacalibracioncis,codconductor,nombrecond,suministrador,pesoentrada,pesosalida;
    private AppCompatCheckBox permisocir,adrcond,itvtract,itvcist,adrtract,adrcist,fichaseguridad,transpondert,transponderc,
                    superficieantides,posicionvehiculo,freno,baterias,apagallamas,movil,interruptor,tomatierra,manguera,
                    purgacomp,ropa,tc2,montajetags,bajadatags,lecturatags,estanqueidadcist,estanqueidadapi,estanqueidadvalvfondo,
                    estanqueidadcajonres,estanqueidadequipotras,recogeralbaran;
    private TextView alturarealsonda1,alturarealsonda2,alturarealsonda3,alturarealsonda4,alturarealsonda5,alturarealsonda6,
                    alturarealsonda7,alturarealsonda8,alturarealsonda9,alturarealsonda10;
    private TextView altura96sonda1,altura96sonda2,altura96sonda3,altura96sonda4,altura96sonda5,altura96sonda6,altura96sonda7,
                    altura96sonda8,altura96sonda9,altura96sonda10;
    private TextView cantidadcargada1,cantidadcargada2,cantidadcargada3,cantidadcargada4,cantidadcargada5,cantidadcargada6,
                    cantidadcargada7,cantidadcargada8,cantidadcargada9,cantidadcargada10;
    private TextView cantidad96st1,cantidad96st2,cantidad96st3,cantidad96st4,cantidad96st5,cantidad96st6,cantidad96st7,
                    cantidad96st8,cantidad96st9,cantidad96st10;
    private TextView diferencia1,diferencia2,diferencia3,diferencia4,diferencia5,diferencia6,diferencia7,diferencia8,
                    diferencia9,diferencia10;
    private TextView voltotalplaca1,voltotalplaca2,voltotalplaca3,voltotalplaca4,voltotalplaca5,voltotalplaca6,voltotalplaca7,
                    voltotalplaca8,voltotalplaca9,voltotalplaca10;
    private TextView tag1,tag2,tag3,tag4,tag5,tag6,tag7,tag8,tag9,tag10;

    private CheckBox inspeccionada,favorable,desfavorable,bloqueo,revisada,inspeccioncamara;
    private TextView fecha_desfavorable,fecha_bloqueo,fecha_revisada;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private InspeccionViewModel inspeccionViewModel;
    private InspeccionEntity inspeccionEntity;
    private List<InspeccionEntity> inspeccionEntity2 = new ArrayList<>();

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;

    private TextView header_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_inspeccion);
        Intent intent = new Intent();
        setToolbar();
        //matT = intent.getStringExtra("tractora");
        //matC = intent.getStringExtra("cisterna");
        inspeccion = getIntent().getExtras().getString("inspeccion");
        lanzarViewModel();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        View header = navigationView.getHeaderView(0);
        header_name = header.findViewById(R.id.header_name);
        header_name.setText(prefs.getString("user","User"));

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;
                Intent i = new Intent();

                switch (item.getItemId()){
                    case R.id.menu_dashboard:
                        i.setClass(ResultadoInspeccionActivity.this, MenuActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new DashboardFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscari:
                        i.setClass(ResultadoInspeccionActivity.this, BuscarInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new BuscarInspeccionFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscarv:
                        i.setClass(ResultadoInspeccionActivity.this, BuscarVehiculoActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_nuevai:
                        i.setClass(ResultadoInspeccionActivity.this, CabeceraInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);

                        break;
                    case R.id.menu_logout:
                        logOut();
                        return true;
                    case R.id.menu_forget_logout:
                        removeSharedPreferences();
                        logOut();
                        return true;
                }

                if(fragmentTransaction){
                    changeFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });



        nuevaInspeccionres = findViewById(R.id.nueva_inspeccionres);
        tv_inspectorres = findViewById(R.id.tv_inspectorres);
        tv_instalacionres = findViewById(R.id.tv_instalacionres);
        tv_desinstalacionres = findViewById(R.id.tv_desinstalacionres);
        tv_transportistares = findViewById(R.id.tv_transportistares);
        albaranres = findViewById(R.id.tv_albaranres);
        fechaarnesres = findViewById(R.id.tv_fechaarnesres);
        empresacalibracion = findViewById(R.id.tv_empresacalibradorares);
        tractora = findViewById(R.id.tv_tractorainspeccionres1);
        rigido = findViewById(R.id.tv_rigidoinspeccionres);
        cisterna = findViewById(R.id.tv_cisternainspeccionres);
        fechacalibracionrig = findViewById(R.id.tv_fechacalibracionrigidores);
        fechacalibracioncis = findViewById(R.id.tv_fechacalibracioncisternares);
        codconductor = findViewById(R.id.tv_codconductorres);
        nombrecond = findViewById(R.id.tv_nombreconductorres);
        suministrador = findViewById(R.id.tv_suministradorres);
        pesoentrada = findViewById(R.id.tv_pesoentradares1);
        pesosalida = findViewById(R.id.tv_pesosalidares1);
        permisocir = findViewById(R.id.permiso_conducir);
        adrcond = findViewById(R.id.adr_conductorres);
        adrtract = findViewById(R.id.adrtractorares);
        adrcist = findViewById(R.id.adrcisternares);
        itvtract = findViewById(R.id.itv_tractorares);
        itvcist = findViewById(R.id.itvcisternares);
        fichaseguridad = findViewById(R.id.ficha_seguridadres);
        transpondert = findViewById(R.id.transpondertractorares);
        transponderc = findViewById(R.id.transpondercisternares);
        superficieantides = findViewById(R.id.cb_superficiesuperiorres);
        posicionvehiculo = findViewById(R.id.cb_posicionvehiculores);
        freno = findViewById(R.id.cb_frenoestacionamientores);
        baterias = findViewById(R.id.cb_bateriasres);
        apagallamas = findViewById(R.id.cb_apagallamasres);
        movil = findViewById(R.id.cb_movilres);
        interruptor = findViewById(R.id.cb_interruptoresres);
        tomatierra = findViewById(R.id.cb_scullyres);
        manguera = findViewById(R.id.cb_manguera_gasesres);
        purgacomp = findViewById(R.id.cb_purgares);
        ropa = findViewById(R.id.cb_ropares);
        tc2 = findViewById(R.id.cb_tc2res);
        montajetags = findViewById(R.id.montajetagsres);
        bajadatags = findViewById(R.id.cb_bajadatagsres);
        lecturatags = findViewById(R.id.cb_lecturatagsisletares);
        estanqueidadcist = findViewById(R.id.cb_estanqueidadcisternares);
        estanqueidadapi = findViewById(R.id.cb_estanqueidadvalvulasapires);
        estanqueidadcajonres = findViewById(R.id.cb_estanqueidadcajonres);
        estanqueidadvalvfondo = findViewById(R.id.cb_estanqueidadvalvulasfondores);
        estanqueidadequipotras = findViewById(R.id.cb_estanqueidadequipostrasiegosres);
        recogeralbaran = findViewById(R.id.cb_recogealbaranres);
        alturarealsonda1 = findViewById(R.id.alturarealsonda1);
        alturarealsonda2 = findViewById(R.id.alturarealsonda2);
        alturarealsonda3 = findViewById(R.id.alturarealsonda3);
        alturarealsonda4 = findViewById(R.id.alturarealsonda4);
        alturarealsonda5 = findViewById(R.id.alturarealsonda5);
        alturarealsonda6 = findViewById(R.id.alturarealsonda6);
        alturarealsonda7 = findViewById(R.id.alturarealsonda7);
        alturarealsonda8 = findViewById(R.id.alturarealsonda8);
        altura96sonda1 = findViewById(R.id.altura96sonda1);
        altura96sonda2 = findViewById(R.id.altura96sonda2);
        altura96sonda3 = findViewById(R.id.altura96sonda3);
        altura96sonda4 = findViewById(R.id.altura96sonda4);
        altura96sonda5 = findViewById(R.id.altura96sonda5);
        altura96sonda6 = findViewById(R.id.altura96sonda6);
        altura96sonda7 = findViewById(R.id.altura96sonda7);
        altura96sonda8 = findViewById(R.id.altura96sonda8);
        cantidadcargada1 = findViewById(R.id.cantidadcargada1);
        cantidadcargada2 = findViewById(R.id.cantidadcargada2);
        cantidadcargada3 = findViewById(R.id.cantidadcargada3);
        cantidadcargada4 = findViewById(R.id.cantidadcargada4);
        cantidadcargada5 = findViewById(R.id.cantidadcargada5);
        cantidadcargada6 = findViewById(R.id.cantidadcargada6);
        cantidadcargada7 = findViewById(R.id.cantidadcargada7);
        cantidadcargada8 = findViewById(R.id.cantidadcargada8);
        cantidad96st1 = findViewById(R.id.cantidad96st1);
        cantidad96st2 = findViewById(R.id.cantidad96st2);
        cantidad96st3 = findViewById(R.id.cantidad96st3);
        cantidad96st4 = findViewById(R.id.cantidad96st4);
        cantidad96st5 = findViewById(R.id.cantidad96st5);
        cantidad96st6 = findViewById(R.id.cantidad96st6);
        cantidad96st7 = findViewById(R.id.cantidad96st7);
        cantidad96st8 = findViewById(R.id.cantidad96st8);
        diferencia1 = findViewById(R.id.diferencia1);
        diferencia2 = findViewById(R.id.diferencia2);
        diferencia3 = findViewById(R.id.diferencia3);
        diferencia4 = findViewById(R.id.diferencia4);
        diferencia5 = findViewById(R.id.diferencia5);
        diferencia6 = findViewById(R.id.diferencia6);
        diferencia7 = findViewById(R.id.diferencia7);
        diferencia8 = findViewById(R.id.diferencia8);
        voltotalplaca1 = findViewById(R.id.voltotalplaca1);
        voltotalplaca2 = findViewById(R.id.voltotalplaca2);
        voltotalplaca3 = findViewById(R.id.voltotalplaca3);
        voltotalplaca4 = findViewById(R.id.voltotalplaca4);
        voltotalplaca5 = findViewById(R.id.voltotalplaca5);
        voltotalplaca6 = findViewById(R.id.voltotalplaca6);
        voltotalplaca7 = findViewById(R.id.voltotalplaca7);
        voltotalplaca8 = findViewById(R.id.voltotalplaca8);
        tag1 = findViewById(R.id.tag1);
        tag2 = findViewById(R.id.tag2);
        tag3 = findViewById(R.id.tag3);
        tag4 = findViewById(R.id.tag4);
        tag5 = findViewById(R.id.tag5);
        tag6 = findViewById(R.id.tag6);
        tag7 = findViewById(R.id.tag7);
        tag8 = findViewById(R.id.tag8);
        inspeccionada = findViewById(R.id.inspeccionadares);
        favorable = findViewById(R.id.favorableres);
        desfavorable = findViewById(R.id.desfavorableres);
        fecha_desfavorable = findViewById(R.id.fecha_desfavorableres1);
        bloqueo = findViewById(R.id.bloqueores);
        fecha_bloqueo = findViewById(R.id.fecha_bloqueores);
        revisada = findViewById(R.id.revisadares);
        fecha_revisada = findViewById(R.id.fecha_revisadares);
        inspeccioncamara = findViewById(R.id.camarares);


        buscarInspeccion(inspeccion);
//

    }

    private void asignarDatos() {
        nuevaInspeccionres.setText(inspeccionEntity.getInspeccion());
        tv_inspectorres.setText(inspeccionEntity.getCodigo_inspector());
        tv_instalacionres.setText(inspeccionEntity.getInstalacion());
        tv_desinstalacionres.setText("ponder desinst");
        tv_transportistares.setText(inspeccionEntity.getTransportista());
        albaranres.setText(inspeccionEntity.getAlbaran());
        fechaarnesres.setText(inspeccionEntity.getFecha_arnes().toString());
        empresacalibracion.setText(inspeccionEntity.getEmpresa_tabla_cal());
        if(!inspeccionEntity.getTractora().isEmpty()) {
            tractora.setText(inspeccionEntity.getTractora());
        }
        if(!inspeccionEntity.getRigido().isEmpty()){
            rigido.setText(inspeccionEntity.getRigido());
            fechacalibracionrig.setText(inspeccionEntity.getFecha_tabla_cal_rigido().toString());
        }
        if(!inspeccionEntity.getCisterna().isEmpty()){
            cisterna.setText(inspeccionEntity.getCisterna());
            fechacalibracioncis.setText(inspeccionEntity.getFecha_tabla_cal_cisterna().toString());
        }
        if(String.valueOf(inspeccionEntity.getConductor()).isEmpty()) {
            codconductor.setText("");
        }else{
            codconductor.setText(String.valueOf(inspeccionEntity.getConductor()));
        }
        suministrador.setText(inspeccionEntity.getSuministrador());
        if(String.valueOf(inspeccionEntity.getPeso_entrada()).isEmpty()){
            pesoentrada.setText("");
        }else{
            pesoentrada.setText(String.valueOf(inspeccionEntity.getPeso_entrada()));
        }
        if(String.valueOf(inspeccionEntity.getPeso_salida()).isEmpty()){
            pesosalida.setText("");
        }else{
            pesosalida.setText(String.valueOf(inspeccionEntity.getPeso_entrada()));
        }
        permisocir.setChecked(inspeccionEntity.isPermiso_cond());
        adrcond.setChecked(inspeccionEntity.isAdr_cond());
        adrtract.setChecked(inspeccionEntity.isAdr_tractora_rigido());
        adrcist.setChecked(inspeccionEntity.isAdr_cisterna());
        itvtract.setChecked(inspeccionEntity.isItv_tractora_rigido());
        itvcist.setChecked(inspeccionEntity.isItv_cisterna());
        fichaseguridad.setChecked(inspeccionEntity.isFicha_seguridad());
        transpondert.setChecked(inspeccionEntity.isTransponder_tractora());
        transponderc.setChecked(inspeccionEntity.isTransponder_cisterna());
        superficieantides.setChecked(inspeccionEntity.isSuperficie_antideslizante());
        posicionvehiculo.setChecked(inspeccionEntity.isPosicionamiento_isleta());
        freno.setChecked(inspeccionEntity.isAccionamiento_freno());
        baterias.setChecked(inspeccionEntity.isAccionamiento_desconexion_bateria());
        apagallamas.setChecked(inspeccionEntity.isApagallamas());
        movil.setChecked(inspeccionEntity.isMovil_desconectado());
        interruptor.setChecked(inspeccionEntity.isInterruptores_emergencia());
        tomatierra.setChecked(inspeccionEntity.isToma_tierra());
        manguera.setChecked(inspeccionEntity.isManguera_gases());
        purgacomp.setChecked(inspeccionEntity.isPurga_compartimentos());
        ropa.setChecked(inspeccionEntity.isRopa());
        tc2.setChecked(inspeccionEntity.isTc2());
        montajetags.setChecked(inspeccionEntity.isMontaje_tag_ok());
        bajadatags.setChecked(inspeccionEntity.isBajada_tag_planta());
        lecturatags.setChecked(inspeccionEntity.isLectura_tag_isleta());
        estanqueidadcist.setChecked(inspeccionEntity.isEstanqueidad_cisterna());
        estanqueidadapi.setChecked(inspeccionEntity.isEstanqueidad_valvulas_api());
        estanqueidadcajonres.setChecked(inspeccionEntity.isEstanqueidad_cajon_valvulas());
        estanqueidadvalvfondo.setChecked(inspeccionEntity.isEstanqueidad_valvulas_fondo());
        estanqueidadequipotras.setChecked(inspeccionEntity.isEstanqueidad_equipo_trasiego());
        recogeralbaran.setChecked(inspeccionEntity.isRecoger_albaran());

        alturarealsonda1.setText(inspeccionEntity.getC1_altura_real_sonda());
        alturarealsonda2.setText(inspeccionEntity.getC2_altura_real_sonda());
        alturarealsonda3.setText(inspeccionEntity.getC3_altura_real_sonda());
        alturarealsonda4.setText(inspeccionEntity.getC4_altura_real_sonda());
        alturarealsonda5.setText(inspeccionEntity.getC5_altura_real_sonda());
        alturarealsonda6.setText(inspeccionEntity.getC6_altura_real_sonda());
        alturarealsonda7.setText(inspeccionEntity.getC7_altura_real_sonda());
        alturarealsonda8.setText(inspeccionEntity.getC8_altura_real_sonda());
        altura96sonda1.setText(inspeccionEntity.getC1_altura_sonda96());
        altura96sonda2.setText(inspeccionEntity.getC2_altura_sonda96());
        altura96sonda3.setText(inspeccionEntity.getC3_altura_sonda96());
        altura96sonda4.setText(inspeccionEntity.getC4_altura_sonda96());
        altura96sonda5.setText(inspeccionEntity.getC5_altura_sonda96());
        altura96sonda6.setText(inspeccionEntity.getC6_altura_sonda96());
        altura96sonda7.setText(inspeccionEntity.getC7_altura_sonda96());
        altura96sonda8.setText(inspeccionEntity.getC8_altura_sonda96());
        cantidadcargada1.setText(inspeccionEntity.getC1_cantidad_cargada());
        cantidadcargada2.setText(inspeccionEntity.getC2_cantidad_cargada());
        cantidadcargada3.setText(inspeccionEntity.getC3_cantidad_cargada());
        cantidadcargada4.setText(inspeccionEntity.getC4_cantidad_cargada());
        cantidadcargada5.setText(inspeccionEntity.getC5_cantidad_cargada());
        cantidadcargada6.setText(inspeccionEntity.getC6_cantidad_cargada());
        cantidadcargada7.setText(inspeccionEntity.getC7_cantidad_cargada());
        cantidadcargada8.setText(inspeccionEntity.getC8_cantidad_cargada());
        cantidad96st1.setText(inspeccionEntity.getC1_cantidad_96st());
        cantidad96st2.setText(inspeccionEntity.getC2_cantidad_96st());
        cantidad96st3.setText(inspeccionEntity.getC3_cantidad_96st());
        cantidad96st4.setText(inspeccionEntity.getC4_cantidad_96st());
        cantidad96st5.setText(inspeccionEntity.getC5_cantidad_96st());
        cantidad96st6.setText(inspeccionEntity.getC6_cantidad_96st());
        cantidad96st7.setText(inspeccionEntity.getC7_cantidad_96st());
        cantidad96st8.setText(inspeccionEntity.getC8_cantidad_96st());
        diferencia1.setText(inspeccionEntity.getC1_diferencia());
        diferencia2.setText(inspeccionEntity.getC2_diferencia());
        diferencia3.setText(inspeccionEntity.getC3_diferencia());
        diferencia4.setText(inspeccionEntity.getC4_diferencia());
        diferencia5.setText(inspeccionEntity.getC5_diferencia());
        diferencia6.setText(inspeccionEntity.getC6_diferencia());
        diferencia7.setText(inspeccionEntity.getC7_diferencia());
        diferencia8.setText(inspeccionEntity.getC8_diferencia());
        if(String.valueOf(inspeccionEntity.getC1_vol_total_placa()).isEmpty())
            voltotalplaca1.setText("");
        else{
            voltotalplaca1.setText(String.valueOf(inspeccionEntity.getC1_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC2_vol_total_placa()).isEmpty())
            voltotalplaca2.setText("");
        else{
            voltotalplaca2.setText(String.valueOf(inspeccionEntity.getC2_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC3_vol_total_placa()).isEmpty())
            voltotalplaca3.setText("");
        else{
            voltotalplaca3.setText(String.valueOf(inspeccionEntity.getC3_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC4_vol_total_placa()).isEmpty())
            voltotalplaca4.setText("");
        else{
            voltotalplaca4.setText(String.valueOf(inspeccionEntity.getC4_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC5_vol_total_placa()).isEmpty())
            voltotalplaca5.setText("");
        else{
            voltotalplaca5.setText(String.valueOf(inspeccionEntity.getC5_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC6_vol_total_placa()).isEmpty())
            voltotalplaca6.setText("");
        else{
            voltotalplaca6.setText(String.valueOf(inspeccionEntity.getC6_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC7_vol_total_placa()).isEmpty())
            voltotalplaca7.setText("");
        else{
            voltotalplaca7.setText(String.valueOf(inspeccionEntity.getC7_vol_total_placa()));
        }
        if(String.valueOf(inspeccionEntity.getC8_vol_total_placa()).isEmpty())
            voltotalplaca8.setText("");
        else{
            voltotalplaca8.setText(String.valueOf(inspeccionEntity.getC8_vol_total_placa()));
        }
        if(!String.valueOf(inspeccionEntity.getC1_tag()).isEmpty()){
            tag1.setText(String.valueOf(inspeccionEntity.getC1_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC2_tag()).isEmpty()){
            tag2.setText(String.valueOf(inspeccionEntity.getC2_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC3_tag()).isEmpty()){
            tag3.setText(String.valueOf(inspeccionEntity.getC3_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC4_tag()).isEmpty()){
            tag4.setText(String.valueOf(inspeccionEntity.getC4_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC5_tag()).isEmpty()){
            tag5.setText(String.valueOf(inspeccionEntity.getC5_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC6_tag()).isEmpty()){
            tag6.setText(String.valueOf(inspeccionEntity.getC6_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC7_tag()).isEmpty()){
            tag7.setText(String.valueOf(inspeccionEntity.getC7_tag()));
        }
        if(!String.valueOf(inspeccionEntity.getC8_tag()).isEmpty()){
            tag8.setText(String.valueOf(inspeccionEntity.getC8_tag()));
        }

        inspeccionada.setChecked(inspeccionEntity.isInspeccionada());
        favorable.setChecked(inspeccionEntity.isFavorable());
        desfavorable.setChecked(inspeccionEntity.isDesfavorable());
        if(!inspeccionEntity.getFecha_desfavorable().toString().isEmpty()) {
            fecha_desfavorable.setText(inspeccionEntity.getFecha_desfavorable().toString());
        }
        if(!inspeccionEntity.getFecha_bloqueo().toString().isEmpty()){
            fecha_bloqueo.setText(inspeccionEntity.getFecha_bloqueo().toString());
        }
        bloqueo.setChecked(inspeccionEntity.isBloqueada());
        fecha_bloqueo.setText(inspeccionEntity.getFecha_bloqueo().toString());
        //revisada.setChecked(inspeccionEntity.isRevisado());
        inspeccioncamara.setChecked(inspeccionEntity.isInspeccion_camara());
    }


    private void lanzarViewModel() {
        inspeccionViewModel = ViewModelProviders.of(this).get(InspeccionViewModel.class);
    }

    private void buscarInspeccion(String inspeccion){
       // Toast.makeText(getApplicationContext(), "inspeccion: " + inspeccion, Toast.LENGTH_SHORT).show();

        inspeccionViewModel.findInspeccionByInspeccion2("%" + inspeccion + "%").observe(this, new Observer<List<InspeccionEntity>>() {
            @Override
            public void onChanged(List<InspeccionEntity> inspeccionEntities) {
                if(inspeccionEntities.size()>0) {
                    inspeccionEntity2 = inspeccionEntities;
                    inspeccionEntity = inspeccionEntity2.get(0);
                    asignarDatos();
                }else{
                    Toast.makeText(getApplicationContext(), "No se ha recuperado ninguna inspección", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //inspeccionEntity = inspeccionViewModel.findInspeccionByInspeccion("%" + inspeccion + "%");
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment( new BuscarInspeccionFragment(), navigationView.getMenu().getItem(2));
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.buscarinspeccionfragment,fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private void removeSharedPreferences(){
        prefs.edit().clear().apply();
    }

    /*
    @Override
    public void seleccionarinspeccion(String inspeccion) {
        Toast.makeText(this, "inspeccion: " + inspeccion, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("inspeccion", inspeccion);
        intent.setClass(this, ResultadoInspeccionActivity.class);
        startActivity(intent);
    }

     */
}
