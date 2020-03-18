package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.CompartimentosInspeccionFragment;

public class CompartimentosInspeccionActivity extends AppCompatActivity implements CompartimentosInspeccionFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartimentos_inspeccion);

    }

    @Override
    public void sendData() {
        Intent intent = new Intent();
        intent.setClass(this,ValoracionInspeccionActivity.class);
        startActivity(intent);
    }
}
