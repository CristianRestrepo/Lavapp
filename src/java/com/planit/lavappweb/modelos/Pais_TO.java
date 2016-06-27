/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Pais
 *
 * Tabla Relacionada Pais
 *
 * @author Planit
 */
@XmlRootElement
public class Pais_TO implements java.io.Serializable{

    /**
     *
     * Columna idPais
     */
    private int idPais;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    public Pais_TO() {
    }

    public Pais_TO(int idPais) {
        this.idPais = idPais;
    }
    
    

    public Pais_TO(int idPais, String nombre) {
        this.idPais = idPais;
        this.nombre = nombre;
    }

    //Getter & Setters
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
