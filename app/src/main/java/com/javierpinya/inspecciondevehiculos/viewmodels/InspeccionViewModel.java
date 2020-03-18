package com.javierpinya.inspecciondevehiculos.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.repositories.InspeccionRepository;

import java.util.List;

public class InspeccionViewModel extends AndroidViewModel {

    private InspeccionRepository inspeccionRepository;

    public InspeccionViewModel(@NonNull Application application) {
        super(application);

        inspeccionRepository = new InspeccionRepository(application);
    }

    public int getRowCount(String cod_inspector){
        return inspeccionRepository.getRowCount(cod_inspector);
    }

    public void insertarInspeccion(InspeccionEntity inspeccionEntity){
        inspeccionRepository.insert(inspeccionEntity);
    }

    public InspeccionEntity findInspeccionByInspeccion(String inspeccion){
        return inspeccionRepository.findInspeccionByInspeccion(inspeccion);
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByInspeccion2(String inspeccion){
        return inspeccionRepository.findInspeccionByInspeccion2(inspeccion);
    }

    public LiveData<List<InspeccionEntity>> findAllInspecciones(){
        return inspeccionRepository.findAllInspecciones();
    }

    public LiveData<List<InspeccionEntity>> findInspeccionByTRCI(String tractora, String cisterna){
        return inspeccionRepository.findInspeccionByTRCI(tractora, cisterna);
    }
}
