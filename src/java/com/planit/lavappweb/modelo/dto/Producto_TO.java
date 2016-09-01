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
 * Objeto de negocios que modelo un Producto
 *
 * Tabla Relacionada Producto
 *
 * @author Planit
 */
@XmlRootElement
public class Producto_TO implements Serializable{

    /**
     *
     * Columna idProducto
     */
    private int idProducto;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna descripcion
     */
    private String descripcion;

    /**
     *
     * Columna idSubServicio
     */
    private SubServicio_TO subServicio;

    /**
     *
     * Columna rutaImagen
     */
    private String rutaImagen;

    //Constructores
    public Producto_TO() {
        subServicio = new SubServicio_TO();
    }

    public Producto_TO(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto_TO(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }       

    public Producto_TO(String nombre, String descripcion, SubServicio_TO subServicio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subServicio = subServicio;
    }

    //Constructor General
    public Producto_TO(int idProducto, String nombre, String descripcion, SubServicio_TO subServicio, String rutaImagen) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subServicio = subServicio;
        this.rutaImagen = rutaImagen;
    }

    //Getter and Setter
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public SubServicio_TO getSubServicio() {
        return subServicio;
    }

    public void setSubServicio(SubServicio_TO subServicio) {
        this.subServicio = subServicio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Producto_TO{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", subServicio=" + subServicio + ", rutaImagen=" + rutaImagen + '}';
    }

}
