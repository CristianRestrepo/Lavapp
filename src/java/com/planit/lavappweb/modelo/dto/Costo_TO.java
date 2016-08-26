/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Costo
 *
 * Tabla Relacionada Costo
 *
 * @author Planit
 */
@XmlRootElement
public class Costo_TO {

    /**
     *
     * Columna idCosto
     */
    private int idCosto;

    /**
     *
     * Columna valor
     */
    private int valor;

    /**
     *
     * Columna idCosto
     */
    private SubProducto_TO subProducto;

    /**
     *
     * Columna idCosto
     */
    private Zona_TO zona;

    //Constructores
    public Costo_TO() {
    }

    public Costo_TO(int idCosto) {
        this.idCosto = idCosto;
    }  
    
    public Costo_TO(int idCosto, int valor, Zona_TO zona) {
        this.idCosto = idCosto;
        this.valor = valor;
        this.zona = zona;
    }       

    public Costo_TO(int valor, SubProducto_TO subProducto, Zona_TO zona) {
        this.valor = valor;
        this.subProducto = subProducto;
        this.zona = zona;
    }

    public Costo_TO(int idCosto, int valor, SubProducto_TO subProducto, Zona_TO zona) {
        this.idCosto = idCosto;
        this.valor = valor;
        this.subProducto = subProducto;
        this.zona = zona;
    }   

    //Getter and Setter
    public int getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(int idCosto) {
        this.idCosto = idCosto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public SubProducto_TO getSubProducto() {
        return subProducto;
    }

    public void setSubProducto(SubProducto_TO subProducto) {
        this.subProducto = subProducto;
    }
    
    public Zona_TO getZona() {
        return zona;
    }

    public void setZona(Zona_TO zona) {
        this.zona = zona;
    }
    

    @Override
    public String toString() {
        return "Costo_TO{" + "idCosto=" + idCosto + ", valor=" + valor + ", subProducto=" + subProducto + ", zona=" + zona + '}';
    }

}
