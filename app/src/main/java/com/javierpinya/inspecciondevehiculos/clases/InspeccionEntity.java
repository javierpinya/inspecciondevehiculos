package com.javierpinya.inspecciondevehiculos.clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.inspecciondevehiculos.constans.Constans;
import com.javierpinya.inspecciondevehiculos.converters.Converters;

import java.util.Date;

@Entity(tableName = Constans.NAME_TABLE_INSPECCION_ADAPTADA,
        indices = {@Index(value = {"id"}, unique = true)}
)
@TypeConverters(Converters.class)
public class InspeccionEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String instalacion;
    public String inspeccion;
    public String codigo_inspector;
    public String nombre_inspector;
    public Date fechaInspeccion;
    public Date horaInicio;
    public Date horaFin;
    public String transportista;
    public int conjunto;
    public String tractora;
    public String cisterna;
    public String rigido;
    public Date fecha_tabla_cal_rigido;
    public Date fecha_tabla_cal_cisterna;
    public String nombre_cond;
    public int conductor;
    public String suministrador;
    public String albaran;
    public boolean permiso_cond;
    public boolean adr_cond;
    public boolean itv_tractora_rigido;
    public boolean itv_cisterna;
    public boolean adr_tractora_rigido;
    public boolean adr_cisterna;
    public boolean ficha_seguridad;
    public String empresa_tabla_cal;
    public boolean transponder_tractora;
    public boolean transponder_cisterna;
    public boolean superficie_antideslizante;
    public boolean posicionamiento_isleta;
    public boolean accionamiento_freno;
    public boolean accionamiento_desconexion_bateria;
    public boolean apagallamas;
    public boolean movil_desconectado;
    public boolean interruptores_emergencia;
    public boolean toma_tierra;
    public boolean manguera_gases;
    public boolean purga_compartimentos;
    public boolean ropa;
    public String c1_altura_real_sonda;
    public String c1_altura_sonda96;
    public String c1_cantidad_cargada;
    public String c1_cantidad_96st;
    public String c1_diferencia;
    public String c2_altura_real_sonda;
    public String c2_altura_sonda96;
    public String c2_cantidad_cargada;
    public String c2_cantidad_96st;
    public String c2_diferencia;
    public String c3_altura_real_sonda;
    public String c3_altura_sonda96;
    public String c3_cantidad_cargada;
    public String c3_cantidad_96st;
    public String c3_diferencia;
    public String c4_altura_real_sonda;
    public String c4_altura_sonda96;
    public String c4_cantidad_cargada;
    public String c4_cantidad_96st;
    public String c4_diferencia;
    public String c5_altura_real_sonda;
    public String c5_altura_sonda96;
    public String c5_cantidad_cargada;
    public String c5_cantidad_96st;
    public String c5_diferencia;
    public String c6_altura_real_sonda;
    public String c6_altura_sonda96;
    public String c6_cantidad_cargada;
    public String c6_cantidad_96st;
    public String c6_diferencia;
    public String c7_altura_real_sonda;
    public String c7_altura_sonda96;
    public String c7_cantidad_cargada;
    public String c7_cantidad_96st;
    public String c7_diferencia;
    public String c8_altura_real_sonda;
    public String c8_altura_sonda96;
    public String c8_cantidad_cargada;
    public String c8_cantidad_96st;
    public String c8_diferencia;
    public String c9_altura_real_sonda;
    public String c9_altura_sonda96;
    public String c9_cantidad_cargada;
    public String c9_cantidad_96st;
    public String c9_diferencia;
    public String c10_altura_real_sonda;
    public String c10_altura_sonda96;
    public String c10_cantidad_cargada;
    public String c10_cantidad_96st;
    public String c10_diferencia;
    public boolean c1_cumple;
    public boolean c2_cumple;
    public boolean c3_cumple;
    public boolean c4_cumple;
    public boolean c5_cumple;
    public boolean c6_cumple;
    public boolean c7_cumple;
    public boolean c8_cumple;
    public boolean c9_cumple;
    public boolean c10_cumple;
    public boolean estanqueidad_cisterna;
    public boolean estanqueidad_valvulas_api;
    public boolean estanqueidad_cajon_valvulas;
    public boolean estanqueidad_valvulas_fondo;
    public boolean estanqueidad_equipo_trasiego;
    public boolean recoger_albaran;
    public String observaciones;
    public String numero_incidencia1;
    public int peso_entrada;
    public int peso_salida;
    public int producto;
    public Date fecha_arnes;
    public int c1_vol_total_placa;
    public int c2_vol_total_placa;
    public int c3_vol_total_placa;
    public int c4_vol_total_placa;
    public int c5_vol_total_placa;
    public int c6_vol_total_placa;
    public int c7_vol_total_placa;
    public int c8_vol_total_placa;
    public int c9_vol_total_placa;
    public int c10_vol_total_placa;
    public boolean inspeccionada;
    public boolean favorable;
    public boolean desfavorable;
    public Date fecha_desfavorable;
    public boolean bloqueada;
    public Date fecha_bloqueo;
    public boolean revisado;
    public boolean tc2;
    public boolean montaje_tag_ok;
    public boolean bajada_tag_planta;
    public boolean lectura_tag_isleta;
    public int c1_tag;
    public int c2_tag;
    public int c3_tag;
    public int c4_tag;
    public int c5_tag;
    public int c6_tag;
    public int c7_tag;
    public int c8_tag;
    public int c9_tag;
    public int c10_tag;
    public String tag_observaciones;
    public boolean inspeccion_camara;

    public InspeccionEntity(String instalacion, String inspeccion, String codigo_inspector, String nombre_inspector, Date fechaInspeccion, Date horaInicio, Date horaFin, String transportista, int conjunto, String tractora, String cisterna, String rigido, Date fecha_tabla_cal_rigido, Date fecha_tabla_cal_cisterna, String nombre_cond, int conductor, String suministrador, String albaran, String empresa_tabla_cal, boolean permiso_cond, boolean adr_cond, boolean itv_tractora_rigido, boolean itv_cisterna, boolean adr_tractora_rigido, boolean adr_cisterna, boolean ficha_seguridad, boolean transponder_tractora, boolean transponder_cisterna, boolean superficie_antideslizante, boolean posicionamiento_isleta, boolean accionamiento_freno, boolean accionamiento_desconexion_bateria, boolean apagallamas, boolean movil_desconectado, boolean interruptores_emergencia, boolean toma_tierra, boolean manguera_gases, boolean purga_compartimentos, boolean ropa, boolean estanqueidad_cisterna, boolean estanqueidad_valvulas_api, boolean estanqueidad_cajon_valvulas, boolean estanqueidad_valvulas_fondo, boolean estanqueidad_equipo_trasiego, boolean recoger_albaran, boolean tc2, boolean montaje_tag_ok, boolean bajada_tag_planta, boolean lectura_tag_isleta, String c1_altura_real_sonda, String c1_altura_sonda96, String c1_cantidad_cargada, String c1_cantidad_96st, String c1_diferencia, String c2_altura_real_sonda, String c2_altura_sonda96, String c2_cantidad_cargada, String c2_cantidad_96st, String c2_diferencia, String c3_altura_real_sonda, String c3_altura_sonda96, String c3_cantidad_cargada, String c3_cantidad_96st, String c3_diferencia, String c4_altura_real_sonda, String c4_altura_sonda96, String c4_cantidad_cargada, String c4_cantidad_96st, String c4_diferencia, String c5_altura_real_sonda, String c5_altura_sonda96, String c5_cantidad_cargada, String c5_cantidad_96st, String c5_diferencia, String c6_altura_real_sonda, String c6_altura_sonda96, String c6_cantidad_cargada, String c6_cantidad_96st, String c6_diferencia, String c7_altura_real_sonda, String c7_altura_sonda96, String c7_cantidad_cargada, String c7_cantidad_96st, String c7_diferencia, String c8_altura_real_sonda, String c8_altura_sonda96, String c8_cantidad_cargada, String c8_cantidad_96st, String c8_diferencia, String c9_altura_real_sonda, String c9_altura_sonda96, String c9_cantidad_cargada, String c9_cantidad_96st, String c9_diferencia, String c10_altura_real_sonda, String c10_altura_sonda96, String c10_cantidad_cargada, String c10_cantidad_96st, String c10_diferencia, boolean c1_cumple, boolean c2_cumple, boolean c3_cumple, boolean c4_cumple, boolean c5_cumple, boolean c6_cumple, boolean c7_cumple, boolean c8_cumple, boolean c9_cumple, boolean c10_cumple, int c1_vol_total_placa, int c2_vol_total_placa, int c3_vol_total_placa, int c4_vol_total_placa, int c5_vol_total_placa, int c6_vol_total_placa, int c7_vol_total_placa, int c8_vol_total_placa, int c9_vol_total_placa, int c10_vol_total_placa, int c1_tag, int c2_tag, int c3_tag, int c4_tag, int c5_tag, int c6_tag, int c7_tag, int c8_tag, int c9_tag, int c10_tag,boolean inspeccionada, boolean favorable, boolean desfavorable, boolean bloqueada, boolean revisado, boolean inspeccion_camara,Date fecha_desfavorable, Date fecha_bloqueo,  String observaciones, String numero_incidencia1, Date fecha_arnes, String tag_observaciones, int peso_entrada, int peso_salida, int producto) {
        this.instalacion = instalacion;
        this.inspeccion = inspeccion;
        this.codigo_inspector = codigo_inspector;
        this.nombre_inspector = nombre_inspector;
        this.fechaInspeccion = fechaInspeccion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.transportista = transportista;
        this.conjunto = conjunto;
        this.tractora = tractora;
        this.cisterna = cisterna;
        this.rigido = rigido;
        this.fecha_tabla_cal_rigido = fecha_tabla_cal_rigido;
        this.fecha_tabla_cal_cisterna = fecha_tabla_cal_cisterna;
        this.nombre_cond = nombre_cond;
        this.conductor = conductor;
        this.suministrador = suministrador;
        this.albaran = albaran;
        this.empresa_tabla_cal = empresa_tabla_cal;
        this.permiso_cond = permiso_cond;
        this.adr_cond = adr_cond;
        this.itv_tractora_rigido = itv_tractora_rigido;
        this.itv_cisterna = itv_cisterna;
        this.adr_tractora_rigido = adr_tractora_rigido;
        this.adr_cisterna = adr_cisterna;
        this.ficha_seguridad = ficha_seguridad;
        this.transponder_tractora = transponder_tractora;
        this.transponder_cisterna = transponder_cisterna;
        this.superficie_antideslizante = superficie_antideslizante;
        this.posicionamiento_isleta = posicionamiento_isleta;
        this.accionamiento_freno = accionamiento_freno;
        this.accionamiento_desconexion_bateria = accionamiento_desconexion_bateria;
        this.apagallamas = apagallamas;
        this.movil_desconectado = movil_desconectado;
        this.interruptores_emergencia = interruptores_emergencia;
        this.toma_tierra = toma_tierra;
        this.manguera_gases = manguera_gases;
        this.purga_compartimentos = purga_compartimentos;
        this.ropa = ropa;
        this.estanqueidad_cisterna = estanqueidad_cisterna;
        this.estanqueidad_valvulas_api = estanqueidad_valvulas_api;
        this.estanqueidad_cajon_valvulas = estanqueidad_cajon_valvulas;
        this.estanqueidad_valvulas_fondo = estanqueidad_valvulas_fondo;
        this.estanqueidad_equipo_trasiego = estanqueidad_equipo_trasiego;
        this.recoger_albaran = recoger_albaran;
        this.tc2 = tc2;
        this.montaje_tag_ok = montaje_tag_ok;
        this.bajada_tag_planta = bajada_tag_planta;
        this.lectura_tag_isleta = lectura_tag_isleta;
        this.c1_altura_real_sonda = c1_altura_real_sonda;
        this.c1_altura_sonda96 = c1_altura_sonda96;
        this.c1_cantidad_cargada = c1_cantidad_cargada;
        this.c1_cantidad_96st = c1_cantidad_96st;
        this.c1_diferencia = c1_diferencia;
        this.c2_altura_real_sonda = c2_altura_real_sonda;
        this.c2_altura_sonda96 = c2_altura_sonda96;
        this.c2_cantidad_cargada = c2_cantidad_cargada;
        this.c2_cantidad_96st = c2_cantidad_96st;
        this.c2_diferencia = c2_diferencia;
        this.c3_altura_real_sonda = c3_altura_real_sonda;
        this.c3_altura_sonda96 = c3_altura_sonda96;
        this.c3_cantidad_cargada = c3_cantidad_cargada;
        this.c3_cantidad_96st = c3_cantidad_96st;
        this.c3_diferencia = c3_diferencia;
        this.c4_altura_real_sonda = c4_altura_real_sonda;
        this.c4_altura_sonda96 = c4_altura_sonda96;
        this.c4_cantidad_cargada = c4_cantidad_cargada;
        this.c4_cantidad_96st = c4_cantidad_96st;
        this.c4_diferencia = c4_diferencia;
        this.c5_altura_real_sonda = c5_altura_real_sonda;
        this.c5_altura_sonda96 = c5_altura_sonda96;
        this.c5_cantidad_cargada = c5_cantidad_cargada;
        this.c5_cantidad_96st = c5_cantidad_96st;
        this.c5_diferencia = c5_diferencia;
        this.c6_altura_real_sonda = c6_altura_real_sonda;
        this.c6_altura_sonda96 = c6_altura_sonda96;
        this.c6_cantidad_cargada = c6_cantidad_cargada;
        this.c6_cantidad_96st = c6_cantidad_96st;
        this.c6_diferencia = c6_diferencia;
        this.c7_altura_real_sonda = c7_altura_real_sonda;
        this.c7_altura_sonda96 = c7_altura_sonda96;
        this.c7_cantidad_cargada = c7_cantidad_cargada;
        this.c7_cantidad_96st = c7_cantidad_96st;
        this.c7_diferencia = c7_diferencia;
        this.c8_altura_real_sonda = c8_altura_real_sonda;
        this.c8_altura_sonda96 = c8_altura_sonda96;
        this.c8_cantidad_cargada = c8_cantidad_cargada;
        this.c8_cantidad_96st = c8_cantidad_96st;
        this.c8_diferencia = c8_diferencia;
        this.c9_altura_real_sonda = c9_altura_real_sonda;
        this.c9_altura_sonda96 = c9_altura_sonda96;
        this.c9_cantidad_cargada = c9_cantidad_cargada;
        this.c9_cantidad_96st = c9_cantidad_96st;
        this.c9_diferencia = c9_diferencia;
        this.c10_altura_real_sonda = c10_altura_real_sonda;
        this.c10_altura_sonda96 = c10_altura_sonda96;
        this.c10_cantidad_cargada = c10_cantidad_cargada;
        this.c10_cantidad_96st = c10_cantidad_96st;
        this.c10_diferencia = c10_diferencia;
        this.c1_cumple = c1_cumple;
        this.c2_cumple = c2_cumple;
        this.c3_cumple = c3_cumple;
        this.c4_cumple = c4_cumple;
        this.c5_cumple = c5_cumple;
        this.c6_cumple = c6_cumple;
        this.c7_cumple = c7_cumple;
        this.c8_cumple = c8_cumple;
        this.c9_cumple = c9_cumple;
        this.c10_cumple = c10_cumple;
        this.c1_vol_total_placa = c1_vol_total_placa;
        this.c2_vol_total_placa = c2_vol_total_placa;
        this.c3_vol_total_placa = c3_vol_total_placa;
        this.c4_vol_total_placa = c4_vol_total_placa;
        this.c5_vol_total_placa = c5_vol_total_placa;
        this.c6_vol_total_placa = c6_vol_total_placa;
        this.c7_vol_total_placa = c7_vol_total_placa;
        this.c8_vol_total_placa = c8_vol_total_placa;
        this.c9_vol_total_placa = c9_vol_total_placa;
        this.c10_vol_total_placa = c10_vol_total_placa;
        this.c1_tag = c1_tag;
        this.c2_tag = c2_tag;
        this.c3_tag = c3_tag;
        this.c4_tag = c4_tag;
        this.c5_tag = c5_tag;
        this.c6_tag = c6_tag;
        this.c7_tag = c7_tag;
        this.c8_tag = c8_tag;
        this.c9_tag = c9_tag;
        this.c10_tag = c10_tag;
        this.inspeccionada = inspeccionada;
        this.favorable = favorable;
        this.desfavorable = desfavorable;
        this.bloqueada = bloqueada;
        this.revisado = revisado;
        this.inspeccion_camara = inspeccion_camara;
        this.fecha_desfavorable = fecha_desfavorable;
        this.fecha_bloqueo = fecha_bloqueo;
        this.observaciones = observaciones;
        this.numero_incidencia1 = numero_incidencia1;
        this.fecha_arnes = fecha_arnes;
        this.tag_observaciones = tag_observaciones;
        this.peso_entrada = peso_entrada;
        this.peso_salida = peso_salida;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getInspeccion() {
        return inspeccion;
    }

    public void setInspeccion(String inspeccion) {
        this.inspeccion = inspeccion;
    }

    public String getCodigo_inspector() {
        return codigo_inspector;
    }

    public void setCodigo_inspector(String codigo_inspector) {
        this.codigo_inspector = codigo_inspector;
    }

    public String getNombre_inspector() {
        return nombre_inspector;
    }

    public void setNombre_inspector(String nombre_inspector) {
        this.nombre_inspector = nombre_inspector;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public int getConjunto() {
        return conjunto;
    }

    public void setConjunto(int conjunto) {
        this.conjunto = conjunto;
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

    public String getRigido() {
        return rigido;
    }

    public void setRigido(String rigido) {
        this.rigido = rigido;
    }

    public Date getFecha_tabla_cal_rigido() {
        return fecha_tabla_cal_rigido;
    }

    public void setFecha_tabla_cal_rigido(Date fecha_tabla_cal_rigido) {
        this.fecha_tabla_cal_rigido = fecha_tabla_cal_rigido;
    }

    public Date getFecha_tabla_cal_cisterna() {
        return fecha_tabla_cal_cisterna;
    }

    public void setFecha_tabla_cal_cisterna(Date fecha_tabla_cal_cisterna) {
        this.fecha_tabla_cal_cisterna = fecha_tabla_cal_cisterna;
    }

    public String getNombre_cond() {
        return nombre_cond;
    }

    public void setNombre_cond(String nombre_cond) {
        this.nombre_cond = nombre_cond;
    }

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }

    public String getSuministrador() {
        return suministrador;
    }

    public void setSuministrador(String suministrador) {
        this.suministrador = suministrador;
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }

    public boolean isPermiso_cond() {
        return permiso_cond;
    }

    public void setPermiso_cond(boolean permiso_cond) {
        this.permiso_cond = permiso_cond;
    }

    public boolean isAdr_cond() {
        return adr_cond;
    }

    public void setAdr_cond(boolean adr_cond) {
        this.adr_cond = adr_cond;
    }

    public boolean isItv_tractora_rigido() {
        return itv_tractora_rigido;
    }

    public void setItv_tractora_rigido(boolean itv_tractora_rigido) {
        this.itv_tractora_rigido = itv_tractora_rigido;
    }

    public boolean isItv_cisterna() {
        return itv_cisterna;
    }

    public void setItv_cisterna(boolean itv_cisterna) {
        this.itv_cisterna = itv_cisterna;
    }

    public boolean isAdr_tractora_rigido() {
        return adr_tractora_rigido;
    }

    public void setAdr_tractora_rigido(boolean adr_tractora_rigido) {
        this.adr_tractora_rigido = adr_tractora_rigido;
    }

    public boolean isAdr_cisterna() {
        return adr_cisterna;
    }

    public void setAdr_cisterna(boolean adr_cisterna) {
        this.adr_cisterna = adr_cisterna;
    }

    public boolean isFicha_seguridad() {
        return ficha_seguridad;
    }

    public void setFicha_seguridad(boolean ficha_seguridad) {
        this.ficha_seguridad = ficha_seguridad;
    }

    public String getEmpresa_tabla_cal() {
        return empresa_tabla_cal;
    }

    public void setEmpresa_tabla_cal(String empresa_tabla_cal) {
        this.empresa_tabla_cal = empresa_tabla_cal;
    }

    public boolean isTransponder_tractora() {
        return transponder_tractora;
    }

    public void setTransponder_tractora(boolean transponder_tractora) {
        this.transponder_tractora = transponder_tractora;
    }

    public boolean isTransponder_cisterna() {
        return transponder_cisterna;
    }

    public void setTransponder_cisterna(boolean transponder_cisterna) {
        this.transponder_cisterna = transponder_cisterna;
    }

    public boolean isSuperficie_antideslizante() {
        return superficie_antideslizante;
    }

    public void setSuperficie_antideslizante(boolean superficie_antideslizante) {
        this.superficie_antideslizante = superficie_antideslizante;
    }

    public boolean isPosicionamiento_isleta() {
        return posicionamiento_isleta;
    }

    public void setPosicionamiento_isleta(boolean posicionamiento_isleta) {
        this.posicionamiento_isleta = posicionamiento_isleta;
    }

    public boolean isAccionamiento_freno() {
        return accionamiento_freno;
    }

    public void setAccionamiento_freno(boolean accionamiento_freno) {
        this.accionamiento_freno = accionamiento_freno;
    }

    public boolean isAccionamiento_desconexion_bateria() {
        return accionamiento_desconexion_bateria;
    }

    public void setAccionamiento_desconexion_bateria(boolean accionamiento_desconexion_bateria) {
        this.accionamiento_desconexion_bateria = accionamiento_desconexion_bateria;
    }

    public boolean isApagallamas() {
        return apagallamas;
    }

    public void setApagallamas(boolean apagallamas) {
        this.apagallamas = apagallamas;
    }

    public boolean isMovil_desconectado() {
        return movil_desconectado;
    }

    public void setMovil_desconectado(boolean movil_desconectado) {
        this.movil_desconectado = movil_desconectado;
    }

    public boolean isInterruptores_emergencia() {
        return interruptores_emergencia;
    }

    public void setInterruptores_emergencia(boolean interruptores_emergencia) {
        this.interruptores_emergencia = interruptores_emergencia;
    }

    public boolean isToma_tierra() {
        return toma_tierra;
    }

    public void setToma_tierra(boolean toma_tierra) {
        this.toma_tierra = toma_tierra;
    }

    public boolean isManguera_gases() {
        return manguera_gases;
    }

    public void setManguera_gases(boolean manguera_gases) {
        this.manguera_gases = manguera_gases;
    }

    public boolean isPurga_compartimentos() {
        return purga_compartimentos;
    }

    public void setPurga_compartimentos(boolean purga_compartimentos) {
        this.purga_compartimentos = purga_compartimentos;
    }

    public boolean isRopa() {
        return ropa;
    }

    public void setRopa(boolean ropa) {
        this.ropa = ropa;
    }

    public String getC1_altura_real_sonda() {
        return c1_altura_real_sonda;
    }

    public void setC1_altura_real_sonda(String c1_altura_real_sonda) {
        this.c1_altura_real_sonda = c1_altura_real_sonda;
    }

    public String getC1_altura_sonda96() {
        return c1_altura_sonda96;
    }

    public void setC1_altura_sonda96(String c1_altura_sonda96) {
        this.c1_altura_sonda96 = c1_altura_sonda96;
    }

    public String getC1_cantidad_cargada() {
        return c1_cantidad_cargada;
    }

    public void setC1_cantidad_cargada(String c1_cantidad_cargada) {
        this.c1_cantidad_cargada = c1_cantidad_cargada;
    }

    public String getC1_cantidad_96st() {
        return c1_cantidad_96st;
    }

    public void setC1_cantidad_96st(String c1_cantidad_96st) {
        this.c1_cantidad_96st = c1_cantidad_96st;
    }

    public String getC1_diferencia() {
        return c1_diferencia;
    }

    public void setC1_diferencia(String c1_diferencia) {
        this.c1_diferencia = c1_diferencia;
    }

    public boolean isC1_cumple() {
        return c1_cumple;
    }

    public void setC1_cumple(boolean c1_cumple) {
        this.c1_cumple = c1_cumple;
    }

    public String getC2_altura_real_sonda() {
        return c2_altura_real_sonda;
    }

    public void setC2_altura_real_sonda(String c2_altura_real_sonda) {
        this.c2_altura_real_sonda = c2_altura_real_sonda;
    }

    public String getC2_altura_sonda96() {
        return c2_altura_sonda96;
    }

    public void setC2_altura_sonda96(String c2_altura_sonda96) {
        this.c2_altura_sonda96 = c2_altura_sonda96;
    }

    public String getC2_cantidad_cargada() {
        return c2_cantidad_cargada;
    }

    public void setC2_cantidad_cargada(String c2_cantidad_cargada) {
        this.c2_cantidad_cargada = c2_cantidad_cargada;
    }

    public String getC2_cantidad_96st() {
        return c2_cantidad_96st;
    }

    public void setC2_cantidad_96st(String c2_cantidad_96st) {
        this.c2_cantidad_96st = c2_cantidad_96st;
    }

    public String getC2_diferencia() {
        return c2_diferencia;
    }

    public void setC2_diferencia(String c2_diferencia) {
        this.c2_diferencia = c2_diferencia;
    }

    public boolean isC2_cumple() {
        return c2_cumple;
    }

    public void setC2_cumple(boolean c2_cumple) {
        this.c2_cumple = c2_cumple;
    }

    public String getC3_altura_real_sonda() {
        return c3_altura_real_sonda;
    }

    public void setC3_altura_real_sonda(String c3_altura_real_sonda) {
        this.c3_altura_real_sonda = c3_altura_real_sonda;
    }

    public String getC3_altura_sonda96() {
        return c3_altura_sonda96;
    }

    public void setC3_altura_sonda96(String c3_altura_sonda96) {
        this.c3_altura_sonda96 = c3_altura_sonda96;
    }

    public String getC3_cantidad_cargada() {
        return c3_cantidad_cargada;
    }

    public void setC3_cantidad_cargada(String c3_cantidad_cargada) {
        this.c3_cantidad_cargada = c3_cantidad_cargada;
    }

    public String getC3_cantidad_96st() {
        return c3_cantidad_96st;
    }

    public void setC3_cantidad_96st(String c3_cantidad_96st) {
        this.c3_cantidad_96st = c3_cantidad_96st;
    }

    public String getC3_diferencia() {
        return c3_diferencia;
    }

    public void setC3_diferencia(String c3_diferencia) {
        this.c3_diferencia = c3_diferencia;
    }

    public boolean isC3_cumple() {
        return c3_cumple;
    }

    public void setC3_cumple(boolean c3_cumple) {
        this.c3_cumple = c3_cumple;
    }

    public String getC4_altura_real_sonda() {
        return c4_altura_real_sonda;
    }

    public void setC4_altura_real_sonda(String c4_altura_real_sonda) {
        this.c4_altura_real_sonda = c4_altura_real_sonda;
    }

    public String getC4_altura_sonda96() {
        return c4_altura_sonda96;
    }

    public void setC4_altura_sonda96(String c4_altura_sonda96) {
        this.c4_altura_sonda96 = c4_altura_sonda96;
    }

    public String getC4_cantidad_cargada() {
        return c4_cantidad_cargada;
    }

    public void setC4_cantidad_cargada(String c4_cantidad_cargada) {
        this.c4_cantidad_cargada = c4_cantidad_cargada;
    }

    public String getC4_cantidad_96st() {
        return c4_cantidad_96st;
    }

    public void setC4_cantidad_96st(String c4_cantidad_96st) {
        this.c4_cantidad_96st = c4_cantidad_96st;
    }

    public String getC4_diferencia() {
        return c4_diferencia;
    }

    public void setC4_diferencia(String c4_diferencia) {
        this.c4_diferencia = c4_diferencia;
    }

    public boolean isC4_cumple() {
        return c4_cumple;
    }

    public void setC4_cumple(boolean c4_cumple) {
        this.c4_cumple = c4_cumple;
    }

    public String getC5_altura_real_sonda() {
        return c5_altura_real_sonda;
    }

    public void setC5_altura_real_sonda(String c5_altura_real_sonda) {
        this.c5_altura_real_sonda = c5_altura_real_sonda;
    }

    public String getC5_altura_sonda96() {
        return c5_altura_sonda96;
    }

    public void setC5_altura_sonda96(String c5_altura_sonda96) {
        this.c5_altura_sonda96 = c5_altura_sonda96;
    }

    public String getC5_cantidad_cargada() {
        return c5_cantidad_cargada;
    }

    public void setC5_cantidad_cargada(String c5_cantidad_cargada) {
        this.c5_cantidad_cargada = c5_cantidad_cargada;
    }

    public String getC5_cantidad_96st() {
        return c5_cantidad_96st;
    }

    public void setC5_cantidad_96st(String c5_cantidad_96st) {
        this.c5_cantidad_96st = c5_cantidad_96st;
    }

    public String getC5_diferencia() {
        return c5_diferencia;
    }

    public void setC5_diferencia(String c5_diferencia) {
        this.c5_diferencia = c5_diferencia;
    }

    public boolean isC5_cumple() {
        return c5_cumple;
    }

    public void setC5_cumple(boolean c5_cumple) {
        this.c5_cumple = c5_cumple;
    }

    public String getC6_altura_real_sonda() {
        return c6_altura_real_sonda;
    }

    public void setC6_altura_real_sonda(String c6_altura_real_sonda) {
        this.c6_altura_real_sonda = c6_altura_real_sonda;
    }

    public String getC6_altura_sonda96() {
        return c6_altura_sonda96;
    }

    public void setC6_altura_sonda96(String c6_altura_sonda96) {
        this.c6_altura_sonda96 = c6_altura_sonda96;
    }

    public String getC6_cantidad_cargada() {
        return c6_cantidad_cargada;
    }

    public void setC6_cantidad_cargada(String c6_cantidad_cargada) {
        this.c6_cantidad_cargada = c6_cantidad_cargada;
    }

    public String getC6_cantidad_96st() {
        return c6_cantidad_96st;
    }

    public void setC6_cantidad_96st(String c6_cantidad_96st) {
        this.c6_cantidad_96st = c6_cantidad_96st;
    }

    public String getC6_diferencia() {
        return c6_diferencia;
    }

    public void setC6_diferencia(String c6_diferencia) {
        this.c6_diferencia = c6_diferencia;
    }

    public boolean isC6_cumple() {
        return c6_cumple;
    }

    public void setC6_cumple(boolean c6_cumple) {
        this.c6_cumple = c6_cumple;
    }

    public String getC7_altura_real_sonda() {
        return c7_altura_real_sonda;
    }

    public void setC7_altura_real_sonda(String c7_altura_real_sonda) {
        this.c7_altura_real_sonda = c7_altura_real_sonda;
    }

    public String getC7_altura_sonda96() {
        return c7_altura_sonda96;
    }

    public void setC7_altura_sonda96(String c7_altura_sonda96) {
        this.c7_altura_sonda96 = c7_altura_sonda96;
    }

    public String getC7_cantidad_cargada() {
        return c7_cantidad_cargada;
    }

    public void setC7_cantidad_cargada(String c7_cantidad_cargada) {
        this.c7_cantidad_cargada = c7_cantidad_cargada;
    }

    public String getC7_cantidad_96st() {
        return c7_cantidad_96st;
    }

    public void setC7_cantidad_96st(String c7_cantidad_96st) {
        this.c7_cantidad_96st = c7_cantidad_96st;
    }

    public String getC7_diferencia() {
        return c7_diferencia;
    }

    public void setC7_diferencia(String c7_diferencia) {
        this.c7_diferencia = c7_diferencia;
    }

    public boolean isC7_cumple() {
        return c7_cumple;
    }

    public void setC7_cumple(boolean c7_cumple) {
        this.c7_cumple = c7_cumple;
    }

    public String getC8_altura_real_sonda() {
        return c8_altura_real_sonda;
    }

    public void setC8_altura_real_sonda(String c8_altura_real_sonda) {
        this.c8_altura_real_sonda = c8_altura_real_sonda;
    }

    public String getC8_altura_sonda96() {
        return c8_altura_sonda96;
    }

    public void setC8_altura_sonda96(String c8_altura_sonda96) {
        this.c8_altura_sonda96 = c8_altura_sonda96;
    }

    public String getC8_cantidad_cargada() {
        return c8_cantidad_cargada;
    }

    public void setC8_cantidad_cargada(String c8_cantidad_cargada) {
        this.c8_cantidad_cargada = c8_cantidad_cargada;
    }

    public String getC8_cantidad_96st() {
        return c8_cantidad_96st;
    }

    public void setC8_cantidad_96st(String c8_cantidad_96st) {
        this.c8_cantidad_96st = c8_cantidad_96st;
    }

    public String getC8_diferencia() {
        return c8_diferencia;
    }

    public void setC8_diferencia(String c8_diferencia) {
        this.c8_diferencia = c8_diferencia;
    }

    public boolean isC8_cumple() {
        return c8_cumple;
    }

    public void setC8_cumple(boolean c8_cumple) {
        this.c8_cumple = c8_cumple;
    }

    public String getC9_altura_real_sonda() {
        return c9_altura_real_sonda;
    }

    public void setC9_altura_real_sonda(String c9_altura_real_sonda) {
        this.c9_altura_real_sonda = c9_altura_real_sonda;
    }

    public String getC9_altura_sonda96() {
        return c9_altura_sonda96;
    }

    public void setC9_altura_sonda96(String c9_altura_sonda96) {
        this.c9_altura_sonda96 = c9_altura_sonda96;
    }

    public String getC9_cantidad_cargada() {
        return c9_cantidad_cargada;
    }

    public void setC9_cantidad_cargada(String c9_cantidad_cargada) {
        this.c9_cantidad_cargada = c9_cantidad_cargada;
    }

    public String getC9_cantidad_96st() {
        return c9_cantidad_96st;
    }

    public void setC9_cantidad_96st(String c9_cantidad_96st) {
        this.c9_cantidad_96st = c9_cantidad_96st;
    }

    public String getC9_diferencia() {
        return c9_diferencia;
    }

    public void setC9_diferencia(String c9_diferencia) {
        this.c9_diferencia = c9_diferencia;
    }

    public boolean isC9_cumple() {
        return c9_cumple;
    }

    public void setC9_cumple(boolean c9_cumple) {
        this.c9_cumple = c9_cumple;
    }

    public String getC10_altura_real_sonda() {
        return c10_altura_real_sonda;
    }

    public void setC10_altura_real_sonda(String c10_altura_real_sonda) {
        this.c10_altura_real_sonda = c10_altura_real_sonda;
    }

    public String getC10_altura_sonda96() {
        return c10_altura_sonda96;
    }

    public void setC10_altura_sonda96(String c10_altura_sonda96) {
        this.c10_altura_sonda96 = c10_altura_sonda96;
    }

    public String getC10_cantidad_cargada() {
        return c10_cantidad_cargada;
    }

    public void setC10_cantidad_cargada(String c10_cantidad_cargada) {
        this.c10_cantidad_cargada = c10_cantidad_cargada;
    }

    public String getC10_cantidad_96st() {
        return c10_cantidad_96st;
    }

    public void setC10_cantidad_96st(String c10_cantidad_96st) {
        this.c10_cantidad_96st = c10_cantidad_96st;
    }

    public String getC10_diferencia() {
        return c10_diferencia;
    }

    public void setC10_diferencia(String c10_diferencia) {
        this.c10_diferencia = c10_diferencia;
    }

    public boolean isC10_cumple() {
        return c10_cumple;
    }

    public void setC10_cumple(boolean c10_cumple) {
        this.c10_cumple = c10_cumple;
    }

    public boolean isEstanqueidad_cisterna() {
        return estanqueidad_cisterna;
    }

    public void setEstanqueidad_cisterna(boolean estanqueidad_cisterna) {
        this.estanqueidad_cisterna = estanqueidad_cisterna;
    }

    public boolean isEstanqueidad_valvulas_api() {
        return estanqueidad_valvulas_api;
    }

    public void setEstanqueidad_valvulas_api(boolean estanqueidad_valvulas_api) {
        this.estanqueidad_valvulas_api = estanqueidad_valvulas_api;
    }

    public boolean isEstanqueidad_cajon_valvulas() {
        return estanqueidad_cajon_valvulas;
    }

    public void setEstanqueidad_cajon_valvulas(boolean estanqueidad_cajon_valvulas) {
        this.estanqueidad_cajon_valvulas = estanqueidad_cajon_valvulas;
    }

    public boolean isEstanqueidad_valvulas_fondo() {
        return estanqueidad_valvulas_fondo;
    }

    public void setEstanqueidad_valvulas_fondo(boolean estanqueidad_valvulas_fondo) {
        this.estanqueidad_valvulas_fondo = estanqueidad_valvulas_fondo;
    }

    public boolean isEstanqueidad_equipo_trasiego() {
        return estanqueidad_equipo_trasiego;
    }

    public void setEstanqueidad_equipo_trasiego(boolean estanqueidad_equipo_trasiego) {
        this.estanqueidad_equipo_trasiego = estanqueidad_equipo_trasiego;
    }

    public boolean isRecoger_albaran() {
        return recoger_albaran;
    }

    public void setRecoger_albaran(boolean recoger_albaran) {
        this.recoger_albaran = recoger_albaran;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumero_incidencia1() {
        return numero_incidencia1;
    }

    public void setNumero_incidencia1(String numero_incidencia1) {
        this.numero_incidencia1 = numero_incidencia1;
    }

    public int getPeso_entrada() {
        return peso_entrada;
    }

    public void setPeso_entrada(int peso_entrada) {
        this.peso_entrada = peso_entrada;
    }

    public int getPeso_salida() {
        return peso_salida;
    }

    public void setPeso_salida(int peso_salida) {
        this.peso_salida = peso_salida;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public Date getFecha_arnes() {
        return fecha_arnes;
    }

    public void setFecha_arnes(Date fecha_arnes) {
        this.fecha_arnes = fecha_arnes;
    }

    public int getC1_vol_total_placa() {
        return c1_vol_total_placa;
    }

    public void setC1_vol_total_placa(int c1_vol_total_placa) {
        this.c1_vol_total_placa = c1_vol_total_placa;
    }

    public int getC2_vol_total_placa() {
        return c2_vol_total_placa;
    }

    public void setC2_vol_total_placa(int c2_vol_total_placa) {
        this.c2_vol_total_placa = c2_vol_total_placa;
    }

    public int getC3_vol_total_placa() {
        return c3_vol_total_placa;
    }

    public void setC3_vol_total_placa(int c3_vol_total_placa) {
        this.c3_vol_total_placa = c3_vol_total_placa;
    }

    public int getC4_vol_total_placa() {
        return c4_vol_total_placa;
    }

    public void setC4_vol_total_placa(int c4_vol_total_placa) {
        this.c4_vol_total_placa = c4_vol_total_placa;
    }

    public int getC5_vol_total_placa() {
        return c5_vol_total_placa;
    }

    public void setC5_vol_total_placa(int c5_vol_total_placa) {
        this.c5_vol_total_placa = c5_vol_total_placa;
    }

    public int getC6_vol_total_placa() {
        return c6_vol_total_placa;
    }

    public void setC6_vol_total_placa(int c6_vol_total_placa) {
        this.c6_vol_total_placa = c6_vol_total_placa;
    }

    public int getC7_vol_total_placa() {
        return c7_vol_total_placa;
    }

    public void setC7_vol_total_placa(int c7_vol_total_placa) {
        this.c7_vol_total_placa = c7_vol_total_placa;
    }

    public int getC8_vol_total_placa() {
        return c8_vol_total_placa;
    }

    public void setC8_vol_total_placa(int c8_vol_total_placa) {
        this.c8_vol_total_placa = c8_vol_total_placa;
    }

    public int getC9_vol_total_placa() {
        return c9_vol_total_placa;
    }

    public void setC9_vol_total_placa(int c9_vol_total_placa) {
        this.c9_vol_total_placa = c9_vol_total_placa;
    }

    public int getC10_vol_total_placa() {
        return c10_vol_total_placa;
    }

    public void setC10_vol_total_placa(int c10_vol_total_placa) {
        this.c10_vol_total_placa = c10_vol_total_placa;
    }

    public boolean isInspeccionada() {
        return inspeccionada;
    }

    public void setInspeccionada(boolean inspeccionada) {
        this.inspeccionada = inspeccionada;
    }

    public boolean isFavorable() {
        return favorable;
    }

    public void setFavorable(boolean favorable) {
        this.favorable = favorable;
    }

    public boolean isDesfavorable() {
        return desfavorable;
    }

    public void setDesfavorable(boolean desfavorable) {
        this.desfavorable = desfavorable;
    }

    public Date getFecha_desfavorable() {
        return fecha_desfavorable;
    }

    public void setFecha_desfavorable(Date fecha_desfavorable) {
        this.fecha_desfavorable = fecha_desfavorable;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public Date getFecha_bloqueo() {
        return fecha_bloqueo;
    }

    public void setFecha_bloqueo(Date fecha_bloqueo) {
        this.fecha_bloqueo = fecha_bloqueo;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public boolean isTc2() {
        return tc2;
    }

    public void setTc2(boolean tc2) {
        this.tc2 = tc2;
    }

    public boolean isMontaje_tag_ok() {
        return montaje_tag_ok;
    }

    public void setMontaje_tag_ok(boolean montaje_tag_ok) {
        this.montaje_tag_ok = montaje_tag_ok;
    }

    public boolean isBajada_tag_planta() {
        return bajada_tag_planta;
    }

    public void setBajada_tag_planta(boolean bajada_tag_planta) {
        this.bajada_tag_planta = bajada_tag_planta;
    }

    public boolean isLectura_tag_isleta() {
        return lectura_tag_isleta;
    }

    public void setLectura_tag_isleta(boolean lectura_tag_isleta) {
        this.lectura_tag_isleta = lectura_tag_isleta;
    }

    public int getC1_tag() {
        return c1_tag;
    }

    public void setC1_tag(int c1_tag) {
        this.c1_tag = c1_tag;
    }

    public int getC2_tag() {
        return c2_tag;
    }

    public void setC2_tag(int c2_tag) {
        this.c2_tag = c2_tag;
    }

    public int getC3_tag() {
        return c3_tag;
    }

    public void setC3_tag(int c3_tag) {
        this.c3_tag = c3_tag;
    }

    public int getC4_tag() {
        return c4_tag;
    }

    public void setC4_tag(int c4_tag) {
        this.c4_tag = c4_tag;
    }

    public int getC5_tag() {
        return c5_tag;
    }

    public void setC5_tag(int c5_tag) {
        this.c5_tag = c5_tag;
    }

    public int getC6_tag() {
        return c6_tag;
    }

    public void setC6_tag(int c6_tag) {
        this.c6_tag = c6_tag;
    }

    public int getC7_tag() {
        return c7_tag;
    }

    public void setC7_tag(int c7_tag) {
        this.c7_tag = c7_tag;
    }

    public int getC8_tag() {
        return c8_tag;
    }

    public void setC8_tag(int c8_tag) {
        this.c8_tag = c8_tag;
    }

    public int getC9_tag() {
        return c9_tag;
    }

    public void setC9_tag(int c9_tag) {
        this.c9_tag = c9_tag;
    }

    public int getC10_tag() {
        return c10_tag;
    }

    public void setC10_tag(int c10_tag) {
        this.c10_tag = c10_tag;
    }

    public String getTag_observaciones() {
        return tag_observaciones;
    }

    public void setTag_observaciones(String tag_observaciones) {
        this.tag_observaciones = tag_observaciones;
    }

    public boolean isInspeccion_camara() {
        return inspeccion_camara;
    }

    public void setInspeccion_camara(boolean inspeccion_camara) {
        this.inspeccion_camara = inspeccion_camara;
    }
}
