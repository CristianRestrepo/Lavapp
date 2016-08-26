/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Color
 *
 * Tabla Relacionada Color
 *
 * @author Planit
 */
@XmlRootElement
public class Color_TO {

    /**
     *
     * Columna idColor
     */
    private int idColor;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Color_TO() {
    }

    public Color_TO(int idColor) {
        this.idColor = idColor;
    }
    
        //Constructor General
    public Color_TO(int idColor, String nombre) {
        this.idColor = idColor;
        this.nombre = nombre;
    }

    //Getter and Setter
    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Color_TO{" + "idColor=" + idColor + ", nombre=" + nombre + '}';
    }

}
