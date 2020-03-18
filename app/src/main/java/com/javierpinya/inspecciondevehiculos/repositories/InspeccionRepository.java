package com.javierpinya.inspecciondevehiculos.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.dao.InspeccionDao;
import com.javierpinya.inspecciondevehiculos.database.AppDatabase;

import java.util.List;

public class InspeccionRepository {
    private InspeccionDao inspeccionDao;

    public InspeccionRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        inspeccionDao = db.inspeccionDao();
    }

    public LiveData<List<InspeccionEntity>> findAllInspecciones(){
        return inspeccionDao.findAllInspecciones();
    }

    public int getRowCount(String cod_inspector){
        return inspeccionDao.getRowCount(cod_inspector);
    }

    public InspeccionEntity findInspeccionByInspeccion(String inspeccion){
        return inspeccionDao.findInspeccionByInspeccion(inspeccion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInspeccion2(String inspeccion){
        return inspeccionDao.findInspeccionByInspeccion2(inspeccion);
    }


    public LiveData<List<InspeccionEntity>> findInspeccionByTRCI(String tractora, String cisterna){
        return inspeccionDao.findInspeccionByTRCI(tractora, cisterna);
    }

    public void insert (InspeccionEntity usuarioEntity){
        new insertAsyncTask(inspeccionDao).execute(usuarioEntity);
    }

    private static class insertAsyncTask extends AsyncTask<InspeccionEntity, Void, Void> {

        private InspeccionDao asyncTaskDao;

        insertAsyncTask(InspeccionDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(InspeccionEntity... inspeccionEntities) {
            asyncTaskDao.insert(inspeccionEntities[0]);
            return null;
        }
    }
}
