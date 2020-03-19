package com.javierpinya.inspecciondevehiculos.fragments.buscador;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.activities.ResultadoBuscarVehiculoActivity;
import com.javierpinya.inspecciondevehiculos.adapters.VehiculosAdapter;
import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccamiViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccatrViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarVehiculoFragment extends Fragment {
    private EditText primerComp;
    private EditText segundoComp;
    private Button buscar;
    private ProgressBar progressBar;
    private String primer="";
    private String segundo = "";
    private TaccamiViewModel taccamiViewModel;
    private TaccatrViewModel taccatrViewModel;
    private List<TaccamiEntity> taccamiList4 = new ArrayList<>();

    private List<Integer> bloqueadoTractoras = new ArrayList<>();
    private List<Integer> bloqueadoCisternas = new ArrayList<>();

    private List<String> matT = new ArrayList<>();
    private List<String> matC = new ArrayList<>();

    private List<Integer> vehiculoT = new ArrayList<>();
    private List<Integer> vehiculoC= new ArrayList<>();
    private List<Integer> vehiculo = new ArrayList<>();

    private BuscarAsyncTask buscarAsyncTask;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");

    public BuscarVehiculoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_vehiculo, container, false);
        primerComp = view.findViewById(R.id.etPrimerComp);
        segundoComp = view.findViewById(R.id.etSegundoComp);
        progressBar = view.findViewById(R.id.progressBar);
        buscar = view.findViewById(R.id.btnBuscarVehiculo);

        lanzarViewModel();

        //RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_resultadobuscarvehiculo);
        mLayoutManager = new LinearLayoutManager(getActivity());

        buscar.setOnClickListener(new View.OnClickListener(){
            int hola;
            @Override
            public void onClick(View v) {
                vehiculo.clear();
                vehiculoC.clear();
                vehiculoT.clear();
                matT.clear();
                matC.clear();
                bloqueadoCisternas.clear();
                bloqueadoTractoras.clear();
                progressBar.setVisibility(View.VISIBLE);
                primerComp.clearFocus();
                segundoComp.clearFocus();
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(primerComp.getWindowToken(), 0);
                buscarAsyncTask = new BuscarAsyncTask();

                primer = primerComp.getText().toString().trim();
                segundo = segundoComp.getText().toString().trim();

                if (primer.isEmpty() && segundo.isEmpty()){
                    Toast.makeText(getActivity(), "Introduzca una matrícula", Toast.LENGTH_SHORT).show();
                }else {
                    buscarAsyncTask.execute();
                }
            }

        });

        return view;
    }

    private int getRowCount(){
        int contador;
        contador =taccamiViewModel.getRowCount();
        return contador;
    }

    private void buscarTractoraCisterna(String tractora, String cisterna){
        taccamiViewModel.findTaccamiByTCMat("%" + tractora + "%", "%" + cisterna + "%").observe(getActivity(), new Observer<List<TaccamiEntity>>() {
            @Override
            public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    taccamiList4 = taccamiEntities;
            }
        });
    }

    private void lanzarViewModel() {
        taccamiViewModel = ViewModelProviders.of(getActivity()).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(getActivity()).get(TaccatrViewModel.class);
    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
            buscarTractoraCisterna(primer,segundo);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=1;i<=1;i++){
                UnSegundo();
                publishProgress(i*50);
                if(isCancelled()){
                    break;
                }
            }

            if(taccamiList4.size()>0) {
                for (int i = 0; i < taccamiList4.size(); i++) {
                    matT.add(taccamiList4.get(i).getTractora());
                    if (taccamiList4.get(i).getCisterna().isEmpty()) {
                        matC.add("-");
                    } else {
                        matC.add(taccamiList4.get(i).getCisterna());
                    }
                }
                return true;
            }else{
                return false;
            }


        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            progressBar.setVisibility(View.GONE);
            if(resultado) {
                mAdapter = new VehiculosAdapter(matT, matC, R.layout.listview_resultado_buscar_vehiculos, new VehiculosAdapter.OnItemClickListener() {

                    @Override
                    public void onItemClick(String matT, String matC, int position) {
                        Intent intent = new Intent();
                        intent.putExtra("tractora", matT);
                        intent.putExtra("cisterna", matC);
                        intent.setClass(Objects.requireNonNull(getContext()), ResultadoBuscarVehiculoActivity.class);
                        startActivity(intent);
                    }
                });
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }else{
                Toast.makeText(getActivity(), "Sin datos sobre ese vehículo", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onCancelled(){
            super.onCancelled();
        }
    }
}
