package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.javierpinya.inspecciondevehiculos.R;

public class BuscarTodoActivity extends AppCompatActivity {

    private Button btncamion,btntrans,btnsimac,btnchip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_todo);

        btncamion = findViewById(R.id.buscarcamion);
        btntrans = findViewById(R.id.buscartrans);
        btnsimac = findViewById(R.id.buscarsimac);
        btnchip = findViewById(R.id.buscarchip);
        Intent intent = new Intent();

        btncamion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.setClass(BuscarTodoActivity.this, BuscarVehiculoActivity.class);
                startActivity(intent);
            }
        });

        btntrans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.setClass(BuscarTodoActivity.this, BuscarTransportistaActivity.class);
                startActivity(intent);
            }
        });

        btnsimac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.setClass(BuscarTodoActivity.this, BuscarSimacActivity.class);
                startActivity(intent);
            }
        });

        btnchip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.setClass(BuscarTodoActivity.this, BuscarChipActivity.class);
                startActivity(intent);
            }
        });
    }
}
