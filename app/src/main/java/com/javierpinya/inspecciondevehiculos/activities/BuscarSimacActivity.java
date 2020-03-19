package com.javierpinya.inspecciondevehiculos.activities;

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
import com.javierpinya.inspecciondevehiculos.adapters.TagsAdapter;
import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.clases.TplcprtEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.TplcprtViewModel;

import java.util.ArrayList;
import java.util.List;

public class BuscarSimacActivity extends AppCompatActivity {

    private EditText simac;
    private Button btn;
    private String texto;
    private TplcprtViewModel tplcprtViewModel;
    private List<TplcprtEntity> tplcprtList = new ArrayList<>();
    private List<TaccamiEntity> taccamiList = new ArrayList<>();
    private List<Integer> vehiculo = new ArrayList<>();
    private List<String> mat = new ArrayList<>();
    private List<Integer> comp = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_simac);

        simac = findViewById(R.id.etBuscarSimac);
        btn = findViewById(R.id.btnBuscarSimac);

        lanzarViewModel();

        mRecyclerView = (RecyclerView)findViewById(R.id.rv_resultadobuscartrans);
        mLayoutManager = new LinearLayoutManager(this);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(simac.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Introducir valor", Toast.LENGTH_SHORT).show();
                }else{
                    tplcprtList.clear();
                    buscarSimac(Integer.parseInt(simac.getText().toString().trim()));
                }
            }
        });

    }

    private void lanzarViewModel(){
        ViewModelProviders.of(this).get(TplcprtViewModel.class);
    }

    private void buscarSimac(int tag){
        tplcprtViewModel.findTplcprtByTag(tag).observe(this, new Observer<List<TplcprtEntity>>() {
            @Override
            public void onChanged(List<TplcprtEntity> tplcprtEntities) {
                tplcprtList = tplcprtEntities;
                display();
            }
        });
    }

    private void display(){
        for(int i=0;i<tplcprtList.size();i++){
            mat.add(tplcprtList.get(i).getMatricula());
            comp.add(tplcprtList.get(i).getCod_compartimento());
        }
        mAdapter = new TagsAdapter(tplcprtList,R.layout.listview_tags);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
