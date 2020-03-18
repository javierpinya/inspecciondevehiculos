package com.javierpinya.inspecciondevehiculos.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.FotosInspeccionFragment;

public class FotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        setFragmentByDefault();
    }

    private void setFragmentByDefault(){
        changeFragment( new FotosInspeccionFragment());
    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.foto_content_frame,fragment)
                .commit();
    }
}

