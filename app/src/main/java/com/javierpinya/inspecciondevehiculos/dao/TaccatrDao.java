package com.javierpinya.inspecciondevehiculos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.inspecciondevehiculos.clases.TaccatrEntity;

import java.util.List;

@Dao
public interface TaccatrDao {

    @Insert
    void insertTaccatr(TaccatrEntity taccatr);

    @Update
    void updateTaccatrById(TaccatrEntity taccatr);

    @Delete
    void deleteTaccatrById(TaccatrEntity taccatr);

    @Query("DELETE FROM taccatr")
    void deleteAllTaccatr();

    @Query("SELECT * FROM taccatr")
    LiveData<List<TaccatrEntity>> findAllTaccatr();

    @Query("SELECT * FROM taccatr WHERE id LIKE :id")
    TaccatrEntity findTaccatrById(int id);

    @Query("SELECT * FROM taccatr WHERE cod_transportista LIKE :transportista AND slo LIKE :slo")
    LiveData<List<TaccatrEntity>> findTaccatrByTransSlo(String transportista, String slo);

    @Query("SELECT * FROM taccatr WHERE cod_transportista LIKE :transportista")
    LiveData<List<TaccatrEntity>> findTaccatrByTrans(String transportista);

    @Query("SELECT vehiculo FROM taccatr WHERE cod_transportista LIKE :transportista")
    LiveData<List<Integer>> findTaccatrCodVehiculoByTrans(String transportista);


}
