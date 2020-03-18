package com.javierpinya.inspecciondevehiculos.fragments.buscador;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
import com.javierpinya.inspecciondevehiculos.adapters.ListaBuscarInspeccionRecyclerViewAdapter;
import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.InspeccionViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarInspeccionFragment extends Fragment {

    private DataListener callback;
    private EditText conductor,inspector,ia,tractora,cisterna;
    private Button btnBuscarInspeccion;
    private ProgressBar progressBar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String cond,insp,instalacion,primercomp, segundocomp;
    private List<InspeccionEntity> listInspecciones;
    private List<String> list_trac = new ArrayList<>();
    private List<String> list_cist = new ArrayList<>();
    private List<String> list_ia = new ArrayList<>();
    private List<String> list_transportista = new ArrayList<>();

    //private BuscarInspeccionAsync buscarInspeccionAsync;
    private InspeccionViewModel inspeccionViewModel;
    private BuscarAsyncTask buscarAsyncTask;




    public BuscarInspeccionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        }catch(Exception e){
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
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
        View view  = inflater.inflate(R.layout.fragment_buscar_inspeccion, container, false);
        conductor = view.findViewById(R.id.etConductor);
        inspector = view.findViewById(R.id.etInspector);
        ia = view.findViewById(R.id.etInstalacion);
        tractora = view.findViewById(R.id.etPrimerComp);
        cisterna = view.findViewById(R.id.etSegundoComp);
        btnBuscarInspeccion = view.findViewById(R.id.btnBuscarInspeccion);
        lanzarViewModel();


        //lanzarViewModel();

        //RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_buscarinspeccion);
        mLayoutManager = new LinearLayoutManager(getActivity());

        btnBuscarInspeccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buscarAsyncTask = new BuscarAsyncTask();
                if(conductor.getText().toString().isEmpty() && inspector.getText().toString().isEmpty() && ia.getText().toString().isEmpty() && tractora.getText().toString().isEmpty() && cisterna.getText().toString().isEmpty()){
                    inspeccionViewModel.findAllInspecciones().observe(getActivity(), new Observer<List<InspeccionEntity>>() {
                        @Override
                        public void onChanged(List<InspeccionEntity> inspeccionEntities) {
                            listInspecciones = inspeccionEntities;
                            for(int i=0;i<listInspecciones.size();i++){
                                list_trac.add(listInspecciones.get(i).getTractora());
                                list_cist.add(listInspecciones.get(i).getCisterna());
                                list_ia.add(listInspecciones.get(i).getInstalacion());
                                list_transportista.add(listInspecciones.get(i).getTransportista());
                            }
                            mAdapter = new ListaBuscarInspeccionRecyclerViewAdapter(list_trac, list_cist, list_ia, list_transportista, R.layout.listview_resultado_buscar_inspeccion, new ListaBuscarInspeccionRecyclerViewAdapter.OnItemClickListener() {
                                @Override
                                public void OnItemClick(String tractora, String cisterna, String ia, String trans, int position) {
                                    callback.seleccionarinspeccion(list_transportista.get(position));
                                }
                            });
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mRecyclerView.setAdapter(mAdapter);
                        }
                    });
                }else{
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(cisterna.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(conductor.getWindowToken(),0);
                    imm.hideSoftInputFromWindow(tractora.getWindowToken(),0);
                    imm.hideSoftInputFromWindow(ia.getWindowToken(),0);
                    imm.hideSoftInputFromWindow(inspector.getWindowToken(),0);

                    cond = conductor.getText().toString().trim();
                    insp = inspector.getText().toString().trim();
                    instalacion = ia.getText().toString().trim();
                    primercomp = tractora.getText().toString().trim();
                    segundocomp = cisterna.getText().toString().trim();
                    buscarAsyncTask.execute();
                }
            }
        });

        return view;
    }

    private void buscarInspeccion(String tractora, String cisterna){
        inspeccionViewModel.findInspeccionByTRCI("%" + tractora + "%", "%" + cisterna + "%").observe(getActivity(), new Observer<List<InspeccionEntity>>() {
            @Override
            public void onChanged(List<InspeccionEntity> inspeccionEntities) {
                listInspecciones = inspeccionEntities;
            }
        });
    }


    private void lanzarViewModel() {
        inspeccionViewModel = ViewModelProviders.of(getActivity()).get(InspeccionViewModel.class);
    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            buscarInspeccion(primercomp, segundocomp);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=1;i<=2;i++){
                UnSegundo();
                publishProgress(i*50);
                if(isCancelled()){
                    break;
                }
            }
            if (listInspecciones.size()>0){
                for(int i=0;i<listInspecciones.size();i++){
                    list_trac.add(listInspecciones.get(i).getTractora());
                    list_cist.add(listInspecciones.get(i).getCisterna());
                    list_ia.add(listInspecciones.get(i).getInstalacion());
                    list_transportista.add(listInspecciones.get(i).getTransportista());
                    Log.d("tractora:", list_trac.get(list_cist.size()-1));
                }
                return true;
            }
            else{
                Toast.makeText(getActivity(), "Sin datos de inspecciones", Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean resultado) {
            if(resultado){
                mAdapter = new ListaBuscarInspeccionRecyclerViewAdapter(list_trac, list_cist, list_ia, list_transportista, R.layout.listview_resultado_buscar_inspeccion, new ListaBuscarInspeccionRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(String tractora, String cisterna, String ia,String trans, int position) {
                        callback.seleccionarinspeccion(list_transportista.get(position));
                    }
                });

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }else{
                Toast.makeText(getActivity(), "Sin resultados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public interface DataListener{
        void seleccionarinspeccion(String inspeccion);
    }

}
