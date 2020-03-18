package com.javierpinya.inspecciondevehiculos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;

import java.util.List;


@Dao
public interface InspeccionDao {

    @Insert
    void insert(InspeccionEntity inspeccion);

    @Update
    void updateInspeccionById(InspeccionEntity inspeccion);

    @Delete
    void deleteInspeccionById(InspeccionEntity inspeccion);

    @Query("select * from inspeccion")
    LiveData<List<InspeccionEntity>> findAllInspecciones();

    @Query("select * from inspeccion where inspeccion like :inspeccion")
    InspeccionEntity findInspeccionByInspeccion(String inspeccion);

    @Query("select * from inspeccion where inspeccion like :inspeccion")
    LiveData<List<InspeccionEntity>> findInspeccionByInspeccion2(String inspeccion);

    @Query("select id from inspeccion where inspeccion like :inspeccion")
    int findIdInspeccionByInspeccion(String inspeccion);

    @Query("select * from inspeccion where nombre_inspector like :inspector")
    LiveData<List<InspeccionEntity>> findInspeccionByInspector(String inspector);

    @Query("select * from inspeccion where instalacion like :instalacion")
    LiveData<List<InspeccionEntity>> findInspeccionByInstalacion(String instalacion);

    @Query("select * from inspeccion where transportista LIKE :transportista")
    LiveData<List<InspeccionEntity>> findInspeccionByTransportista(String transportista);

    @Query("select * from inspeccion where tractora like :matricula")
    LiveData<List<InspeccionEntity>> findInspeccionByTractora(String matricula);

    @Query("select * from inspeccion where cisterna like :matricula")
    LiveData<List<InspeccionEntity>> findInspeccionByCisterna(String matricula);

    @Query("select * from inspeccion where conductor like :conductor")
    LiveData<List<InspeccionEntity>> findInspeccionByConductor(String conductor);

    @Query("SELECT * FROM inspeccion WHERE nombre_inspector LIKE :inspector AND conductor LIKE :conductor AND instalacion LIKE :instalacion AND tractora LIKE :tractora AND cisterna LIKE :cisterna")
    LiveData<List<InspeccionEntity>> findInspeccionByEverything(String inspector, String conductor, String instalacion, String tractora, String cisterna);

    @Query("SELECT * FROM inspeccion WHERE nombre_inspector LIKE :inspector AND conductor LIKE :conductor AND instalacion LIKE :instalacion AND tractora LIKE :tractora")
    LiveData<List<InspeccionEntity>> findInspeccionByINCOIATR(String inspector, String conductor, String instalacion, String tractora);

    @Query("SELECT * FROM inspeccion WHERE nombre_inspector LIKE :inspector AND conductor LIKE :conductor AND instalacion LIKE :instalacion AND cisterna LIKE :cisterna")
    LiveData<List<InspeccionEntity>> findInspeccionByINCOIACI(String inspector, String conductor, String instalacion, String cisterna);

    @Query("SELECT * FROM inspeccion WHERE conductor LIKE :conductor AND instalacion LIKE :instalacion AND tractora LIKE :tractora AND cisterna LIKE :cisterna")
    LiveData<List<InspeccionEntity>> findInspeccionByCOIATRCI(String conductor, String instalacion, String tractora, String cisterna);

    @Query("SELECT * FROM inspeccion WHERE conductor LIKE :conductor AND tractora LIKE :tractora AND cisterna LIKE :cisterna")
    LiveData<List<InspeccionEntity>> findInspeccionByCOTRCI(String conductor, String tractora, String cisterna);

    @Query("SELECT * FROM inspeccion WHERE tractora LIKE :tractora AND cisterna LIKE :cisterna")
    LiveData<List<InspeccionEntity>> findInspeccionByTRCI(String tractora, String cisterna);

    @Query("SELECT * FROM inspeccion WHERE nombre_inspector LIKE :inspector AND instalacion LIKE :instalacion")
    LiveData<List<InspeccionEntity>> findInspeccionByINIA(String inspector, String instalacion);

    @Query("SELECT * FROM inspeccion WHERE instalacion LIKE :instalacion AND transportista LIKE :transportista")
    LiveData<List<InspeccionEntity>> findInspeccionByTRANSPIA(String instalacion, String transportista);

    @Query("SELECT * FROM inspeccion WHERE instalacion LIKE :instalacion AND transportista LIKE :transportista")
    List<InspeccionEntity> findInspeccionByTRANSPIA2(String instalacion, String transportista);

    @Query("SELECT COUNT(*) FROM inspeccion WHERE codigo_inspector LIKE :cod_inspector")
    int getRowCount(String cod_inspector);

}
