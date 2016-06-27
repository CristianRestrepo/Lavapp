/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Estrato
 *
 * Tabla Relacionada Estrato
 *
 * @author Planit
 */
@XmlRootElement
public class Estrato_TO {

    /**
     *
     * Columna idEstrato
     */
    private int idEstrato;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Estrato_TO() {
    }

    public Estrato_TO(int idEstrato) {
        this.idEstrato = idEstrato;
    }
    
    //Constructor General
    public Estrato_TO(int idEstrato, String nombre) {
        this.idEstrato = idEstrato;
        this.nombre = nombre;
    }

    //Getter and Setter
    public int getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(int idEstrato) {
        this.idEstrato = idEstrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estrato_TO{" + "idEstrato=" + idEstrato + ", nombre=" + nombre + '}';
    }

}
