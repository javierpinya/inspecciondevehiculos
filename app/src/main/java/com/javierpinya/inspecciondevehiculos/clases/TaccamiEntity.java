package com.javierpinya.inspecciondevehiculos.clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.inspecciondevehiculos.constans.Constans;
import com.javierpinya.inspecciondevehiculos.converters.Converters;

import java.util.Date;

@Entity(tableName = Constans.NAME_TABLE_TACCAMI,
        indices = {@Index(value = {"id"}, unique = true)}
)
@TypeConverters(Converters.class)
public class TaccamiEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int cod_vehiculo;
    public String tractora;
    public String cisterna;
    public int tara;
    public int pesoMaximo;
    public Date fec_baja;

    public TaccamiEntity(int cod_vehiculo, String tractora, String cisterna, int tara, int pesoMaximo) {
        this.cod_vehiculo = cod_vehiculo;
        this.tractora = tractora;
        this.cisterna = cisterna;
        this.tara = tara;
        this.pesoMaximo = pesoMaximo;
        this.fec_baja = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_vehiculo() {
        return cod_vehiculo;
    }

    public void setCod_vehiculo(int cod_vehiculo) {
        this.cod_vehiculo = cod_vehiculo;
    }

    public String getTractora() {
        return tractora;
    }

    public void setTractora(String tractora) {
        this.tractora = tractora;
    }

    public String getCisterna() {
        return cisterna;
    }

    public void setCisterna(String cisterna) {
        this.cisterna = cisterna;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Date getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(Date fec_baja) {
        this.fec_baja = fec_baja;
    }
}

