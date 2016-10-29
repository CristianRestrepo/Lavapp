/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import java.util.Date;

/**
 *
 * @author VaioDevelopment
 */
public class Promocion_TO {

    int idPromocion;
    
    Date fechaInicio;
    
    Date fechaFinal;
    
    int porcentaje;
    
    String horaInicio;
    
    String horafinal;
    
    String nombre;

    public Promocion_TO() {
    }

    public Promocion_TO(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promocion_TO(int idPromocion, String nombre) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
    }

    public Promocion_TO(int idPromocion, Date fechaInicio, Date fechaFinal, int porcentaje, String horaInicio, String horafinal, String nombre) {
        this.idPromocion = idPromocion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.porcentaje = porcentaje;
        this.horaInicio = horaInicio;
        this.horafinal = horafinal;
        this.nombre = nombre;
    }

    public Promocion_TO(Date fechaInicio, Date fechaFinal, int porcentaje, String horaInicio, String horafinal, String nombre) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.porcentaje = porcentaje;
        this.horaInicio = horaInicio;
        this.horafinal = horafinal;
        this.nombre = nombre;
    }
    
    

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Promocion_TO{" + "idPromocion=" + idPromocion + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", porcentaje=" + porcentaje + ", horaInicio=" + horaInicio + ", horafinal=" + horafinal + ", nombre=" + nombre + '}';
    }

    
}
