package com.javierpinya.inspecciondevehiculos.fragments.resultadoBuscarVehiculos;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.TacprcoEntity;
import com.javierpinya.inspecciondevehiculos.database.AppDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarTractoraFragment extends Fragment {

    private String tractora;
    private TacprcoEntity tacprcoEntity;
    private BuscarAsyncTask buscarAsyncTask;
    private TextView matricula, tipo,chip,adr,itv,tara,mma,sologas,transresp,queroseno,bloqueado;
    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");



    public ResultadoBuscarTractoraFragment(String tractora) {
        this.tractora = tractora;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_buscar_tractora, container, false);
        matricula = view.findViewById(R.id.tv_tractoramatricula);
        tipo = view.findViewById(R.id.tv_tipotractora1);
        chip = view.findViewById(R.id.tv_chiptractora1);
        adr = view.findViewById(R.id.tv_adrtractora1);
        itv = view.findViewById(R.id.tv_itvtractora1);
        tara = view.findViewById(R.id.tv_taratractora1);
        mma = view.findViewById(R.id.tv_mmatractora1);
        sologas = view.findViewById(R.id.tv_sologasoleostractora1);
        transresp = view.findViewById(R.id.tv_transportistaresp1);
        queroseno = view.findViewById(R.id.tv_querosenos1);
        bloqueado = view.findViewById(R.id.tv_Bloqueadotractora1);
        buscarAsyncTask = new BuscarAsyncTask();
        buscarAsyncTask.execute();

        return view;
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, TacprcoEntity> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected TacprcoEntity doInBackground(Void... voids) {
            tacprcoEntity = AppDatabase.getDatabase(getActivity()).tacprcoDao().findTacprcoByOneMatricula(tractora);
            return tacprcoEntity;
        }

        @Override
        protected void onPostExecute(TacprcoEntity tacprco) {
            Date fadr;
            Date fitv;
            fadr = tacprco.getFec_cadu_adr();
            fitv = tacprco.getFec_cadu_itv();
            String dfAdr = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK).format(fadr);
            String dfItv = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.UK).format(fitv);
            matricula.setText(tacprco.getMatricula());
            tipo.setText(tacprco.getTipo());
            chip.setText(String.valueOf(tacprco.getChip()));
            adr.setText(dfAdr);
            itv.setText(dfItv);
            tara.setText(String.valueOf(tacprco.getTara()));
            mma.setText(String.valueOf(tacprco.getPeso_maximo()));
            transresp.setText("-");
            sologas.setText(String.valueOf(tacprco.isSolo_gasoleos()));
            queroseno.setText(String.valueOf(tacprco.isInd_queroseno()));
            bloqueado.setText(String.valueOf(tacprco.isInd_bloqueo()));
        }
    }

}
