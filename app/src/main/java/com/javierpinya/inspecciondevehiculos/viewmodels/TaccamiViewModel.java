package com.javierpinya.inspecciondevehiculos.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.repositories.TaccamiRepository;

import java.util.List;

public class TaccamiViewModel extends AndroidViewModel {

    private LiveData<List<TaccamiEntity>> allTaccami;
    private TaccamiRepository taccamiRepository;

    public TaccamiViewModel(Application application){
        super(application);

        taccamiRepository = new TaccamiRepository(application);
        allTaccami = taccamiRepository.findAllTaccami();
    }

    public TaccamiEntity findTaccamiByCodVehiculo(int cod_vehiculo){
        return taccamiRepository.findTaccamiByCodVehiculo(cod_vehiculo);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByTMatricula(String matricula){
        return taccamiRepository.findTaccamiByTMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByCMatricula(String matricula){
        return taccamiRepository.findTaccamiByCMatricula(matricula);
    }

    public LiveData<List<TaccamiEntity>> findTaccamiByTCMat(String tractora, String cisterna){
        return taccamiRepository.findTaccamiByTCMat(tractora, cisterna);
    }

    public LiveData<List<TaccamiEntity>> findAllVehiculos(){
        return taccamiRepository.findAllTaccami();
    }

    public int insertarVehiculo(TaccamiEntity taccamiEntity){
        taccamiRepository.insertTaccami(taccamiEntity);
        return 1;
    }

    public void updateVehiculo(TaccamiEntity taccamiEntity){
        taccamiRepository.updateTaccamiById(taccamiEntity);
    }

    public void deleteTaccamiById(TaccamiEntity taccamiEntity){
        taccamiRepository.deleteTaccamiById(taccamiEntity);
    }

    public void deleteAllTaccami(){
        taccamiRepository.deleteAllTaccami();
    }

    public int getRowCount(){
        return taccamiRepository.getRowCount();
    }

}

