/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProductoCosto_TO implements Serializable {
    
    private int idSubProducto;
    private String nombre;
    private String descripcion;
    private Producto_TO producto;
    private String rutaImagen;
    private Costo_TO costo;

    public SubProductoCosto_TO() {
    }

    public SubProductoCosto_TO(int idSubProducto, String nombre, String descripcion, Producto_TO producto, String rutaImagen, Costo_TO costo) {
        this.idSubProducto = idSubProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.producto = producto;
        this.rutaImagen = rutaImagen;
        this.costo = costo;
    }

    public int getIdSubProducto() {
        return idSubProducto;
    }

    public void setIdSubProducto(int idSubProducto) {
        this.idSubProducto = idSubProducto;
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

    public Producto_TO getProducto() {
        return producto;
    }

    public void setProducto(Producto_TO producto) {
        this.producto = producto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Costo_TO getCosto() {
        return costo;
    }

    public void setCosto(Costo_TO costo) {
        this.costo = costo;
    }
    
    
}
