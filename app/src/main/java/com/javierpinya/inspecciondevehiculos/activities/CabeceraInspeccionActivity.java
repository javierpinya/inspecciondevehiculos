package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.CabeceraInspeccionFragment;
import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.CompartimentosInspeccionFragment;

import java.util.ArrayList;
import java.util.List;

public class CabeceraInspeccionActivity extends AppCompatActivity implements CabeceraInspeccionFragment.DataListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;
    private TextView header_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabecera_inspeccion);
        setToolbar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setFragmentByDefault();
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
                        i.setClass(CabeceraInspeccionActivity.this, MenuActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new DashboardFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscari:
                        i.setClass(CabeceraInspeccionActivity.this, BuscarInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new BuscarInspeccionFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscarv:
                        i.setClass(CabeceraInspeccionActivity.this, BuscarVehiculoActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_nuevai:
                        fragment = new CabeceraInspeccionFragment();
                        fragmentTransaction = true;

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
    }

    @Override
    public void sendData(List<String> cabecera, List<Boolean> checklist) {
        List<Integer> checklist_int = new ArrayList<>();

        Intent intent = new Intent();
        intent.setClass(this, CompartimentosInspeccionActivity.class);

        intent.putStringArrayListExtra("cabecera",(ArrayList<String>)cabecera);

        for (int i=0;i<checklist.size();i++) {
            checklist_int.add(checklist.get(i) ? 1 : 0);
        }
        intent.putIntegerArrayListExtra("checklist",(ArrayList<Integer>)checklist_int);
        startActivity(intent);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment( new CabeceraInspeccionFragment(), navigationView.getMenu().getItem(3));
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cabecera_inspeccion_fragment,fragment)
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
}
