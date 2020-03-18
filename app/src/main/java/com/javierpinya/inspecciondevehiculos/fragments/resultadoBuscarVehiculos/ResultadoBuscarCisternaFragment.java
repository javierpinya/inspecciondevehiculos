package com.javierpinya.inspecciondevehiculos.fragments.resultadoBuscarVehiculos;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.database.AppDatabase;
import com.javierpinya.inspecciondevehiculos.clases.TacsecoEntity;
import com.javierpinya.inspecciondevehiculos.activities.CompartimentosActivity;
import com.javierpinya.inspecciondevehiculos.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarCisternaFragment extends Fragment {

    private String cisterna;
    private TacsecoEntity tacsecoEntity;
    private TextView matricula,tipo,chip,adr,itv,ejes,tara,mma, queroseno,tablacal,sologas,pesados,bloqueada;
    private Button compartimentos;
    private BuscarTacsecoAsyncTask buscarTacsecoAsyncTask;
    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");


    public ResultadoBuscarCisternaFragment(String cisterna) {
        // Required empty public constructor
        this.cisterna = cisterna;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_buscar_cisterna, container, false);
        matricula = view.findViewById(R.id.tv_cisternamatricula);
        tipo = view.findViewById(R.id.tv_tipocisterna1);
        chip = view.findViewById(R.id.tv_chipcisterna1);
        adr = view.findViewById(R.id.tv_adrcisterna1);
        itv = view.findViewById(R.id.tv_itvcisterna1);
        ejes = view.findViewById(R.id.tv_ejescisterna1);
        tara = view.findViewById(R.id.tv_taracisterna1);
        mma = view.findViewById(R.id.tv_mmacisterna1);
        queroseno = view.findViewById(R.id.tv_queroseno);
        tablacal = view.findViewById(R.id.tv_tablacalcisterna1);
        sologas = view.findViewById(R.id.tv_sologasoleoscisterna1);
        pesados = view.findViewById(R.id.tv_cargapesadoscisterna1);
        bloqueada = view.findViewById(R.id.tv_Bloqueadacisterna1);
        compartimentos = view.findViewById(R.id.tv_compartimentos);
        buscarTacsecoAsyncTask = new BuscarTacsecoAsyncTask();
        buscarTacsecoAsyncTask.execute();

        compartimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("cisterna", cisterna);
                intent.setClass(getContext(), CompartimentosActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private class BuscarTacsecoAsyncTask extends AsyncTask<Void, Integer, TacsecoEntity> {

        @Override
        protected TacsecoEntity doInBackground(Void... voids) {
            tacsecoEntity = AppDatabase.getDatabase(getActivity()).tacsecoDao().findTacsecoByOneMatricula(cisterna);
            return tacsecoEntity;
        }


        @Override
        protected void onPostExecute(TacsecoEntity tacsecoEntity) {

            Date fadr= new Date();
            Date fitv= new Date();
            Date ftabla= new Date();

            try {
                fadr = tacsecoEntity.getFec_cadu_adr().toString().isEmpty() ? parseador.parse("01/01/1980") : tacsecoEntity.getFec_cadu_adr();
                fitv = tacsecoEntity.getFec_cadu_itv().toString().isEmpty() ? parseador.parse("01/01/1980") : tacsecoEntity.getFec_cadu_itv();
                ftabla = tacsecoEntity.getFec_cadu_calibracion().toString().isEmpty() ? parseador.parse("01/01/1980") : tacsecoEntity.getFec_cadu_calibracion();
            }catch (ParseException e){
                Log.e("TAG Parse", e.toString());
            }

            assert fadr != null;
            String dfAdr = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE).format(fadr);
            assert fitv != null;
            String dfItv = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.FRANCE).format(fitv);
            assert ftabla != null;
            String dfTabla = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE).format(ftabla);

            matricula.setText(tacsecoEntity.getMatricula());
            tipo.setText(tacsecoEntity.getTipo());
            chip.setText(String.valueOf(tacsecoEntity.getChip()));
            adr.setText(dfAdr);
            itv.setText(dfItv);
            ejes.setText(String.valueOf(tacsecoEntity.getNum_ejes()));
            tara.setText(String.valueOf(tacsecoEntity.getTara()));
            mma.setText(String.valueOf(tacsecoEntity.getPeso_maximo()));
            queroseno.setText(String.valueOf(tacsecoEntity.getInd_queroseno()));
            bloqueada.setText(String.valueOf(tacsecoEntity.getInd_bloqueo()));
            tablacal.setText(dfTabla);
            sologas.setText(String.valueOf(tacsecoEntity.getInd_bloqueo()));
            pesados.setText(String.valueOf(tacsecoEntity.isInd_carga_pesados()));
        }
    }



}
