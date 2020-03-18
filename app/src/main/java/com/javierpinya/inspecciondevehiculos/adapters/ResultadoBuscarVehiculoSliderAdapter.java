package com.javierpinya.inspecciondevehiculos.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.inspecciondevehiculos.fragments.resultadoBuscarVehiculos.*;


public class ResultadoBuscarVehiculoSliderAdapter extends FragmentPagerAdapter {

    private String tractora;
    private String cisterna;


    public ResultadoBuscarVehiculoSliderAdapter(FragmentManager fm, String tractora, String cisterna){
        super (fm);
        this.tractora = tractora;
        this.cisterna = cisterna;
    }


    @Override
    public int getCount() {
        if (!cisterna.equals("-")){
            return 2;
        }else {
            return 1;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ResultadoBuscarTractoraFragment resultadoBuscarTractoraFragment= new ResultadoBuscarTractoraFragment(tractora);
                return resultadoBuscarTractoraFragment;
                /*
            case 1:
                ResultadoBuscarRigidoFragment resultadoBuscarRigidoFragment= new ResultadoBuscarRigidoFragment();
                return resultadoBuscarRigidoFragment;

                 */
            case 1:
                ResultadoBuscarCisternaFragment resultadoBuscarCisternaFragment = new ResultadoBuscarCisternaFragment(cisterna);
                return resultadoBuscarCisternaFragment;
            /*
            case 3:

                ResultadoBuscarConductorFragment resultadoBuscarConductorFragment = new ResultadoBuscarConductorFragment();
                return resultadoBuscarConductorFragment;

             */
        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tractora";
            case 1:
                return "Cisterna";
            /*case 3:
                return "Conductor";

             */
        }
        return "0";
    }


}
