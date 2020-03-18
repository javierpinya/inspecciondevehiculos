package com.javierpinya.inspecciondevehiculos.clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.inspecciondevehiculos.constans.Constans;
import com.javierpinya.inspecciondevehiculos.converters.Converters;

import java.util.Date;

@Entity(tableName = Constans.NAME_TABLE_TACCATR,
        indices = {@Index(value = {"id"}, unique = true)}
        )
@TypeConverters(Converters.class)
public class TaccatrEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int vehiculo;
    public String cod_transportista;
    public String slo;
    public Date fec_baja;

    //public TaccatrEntity(){}
    public TaccatrEntity(int vehiculo, String cod_transportista, String slo) {
        this.vehiculo = vehiculo;
        this.cod_transportista = cod_transportista;
        this.slo = slo;
        this.fec_baja = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCod_transportista() {
        return cod_transportista;
    }

    public void setCod_transportista(String cod_transportista) {
        this.cod_transportista = cod_transportista;
    }

    public String getSlo() {
        return slo;
    }

    public void setSlo(String slo) {
        this.slo = slo;
    }

    public Date getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(Date fec_baja) {
        this.fec_baja = fec_baja;
    }
}
