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
 * Objeto de negocios que modelo una Calificacion
 *
 * Tabla Relacionada Calificacion
 *
 * @author Planit
 */
@XmlRootElement
public class Calificacion_TO implements Serializable{

    /**
     *
     * Columna idCalificacion
     */
    private int idCalificacion;

    /**
     *
     * Columna calificacion
     */
    private int calificacion;

    /**
     *
     * Columna observacion
     */
    private String observacion;

    /**
     *
     * Columna idPedido
     */
    private Pedido_TO pedido;

    //Constructores
    public Calificacion_TO() {
        pedido = new Pedido_TO();
    }

    public Calificacion_TO(int calificacion, String observacion, Pedido_TO pedido) {
        this.calificacion = calificacion;
        this.observacion = observacion;
        this.pedido = pedido;
    }        

    //Constructor General
    public Calificacion_TO(int idCalificacion, int calificacion, String observacion, Pedido_TO pedido) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;
        this.observacion = observacion;
        this.pedido = pedido;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Calificacion_TO{" + "idCalificacion=" + idCalificacion + ", calificacion=" + calificacion + ", observacion=" + observacion + ", pedido=" + pedido + '}';
    }

}
