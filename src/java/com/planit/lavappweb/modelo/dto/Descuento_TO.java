/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Descuento
 *
 * Tabla Relacionada Descuento
 *
 * @author Planit
 */
@XmlRootElement
public class Descuento_TO implements Serializable{

    /**
     *
     * Columna idDescuento
     */
    private int idDescuento;

    /**
     *
     * Columna fechaInicio
     */
    private Date fechaInicio;

    /**
     *
     * Columna fechaFinal
     */
    private Date fechaFinal;

    /**
     *
     * Columna porcentaje
     */
    private int porcentaje;

    /**
     *
     * Columna idCosto
     */
    private Costo_TO costo;

    /**
     *
     * Columna horaInicio
     */
    private String horaInicio;

    /**
     *
     * Columna horaFinal
     */
    private String horaFinal;

    //Constructores
    public Descuento_TO() {
    }

    //Constructor General
    public Descuento_TO(int idDescuento, Date fechaInicio, Date fechaFinal, int porcentaje, Costo_TO costo, String horaInicio, String horaFinal) {
        this.idDescuento = idDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.porcentaje = porcentaje;
        this.costo = costo;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    //Getter and Setter
    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Costo_TO getCosto() {
        return costo;
    }

    public void setCosto(Costo_TO costo) {
        this.costo = costo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public String toString() {
        return "Descuento_TO{" + "idDescuento=" + idDescuento + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", porcentaje=" + porcentaje + ", costo=" + costo + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + '}';
    }

}
