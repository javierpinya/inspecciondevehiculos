package com.javierpinya.inspecciondevehiculos.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.database.AppDatabase;
import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.dao.TaccamiDao;

import java.util.List;


public class TaccamiRepository {


    private TaccamiDao taccamiDao;

    public TaccamiRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        taccamiDao = db.taccamiDao();
    }

    public LiveData<List<TaccamiEntity>> findAllTaccami(){
        return taccamiDao.findAllTaccami();
    }

    public TaccamiEntity findTaccamiByCodVehiculo(int cod_vehiculo){
        return taccamiDao.findTaccamiByCodVehiculo(cod_vehiculo);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByTMatricula(String matricula){
        return taccamiDao.findTaccamiByTMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByCMatricula(String matricula){
        return taccamiDao.findTaccamiByCMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByTCMat(String tractora, String cisterna){
        return taccamiDao.findTaccamiByTCMatricula(tractora, cisterna);
    }

    public void insertTaccami(TaccamiEntity taccamiEntity){
        new insertAsyncTask(taccamiDao).execute(taccamiEntity);
    }

    private static class insertAsyncTask extends AsyncTask<TaccamiEntity, Void, Void>{

        private TaccamiDao asyncTaskDao;

        insertAsyncTask(TaccamiDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccamiEntity... taccamiEntities) {
            asyncTaskDao.insert(taccamiEntities[0]);
            return null;
        }
    }

    public void updateTaccamiById(TaccamiEntity taccamiEntity){
        new updateAsyncTask(taccamiDao).execute(taccamiEntity);
    }

    private static class updateAsyncTask extends AsyncTask<TaccamiEntity,Void, Void>{
        private TaccamiDao asyncTaskDao;

        updateAsyncTask(TaccamiDao dao){ asyncTaskDao = dao;}

        @Override
        protected Void doInBackground(TaccamiEntity... taccamiEntities) {
            asyncTaskDao.updateTaccamiById(taccamiEntities[0]);
            return null;
        }
    }

    public void deleteTaccamiById(TaccamiEntity taccamiEntity){
        new deleteAsyncTask(taccamiDao).execute(taccamiEntity);
    }

    private static class deleteAsyncTask extends AsyncTask<TaccamiEntity, Void, Void>{

        private TaccamiDao asyncTaskDao;

        deleteAsyncTask(TaccamiDao dao){asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccamiEntity... taccamiEntities) {
            asyncTaskDao.deleteTaccamiById(taccamiEntities[0]);
            return null;
        }
    }

    public void deleteAllTaccami(){
        new deleteAllAsyncTask(taccamiDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<TaccamiEntity, Void, Void>{

        private TaccamiDao asyncTaskDao;

        deleteAllAsyncTask(TaccamiDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccamiEntity... taccamiEntities) {
            asyncTaskDao.deleteAllTaccami();
            return null;
        }
    }

    public int getRowCount(){
        return taccamiDao.getRowCount();
    }

}
