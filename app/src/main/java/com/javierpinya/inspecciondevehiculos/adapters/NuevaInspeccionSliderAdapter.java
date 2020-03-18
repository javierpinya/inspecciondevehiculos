package com.javierpinya.inspecciondevehiculos.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion.*;

public class NuevaInspeccionSliderAdapter extends FragmentPagerAdapter {

    public NuevaInspeccionSliderAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                CabeceraInspeccionFragment cabeceraInspeccionFragment = new CabeceraInspeccionFragment();
                return cabeceraInspeccionFragment;
            case 1:
                CompartimentosInspeccionFragment compartimentosInspeccionFragment = new CompartimentosInspeccionFragment();
                return compartimentosInspeccionFragment;
            case 2:
                ValoracionInspeccionFragment valoracionInspeccionFragment = new ValoracionInspeccionFragment();
                return valoracionInspeccionFragment;
        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Cabecera";
            case 1:
                return "CheckList";
            case 2:
                return "Compartimentos";
            case 3:
                return "Fotos";
            case 4:
                return "Valoración";
        }
        return "0";
    }
}
