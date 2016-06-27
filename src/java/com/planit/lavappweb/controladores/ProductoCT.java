/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServicioProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class ProductoCT implements Serializable{
    
    private Producto_TO producto;
    private List<Producto_TO> productos;
    private ServicioProducto servicioProduct;

    public ProductoCT() {
        producto = new Producto_TO();
        productos = new ArrayList<>();
        servicioProduct = new ServicioProducto();
    }

    @PostConstruct
    public void init() {
        productos = servicioProduct.consultarProductos();
    }

    //Getter & Setter
    public Producto_TO getProducto() {
        return producto;
    }

    public void setProducto(Producto_TO producto) {
        this.producto = producto;
    }

    public List<Producto_TO> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto_TO> productos) {
        this.productos = productos;
    }

    public ServicioProducto getServicioProduct() {
        return servicioProduct;
    }

    public void setServicioProduct(ServicioProducto servicioProduct) {
        this.servicioProduct = servicioProduct;
    }
    
    
    //Metodos
    public void registrar() {
        try {
           producto = servicioProduct.registrarProducto(producto.getNombre(), producto.getDescripcion(), producto.getSubServicio().getIdSubServicio());            
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
    }

    public void eliminar(){
    }
}
