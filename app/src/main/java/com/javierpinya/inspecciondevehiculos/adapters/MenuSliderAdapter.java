package com.javierpinya.inspecciondevehiculos.adapters;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.inspecciondevehiculos.fragments.menu.DashboardFragment;
import com.javierpinya.inspecciondevehiculos.fragments.menu.PerfilFragment;


public class MenuSliderAdapter extends FragmentPagerAdapter{

    private String tractora;

    public MenuSliderAdapter(FragmentManager fm, String tractora) {
        super(fm);
        this.tractora = tractora;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        switch (position){
            case 0:
                DashboardFragment dashboardFragment = new DashboardFragment();
                return dashboardFragment;
            case 1:
                PerfilFragment perfilFragment = new PerfilFragment();
                args.putString("tractora", tractora);
                perfilFragment.setArguments(args);
                return perfilFragment;

        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Menú Principal";
            case 1:
                return "Perfil";
        }
        return "0";
    }
}
