package com.javierpinya.inspecciondevehiculos.activities;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.fragments.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.DataListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;
    private final int PERMISSION_REQUEST_STORAGE = 10;
    private boolean permiso_version_antigua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        permissions();
        //isExternalStorageWritable();

        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    private void saveOnPreferences(String user, String password, boolean recordar){
        if (recordar) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("user", user);
            editor.putString("pass", password);
            editor.apply();
        }
    }

    public void permissions(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_STORAGE);
        }else{
            permiso_version_antigua = ChekPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    private boolean ChekPermission(String permission){
        //Este método comprueba si el persmiso que se pasa está declarado o disponemos de el
        //Si el permiso está granted (está declarado con uses-permission) devolverá true.
        int result = this.checkCallingOrSelfPermission(permission);
        return result==PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if(requestCode == PERMISSION_REQUEST_STORAGE){
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permisos aceptados!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Persmisos rechazados!", Toast.LENGTH_SHORT).show();
                    }
                }

        }

    }

    @Override
    public void login(String user, String pass, boolean recordar) {
        saveOnPreferences(user, pass, recordar);
    }
}
