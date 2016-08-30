/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo una Descripcion del pedido
 *
 * Tabla Relacionada DescripcionPedido
 *
 * @author Planit
 */
@XmlRootElement
public class DescripcionPedido_TO {

    /**
     *
     * Columna idDescripcionPedido
     */
    private int idDescripcionPedido;

    /**
     *
     * Columna idEstado
     */
    private Estado_TO estado;

    /**
     *
     * Columna idProducto
     */
    private SubProducto_TO subProducto;

    /**
     *
     * Columna descripcion
     */
    private String descripcion;

    /**
     *
     * Columna ObservacionAsesor
     */
    private String observacionAsesor;

    /**
     *
     * Columna ObservacionAdministrador
     */
    private String observacionAdministrador;

    /**
     *
     * Columna foto1
     */
    private byte foto1;

    /**
     *
     * Columna foto2
     */
    private byte foto2;

    /**
     *
     * Columna foto3
     */
    private byte foto3;

    /**
     *
     * Columna idColor
     */
    private Color_TO color;

    /**
     *
     * Columna idPedido
     */
    private Pedido_TO pedido;
     /**
     *
     * Columna idPedido
     */
    private String codigo;
    
    //Constructores
    public DescripcionPedido_TO() {
    }

    public DescripcionPedido_TO(int idDescripcionPedido) {
        this.idDescripcionPedido = idDescripcionPedido;
    }      

    //Constructor General

    public DescripcionPedido_TO(int idDescripcionPedido, Estado_TO estado, SubProducto_TO subProducto, String descripcion, String observacionAsesor, String observacionAdministrador, byte foto1, byte foto2, byte foto3, Color_TO color, Pedido_TO pedido, String codigo) {
        this.idDescripcionPedido = idDescripcionPedido;
        this.estado = estado;
        this.subProducto = subProducto;
        this.descripcion = descripcion;
        this.observacionAsesor = observacionAsesor;
        this.observacionAdministrador = observacionAdministrador;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.color = color;
        this.pedido = pedido;
        this.codigo = codigo;
    }

    public DescripcionPedido_TO(int idDescripcionPedido, Estado_TO estado, SubProducto_TO subProducto, String descripcion, String observacionAsesor, String observacionAdministrador, Color_TO color, Pedido_TO pedido, String codigo) {
        this.idDescripcionPedido = idDescripcionPedido;
        this.estado = estado;
        this.subProducto = subProducto;
        this.descripcion = descripcion;
        this.observacionAsesor = observacionAsesor;
        this.observacionAdministrador = observacionAdministrador;
        this.color = color;
        this.pedido = pedido;
        this.codigo = codigo;
    }
    
    
 

    //Getter and Setter
    public int getIdDescripcionPedido() {
        return idDescripcionPedido;
    }

    public void setIdDescripcionPedido(int idDescripcionPedido) {
        this.idDescripcionPedido = idDescripcionPedido;
    }

    public Estado_TO getEstado() {
        return estado;
    }

    public void setEstado(Estado_TO estado) {
        this.estado = estado;
    }

    public SubProducto_TO getSubProducto() {
        return subProducto;
    }

    public void setSubProducto(SubProducto_TO subProducto) {
        this.subProducto = subProducto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacionAsesor() {
        return observacionAsesor;
    }

    public void setObservacionAsesor(String observacionAsesor) {
        this.observacionAsesor = observacionAsesor;
    }

    public String getObservacionAdministrador() {
        return observacionAdministrador;
    }

    public void setObservacionAdministrador(String observacionAdministrador) {
        this.observacionAdministrador = observacionAdministrador;
    }

    public byte getFoto1() {
        return foto1;
    }

    public void setFoto1(byte foto1) {
        this.foto1 = foto1;
    }

    public byte getFoto2() {
        return foto2;
    }

    public void setFoto2(byte foto2) {
        this.foto2 = foto2;
    }

    public byte getFoto3() {
        return foto3;
    }

    public void setFoto3(byte foto3) {
        this.foto3 = foto3;
    }

    public Color_TO getColor() {
        return color;
    }

    public void setColor(Color_TO color) {
        this.color = color;
    }

    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "DescripcionPedido_TO{" + "idDescripcionPedido=" + idDescripcionPedido + ", estado=" + estado + ", subProducto=" + subProducto + ", descripcion=" + descripcion + ", observacionAsesor=" + observacionAsesor + ", observacionAdministrador=" + observacionAdministrador + ", foto1=" + foto1 + ", foto2=" + foto2 + ", foto3=" + foto3 + ", color=" + color + ", pedido=" + pedido + ", codigo=" + codigo + '}';
    }

    
    

}
