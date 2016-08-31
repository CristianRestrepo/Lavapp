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
 * Objeto de negocios que modelo una Ciudad
 *
 * Tabla Relacionada Ciudad
 *
 * @author Planit
 */
@XmlRootElement
public class Ciudad_TO implements Serializable{

    /**
     *
     * Columna idCiudad
     */
    private int idCiudad;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna idDepartamento
     */
    private Departamento_TO departamento;

    //Constructores
    public Ciudad_TO() {
        departamento = new Departamento_TO();
    }

    //Constructor General
    public Ciudad_TO(int idCiudad, String nombre, Departamento_TO departamento) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // CONSTRUCTOR PARA LOCALIDAD DAO
    public Ciudad_TO(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad_TO(int idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }

    //Getter and Setter
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento_TO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento_TO departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Ciudad_TO{" + "idCiudad=" + idCiudad + ", nombre=" + nombre + ", departamento=" + departamento + '}';
    }
}
