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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.navigation.NavigationView;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.adapters.MenuSliderAdapter;
import com.javierpinya.inspecciondevehiculos.fragments.menu.DashboardFragment;
import com.javierpinya.inspecciondevehiculos.fragments.menu.PerfilFragment;

public class MenuActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;
    private TextView header_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setToolbar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MenuSliderAdapter(getSupportFragmentManager(), "hola");
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new CubeOutTransformer());
        setToolbar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        //setFragmentByDefault();
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
                        break;
                    case R.id.menu_buscari:
                        i.setClass(MenuActivity.this, BuscarInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_buscarv:
                        i.setClass(MenuActivity.this, BuscarVehiculoActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_nuevai:
                        i.setClass(MenuActivity.this, CabeceraInspeccionActivity.class);
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
                return true;
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
