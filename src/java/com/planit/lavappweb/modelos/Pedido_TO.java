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
 * Objeto de negocios que modelo un Pedido
 *
 * Tabla Relacionada Pedido
 *
 * @author Planit
 */
@XmlRootElement
public class Pedido_TO {

    /**
     *
     * Columna idPedido
     */
    private int idPedido;

    /**
     *
     * Columna idUsuario
     */
    private Usuario_TO usuario;

    /**
     *
     * Columna fechaInicio
     */
    private Date fechaInicio;

    /**
     *
     * Columna horaInicio_idHorario
     */
    private Horario_TO horaInicio;

    /**
     *
     * Columna horaFinal_idHorario
     */
    private Horario_TO horaFinal;

    /**
     *
     * Columna horaFinal_idHorario
     */
    private Estado_TO estado;

    /**
     *
     * Columna idProveedor
     */
    private Proveedor_TO proveedor;

    //Constructores
    public Pedido_TO() {
    }

    //Constructor General
    public Pedido_TO(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido_TO(Usuario_TO usuario, Date fechaInicio, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Proveedor_TO proveedor) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.proveedor = proveedor;
    }

    public Pedido_TO(int idPedido, Usuario_TO usuario, Date fechaInicio, Horario_TO horaInicio, Horario_TO horaFinal, Estado_TO estado, Proveedor_TO proveedor) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.proveedor = proveedor;
    }

    //Getter and Setter
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario_TO getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario_TO usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Horario_TO getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Horario_TO horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Horario_TO getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Horario_TO horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Estado_TO getEstado() {
        return estado;
    }

    public void setEstado(Estado_TO estado) {
        this.estado = estado;
    }

    public Proveedor_TO getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor_TO proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Pedido_TO{" + "idPedido=" + idPedido + ", usuario=" + usuario + ", fechaInicio=" + fechaInicio + ", HoraInicio=" + horaInicio + ", HoraFinal=" + horaFinal + ", Estado=" + estado + ", Proveedor=" + proveedor + '}';
    }

}
