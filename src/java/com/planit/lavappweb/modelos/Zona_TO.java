/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo una Zona
 *
 * Tabla Relacionada Zona
 *
 * @author Planit
 */
@XmlRootElement
public class Zona_TO {

    /**
     *
     * Columna idZona
     */
    private int idZona;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna descripcion
     */
    private String descripcion;
    
    //Constructores

    public Zona_TO() {
    }

    public Zona_TO(int idZona) {
        this.idZona = idZona;
    }
     
       
    //Constructor general
    public Zona_TO(int idZona, String nombre, String descripcion) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //Getter and Setter

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Zona_TO{" + "idZona=" + idZona + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
