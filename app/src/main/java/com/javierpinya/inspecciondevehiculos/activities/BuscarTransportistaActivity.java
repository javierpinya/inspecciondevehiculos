package com.javierpinya.inspecciondevehiculos.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.javierpinya.inspecciondevehiculos.R;

public class BuscarTransportistaActivity extends AppCompatActivity {

    private EditText trans;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_transportista);
    }
}
