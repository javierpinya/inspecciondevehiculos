package com.javierpinya.inspecciondevehiculos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;

import java.util.List;

@Dao
public interface TaccamiDao {

    @Insert
    void insert(TaccamiEntity vehiculo);

    @Update
    void updateTaccamiById(TaccamiEntity taccami);

    @Delete
    void deleteTaccamiById(TaccamiEntity taccami);

    @Query("select * from taccami")
    LiveData<List<TaccamiEntity>> findAllTaccami();

    @Query("select * from taccami where cod_vehiculo LIKE :cod_vehiculo")
    TaccamiEntity findTaccamiByCodVehiculo(int cod_vehiculo);

    @Query("SELECT * FROM taccami WHERE tractora LIKE :matricula")
    LiveData<List<TaccamiEntity>> findTaccamiByTMatricula(String matricula);

    @Query("SELECT * FROM taccami WHERE cisterna LIKE :matricula")
    LiveData<List<TaccamiEntity>> findTaccamiByCMatricula(String matricula);

    @Query("SELECT * FROM taccami WHERE tractora LIKE :tractora AND cisterna LIKE :cisterna")
    LiveData<List<TaccamiEntity>> findTaccamiByTCMatricula(String tractora, String cisterna);

    @Query("DELETE FROM taccami")
    void deleteAllTaccami();

    @Query("SELECT COUNT(*) FROM taccami")
    int getRowCount();
}
