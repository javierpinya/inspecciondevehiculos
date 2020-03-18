package com.javierpinya.inspecciondevehiculos.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.adapters.CompartimentosAdapter;
import com.javierpinya.inspecciondevehiculos.clases.TplcprtEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.TplcprtViewModel;

import java.util.List;
import java.util.Objects;

public class CompartimentosActivity extends AppCompatActivity {

    private String cisterna;
    private List<TplcprtEntity> tplcprtEntity;
    private TplcprtViewModel tplcprtViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CompartimentosAsync compartimentosAsync;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartimentos);
        progressBar = findViewById(R.id.progressBar2);
        Intent intent = getIntent();
        cisterna = Objects.requireNonNull(intent.getStringExtra("cisterna")).trim();
        Log.d("compActivity-cist",cisterna);
        mRecyclerView = findViewById(R.id.rv_compartimentos);
        mLayoutManager = new LinearLayoutManager(this);
        tplcprtViewModel = ViewModelProviders.of(this).get(TplcprtViewModel.class);
        compartimentosAsync = new CompartimentosAsync();
        //buscarTplcprtAsyncTask = new CompartimentosFragment.BuscarTplcprtAsyncTask();
        //buscarTplcprtAsyncTask.execute();

        tplcprtViewModel.findTplcprtByMatricula(cisterna).observe(this, new Observer<List<TplcprtEntity>>() {
            @Override
            public void onChanged(List<TplcprtEntity> tplcprtEntities) {
                if(tplcprtEntities.size()<1){
                    Log.d("CompActivity","Sin Resultados");
                    Toast.makeText(getApplicationContext(),"Sin resultados de compartimentos", Toast.LENGTH_SHORT).show();
                }else {
                    tplcprtEntity = tplcprtEntities;
                    compartimentosAsync.execute();
                }
            }
        });

    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    private class CompartimentosAsync extends AsyncTask <Void,Integer,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=1;i<2;i++){
                UnSegundo();
                publishProgress(i*50);
                if(isCancelled()){
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean ok) {
            super.onPostExecute(ok);
            progressBar.setVisibility(View.GONE);
            if(ok) {
                Log.d("tplcprt:", tplcprtEntity.get(0).getCod_tag_cprt());
                mAdapter = new CompartimentosAdapter(tplcprtEntity, R.layout.listview_compartimentos_item);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onCancelled(){
            super.onCancelled();

        }
    }

}
