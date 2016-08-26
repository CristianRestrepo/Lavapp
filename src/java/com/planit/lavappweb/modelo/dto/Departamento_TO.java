/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Departamento
 *
 * Tabla Relacionada Departamento
 *
 * @author Planit
 */
@XmlRootElement
public class Departamento_TO {

    /**
     *
     * Columna idDepartamento
     */
    private int idDepartamento;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna idPais
     */
    private Pais_TO pais;

    //Constructores
    public Departamento_TO() {
        idDepartamento = 0;
        pais = new Pais_TO();
    }

    //Constructor General
    public Departamento_TO(int idDepartamento, String nombre, Pais_TO pais) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Departamento_TO(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }    

    public Departamento_TO(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }
    
    
    //Getter and Setter
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais_TO getPais() {
        return pais;
    }

    public void setPais(Pais_TO pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Departamento_TO{" + "idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", pais=" + pais + '}';
    }

}
