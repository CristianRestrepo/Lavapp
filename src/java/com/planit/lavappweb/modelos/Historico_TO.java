/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Historico
 *
 * Tabla Relacionada Historico
 *
 * @author Planit
 */
@XmlRootElement
public class Historico_TO {

    /**
     *
     * Columna idHistorico
     */
    private int idHistorico;

    /**
     *
     * Columna idDescripcionPedido
     */
    private DescripcionPedido_TO descripcionPedido;

    /**
     *
     * Columna estado
     */
    private Estado_TO estado;

    /**
     *
     * Columna fecha
     */
    private Date fecha;

    //Constructores
    public Historico_TO() {
    }

    public Historico_TO(int idHistorico) {
        this.idHistorico = idHistorico;
    }    

    public Historico_TO(DescripcionPedido_TO descripcionPedido, Estado_TO estado, Date fecha) {
        this.descripcionPedido = descripcionPedido;
        this.estado = estado;
        this.fecha = fecha;
    }
    
        //Constructor General
    public Historico_TO(int idHistorico, DescripcionPedido_TO descripcionPedido, Estado_TO estado, Date fecha) {
        this.idHistorico = idHistorico;
        this.descripcionPedido = descripcionPedido;
        this.estado = estado;
        this.fecha = fecha;
    }
       
    //Getter and Setter
    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public DescripcionPedido_TO getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(DescripcionPedido_TO descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }
    
    public Estado_TO getEstado() {
        return estado;
    }

    public void setEstado(Estado_TO estado) {
        this.estado = estado;
    }
  
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Historico_TO{" + "idHistorico=" + idHistorico + ", descripcionPedido=" + descripcionPedido + ", estado=" + estado + ", fecha=" + fecha + '}';
    }

}
