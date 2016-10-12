/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VaioDevelopment
 */
@XmlRootElement
public class FormaPago_TO {
    
    private int idFormaPago;

    private String nombre;

    public FormaPago_TO() {
    }

    public FormaPago_TO(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPago_TO(int idFormaPago, String nombre) {
        this.idFormaPago = idFormaPago;
        this.nombre = nombre;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "FormaPago_TO{" + "idFormaPago=" + idFormaPago + ", nombre=" + nombre + '}';
    }
    
}
