/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Servicio
 *
 * Tabla Relacionada Servicio
 *
 * @author Planit
 */
@XmlRootElement
public class Servicio_TO implements Serializable {

    /**
     *
     * Columna idServicio
     */
    private int idServicio;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Servicio_TO() {
    }

    //Constructor General
    public Servicio_TO(int idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio_TO(String nombre) {
        this.nombre = nombre;
    }

    public Servicio_TO(int idServicio, String nombre) {
        this.idServicio = idServicio;
        this.nombre = nombre;
    }

    //Getter and Setter
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Servicio_TO{" + "idServicio=" + idServicio + ", nombre=" + nombre + '}';
    }

}
