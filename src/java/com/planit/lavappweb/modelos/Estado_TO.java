/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Estado
 *
 * Tabla Relacionada Estado
 *
 * @author Planit
 */
@XmlRootElement
public class Estado_TO {

    /**
     *
     * Columna idEstado
     */
    private int idEstado;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Estado_TO() {
    }

    //Constructor General
    public Estado_TO(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public Estado_TO(int idEstado) {
        this.idEstado = idEstado;
    }
    
    

    //Getter and Setter
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estado_TO{" + "idEstado=" + idEstado + ", nombre=" + nombre + '}';
    }

}
