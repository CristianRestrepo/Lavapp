/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

/**
 *
 * @author VaioDevelopment
 */
public class EstadoPago_TO {
    
    private int idEstadoPago;
    
    private String nombre;

    public EstadoPago_TO() {       
    }

    public EstadoPago_TO(int idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }
       
    public EstadoPago_TO(int idEstadoPago, String nombre) {
        this.idEstadoPago = idEstadoPago;
        this.nombre = nombre;
    }

    public int getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(int idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoPago_TO{" + "idEstadoPago=" + idEstadoPago + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
