package com.javierpinya.inspecciondevehiculos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.javierpinya.inspecciondevehiculos.clases.UsuarioEntity;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("select * from credenciales")
    LiveData<List<UsuarioEntity>> getCredenciales();

    @Insert
    void insert(UsuarioEntity usuario);
}
