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
 * Objeto de negocios que modelo una Localidad
 *
 * Tabla Relacionada Localidad
 *
 * @author Planit
 */
@XmlRootElement
public class Localidad_TO implements Serializable{

    /**
     *
     * Columna idLocalidad
     */
    private int idLocalidad;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna idCiudad
     */
    private Ciudad_TO ciudad;
    
    //Constructores

    public Localidad_TO() {
        idLocalidad = 0;
        ciudad = new Ciudad_TO();
    }

    public Localidad_TO(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Localidad_TO(int idLocalidad, String nombre) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
    }
    
    
    // Constructor General
    public Localidad_TO(int idLocalidad, String nombre, Ciudad_TO ciudad) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    //Getter and Setter

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad_TO getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad_TO ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Localidad_TO{" + "idLocalidad=" + idLocalidad + ", nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }
    
    
    
    

}
