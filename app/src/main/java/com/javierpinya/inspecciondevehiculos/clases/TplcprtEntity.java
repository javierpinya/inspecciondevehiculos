package com.javierpinya.inspecciondevehiculos.clases;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.javierpinya.inspecciondevehiculos.constans.Constans;

@Entity(tableName = Constans.NAME_TABLE_TPLCPRT,
        indices = {@Index(value = {"id"}, unique = true)}
)
public class TplcprtEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int cod_compartimento;
    public String id_tipo_componente;
    public String matricula;
    public int can_capacidad;
    public String cod_tag_cprt;

    public TplcprtEntity(int cod_compartimento, String id_tipo_componente, String matricula, int can_capacidad, String cod_tag_cprt) {
        this.cod_compartimento = cod_compartimento;
        this.id_tipo_componente = id_tipo_componente;
        this.matricula = matricula;
        this.can_capacidad = can_capacidad;
        this.cod_tag_cprt = cod_tag_cprt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_compartimento() {
        return cod_compartimento;
    }

    public void setCod_compartimento(int cod_compartimento) {
        this.cod_compartimento = cod_compartimento;
    }

    public String getId_tipo_componente() {
        return id_tipo_componente;
    }

    public void setId_tipo_componente(String id_tipo_componente) {
        this.id_tipo_componente = id_tipo_componente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCan_capacidad() {
        return can_capacidad;
    }

    public void setCan_capacidad(int can_capacidad) {
        this.can_capacidad = can_capacidad;
    }

    public String getCod_tag_cprt() {
        return cod_tag_cprt;
    }

    public void setCod_tag_cprt(String cod_tag_cprt) {
        this.cod_tag_cprt = cod_tag_cprt;
    }
}
