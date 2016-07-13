/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * Objeto de negocios que modelo una Jornada
 *
 * Tabla Relacionada Jornada
 *
 * @author Planit
 */
@XmlRootElement
public class Jornada_TO implements Serializable{

    /**
     *
     * Columna idJornada
     */
    private int idJornada;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Jornada_TO() {
    }

    //Constructor General

    public Jornada_TO(int idJornada) {
        this.idJornada = idJornada;
    }
         
    public Jornada_TO(int idJornada, String nombre) {
        this.idJornada = idJornada;
        this.nombre = nombre;
    }

    //Getter and Setter
    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jornada_TO{" + "idJornada=" + idJornada + ", nombre=" + nombre + '}';
    }

}
