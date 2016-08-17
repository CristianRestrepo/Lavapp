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
 * Objeto de negocios que modelo un Factura
 *
 * Tabla Relacionada Factura
 *
 * @author Planit
 */
@XmlRootElement
public class Factura_TO {

    /**
     *
     * Columna idFactura
     */
    private int idFactura;

    /**
     *
     * Columna total
     */
    private double total;

    /**
     *
     * Columna subTotal
     */
    private double subTotal;

    /**
     *
     * Columna neto
     */
    private double neto;

    /**
     *
     * Columna iva
     */
    private double iva;

    /**
     *
     * Columna descuento
     */
    private double descuento;

    /**
     *
     * Columna fecha
     */
    private Date fecha;

    /**
     *
     * Columna idPedido
     */
    private Pedido_TO pedido;

    //Constructores
    public Factura_TO() {
        pedido = new Pedido_TO();

    }

    //Constructor General
    public Factura_TO(int idFactura, double total, double subTotal, double neto, double iva, double descuento, Date fecha, Pedido_TO pedido) {
        this.idFactura = idFactura;
        this.total = total;
        this.subTotal = subTotal;
        this.neto = neto;
        this.iva = iva;
        this.descuento = descuento;
        this.fecha = fecha;
        this.pedido = pedido;
    }

    //Getter and Setter
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido_TO getPedido() {
        return pedido;
    }

    public void setPedido(Pedido_TO pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Factura_TO{" + "idFactura=" + idFactura + ", total=" + total + ", subTotal=" + subTotal + ", neto=" + neto + ", iva=" + iva + ", descuento=" + descuento + ", fecha=" + fecha + ", pedido=" + pedido + '}';
    }

}
