package com.javierpinya.inspecciondevehiculos.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.database.AppDatabase;
import com.javierpinya.inspecciondevehiculos.clases.TacsecoEntity;
import com.javierpinya.inspecciondevehiculos.dao.TacsecoDao;

import java.util.List;

public class TacsecoRepository {

    private TacsecoDao tacsecoDao;

    public TacsecoRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        tacsecoDao = db.tacsecoDao();
    }

    public LiveData<List<TacsecoEntity>> findTacsecoByMatricula(String matricula){
        return tacsecoDao.findTacsecoByMatricula(matricula);
    }

    public TacsecoEntity findTacsecoByOneMatricula(String matricula){
        return tacsecoDao.findTacsecoByOneMatricula(matricula);
    }

    public LiveData<List<TacsecoEntity>> getAllTacseco(){
        return tacsecoDao.getAllTacseco();
    }

    public TacsecoEntity findTacsecoById(int id){
        return tacsecoDao.findTacsecoById(id);
    }

    public void updateTacsecoById(TacsecoEntity tacseco){
        new updateAsyncTask(tacsecoDao).execute(tacseco);
    }

    private static class updateAsyncTask extends AsyncTask<TacsecoEntity, Void, Void> {

        private TacsecoDao asyncTaskDao;

        updateAsyncTask(TacsecoDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TacsecoEntity... tacsecoEntities) {
            asyncTaskDao.updateTacsecoById(tacsecoEntities[0]);
            return null;
        }
    }

    public void insertTacseco(TacsecoEntity tacseco){
        new insertAsyncTask(tacsecoDao).execute(tacseco);
    }

    private static class insertAsyncTask extends AsyncTask<TacsecoEntity, Void, Void>{

        private TacsecoDao asyncTaskDao;

        insertAsyncTask(TacsecoDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TacsecoEntity... tacsecoEntities) {
            asyncTaskDao.insertTacseco(tacsecoEntities[0]);
            return null;
        }
    }

    public void deleteTacsecoById(TacsecoEntity tacseco){
        new deleteAsyncTask(tacsecoDao).execute(tacseco);
    }

    private static class deleteAsyncTask extends AsyncTask<TacsecoEntity, Void, Void>{

        private TacsecoDao asyncTaskDao;

        deleteAsyncTask(TacsecoDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TacsecoEntity... tacsecoEntities) {
            asyncTaskDao.deleteTacsecoById(tacsecoEntities[0]);
            return null;
        }
    }

    public void deleteAllTacseco(){ new deleteAllAsyncTask(tacsecoDao).execute();}

    private static class deleteAllAsyncTask extends AsyncTask<TacsecoEntity, Void, Void>{

        private TacsecoDao asyncTaskDao;

        deleteAllAsyncTask(TacsecoDao dao){ asyncTaskDao = dao;}

        @Override
        protected Void doInBackground(TacsecoEntity... tacsecoEntities) {
            asyncTaskDao.deleteAllTacseco();
            return null;
        }
    }
}
