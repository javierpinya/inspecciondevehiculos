package com.javierpinya.inspecciondevehiculos.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.database.AppDatabase;
import com.javierpinya.inspecciondevehiculos.clases.TplcprtEntity;
import com.javierpinya.inspecciondevehiculos.dao.TplcprtDao;

import java.util.List;

public class TplcprtRepository {

    private TplcprtDao tplcprtDao;

    public TplcprtRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        tplcprtDao = db.tplcprtDao();
    }

    public LiveData<List<TplcprtEntity>> findTplcprtByMatricula(String cisterna){
        return tplcprtDao.findTplcprtByMatricula(cisterna);
    }

    public LiveData<List<TplcprtEntity>> findTplcprtByTag(int tag){
        return tplcprtDao.findTplcprtByTag(tag);
    }

    public void insertTplcprt(TplcprtEntity tplcprtEntity){
        new insertAsyncTask(tplcprtDao).execute(tplcprtEntity);
    }

    private static class insertAsyncTask extends AsyncTask<TplcprtEntity, Void, Void>{

        private TplcprtDao asyncTaskDao;

        insertAsyncTask(TplcprtDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TplcprtEntity... tplcprtEntities) {
            asyncTaskDao.insertTplcprt(tplcprtEntities[0]);
            return null;
        }
    }

    public void updateTplcprt(TplcprtEntity tplcprtEntity){
        new updateAsyncTask(tplcprtDao).execute(tplcprtEntity);
    }

    private static class updateAsyncTask extends AsyncTask<TplcprtEntity, Void, Void>{

        private TplcprtDao asyncTaskDao;

        updateAsyncTask(TplcprtDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TplcprtEntity... tplcprtEntities) {
            asyncTaskDao.updateTplcprtById(tplcprtEntities[0]);
            return null;
        }
    }

    public void deleteTplcprtById(TplcprtEntity tplcprtEntity){
        new deleteAsyncTask(tplcprtDao).execute(tplcprtEntity);
    }

    private static class deleteAsyncTask extends AsyncTask<TplcprtEntity, Void, Void>{

        private TplcprtDao asyncTaskDao;

        deleteAsyncTask(TplcprtDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TplcprtEntity... tplcprtEntities) {
            asyncTaskDao.deleteTplcprtById(tplcprtEntities[0]);
            return null;
        }
    }

    public void deleteAllTplcprt(){
        new deleteAllAsyncTask(tplcprtDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<TplcprtEntity, Void, Void>{

        private TplcprtDao asyncTaskDao;

        deleteAllAsyncTask(TplcprtDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TplcprtEntity... tplcprtEntities) {
            asyncTaskDao.deleteAllTplcprt();
            return null;
        }
    }
}
