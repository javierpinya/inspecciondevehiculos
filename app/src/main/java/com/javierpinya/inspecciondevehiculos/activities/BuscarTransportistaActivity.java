package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.adapters.VehiculosAdapter;
import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccamiViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccatrViewModel;

import java.util.ArrayList;
import java.util.List;

public class BuscarTransportistaActivity extends AppCompatActivity {

    private EditText trans;
    private Button btn;
    private String texto;
    private TaccatrViewModel taccatrViewModel;
    private TaccamiViewModel taccamiViewModel;
    private List<TaccamiEntity> taccamiList = new ArrayList<>();
    private List<Integer> vehiculo = new ArrayList<>();
    private List<String> matT = new ArrayList<>();
    private List<String> matC = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_transportista);

        trans = findViewById(R.id.etBuscarTransportista);
        btn = findViewById(R.id.btnBuscarTransportista);
        lanzarViewModel();

        mRecyclerView = (RecyclerView)findViewById(R.id.rv_resultadobuscartrans);
        mLayoutManager = new LinearLayoutManager(this);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (trans.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Introducir valor", Toast.LENGTH_SHORT).show();
                }else{
                    texto = trans.getText().toString().trim();
                    taccamiList.clear();
                    buscarTaccatr(texto);

                }
            }
        });
    }

    private void buscarTaccatr(String texto){
        taccatrViewModel.findTaccatrCodVehiculoByTrans("%" + texto + "%").observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                vehiculo = integers;
                for (int i=0;i<integers.size();i++) {
                    buscarTaccami(vehiculo.get(i));
                }
                display();
            }
        });
    }

    private void buscarTaccami(int texto) {
        taccamiList.add(taccamiViewModel.findTaccamiByCodVehiculo(texto));
    }

    private void display(){
        for (int i=0;i<taccamiList.size();i++){
            matT.add(taccamiList.get(i).getTractora());
            matC.add(taccamiList.get(i).getCisterna().isEmpty() ? "-" : taccamiList.get(i).getCisterna());
        }

        mAdapter = new VehiculosAdapter(matT, matC, R.layout.listview_resultado_buscar_vehiculos, new VehiculosAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(String matT, String matC, int position) {
                Intent intent = new Intent();
                intent.putExtra("tractora", matT);
                intent.putExtra("cisterna", matC);
                intent.setClass(BuscarTransportistaActivity.this, ResultadoBuscarVehiculoActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void lanzarViewModel(){
        taccamiViewModel = ViewModelProviders.of(this).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(this).get(TaccatrViewModel.class);
    }
}
