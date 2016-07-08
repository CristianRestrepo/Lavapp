/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.modelos;

/**
 *
 * @author Desarrollo_Planit
 */
public class SubProducto_TO {

    private int idSubProducto;
    private String nombre;
    private String descripcion;
    private Producto_TO producto;
    private String rutaImagen;

    public SubProducto_TO() {
        producto = new Producto_TO();
    }

    public SubProducto_TO(int idSubProducto) {
        this.idSubProducto = idSubProducto;
    }

    public SubProducto_TO(int idSubProducto, String nombre, String descripcion, Producto_TO producto, String rutaImagen) {
        this.idSubProducto = idSubProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.producto = producto;
        this.rutaImagen = rutaImagen;
    }

    public SubProducto_TO(String nombre, String descripcion, Producto_TO producto, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.producto = producto;
        this.rutaImagen = rutaImagen;
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

    @Override
    public String toString() {
        return "SubProducto_TO{" + "idSubProducto=" + idSubProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", producto=" + producto + ", rutaImagen = " + rutaImagen + '}';
    }

}
