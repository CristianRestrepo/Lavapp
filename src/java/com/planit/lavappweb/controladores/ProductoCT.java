/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.Producto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServiciosProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */
public class ProductoCT implements Serializable {

    private Producto_TO producto;
    private List<Producto_TO> productos;
    protected ServiciosProducto serviciosProducto;

    //Variables
    private String nombreOperacion;
    protected int operacion;

    public ProductoCT() {
        producto = new Producto_TO();
        productos = new ArrayList<>();
        serviciosProducto = new ServiciosProducto();

        nombreOperacion = "Registrar";
        operacion = 0;
    }

    @PostConstruct
    public void init() {
        productos = serviciosProducto.consultarProductos();
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

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    //Metodos
    public void registrar() {
        producto = serviciosProducto.registrarProducto(producto.getNombre(), producto.getDescripcion(), producto.getSubServicio().getIdSubServicio());
        productos = serviciosProducto.consultarProductos();
    }

    public void modificar() {
        producto = serviciosProducto.modificarProducto(producto.getIdProducto(), producto.getNombre(), producto.getDescripcion(), producto.getSubServicio().getIdSubServicio());
        productos = serviciosProducto.consultarProductos();
    }

    public void eliminar() {
        producto = serviciosProducto.eliminar(producto.getIdProducto());
        productos = serviciosProducto.consultarProductos();
    }
    
     //Metodos Propios
    public void metodo() {
        if (operacion == 0) {
            registrar();
        } else if (operacion == 1) {
            modificar();
            //Reiniciamos banderas
            nombreOperacion = "Registrar";
            operacion = 0;
        }
    }

    public void seleccionarCRUD(int i) {
        operacion = i;
        if (operacion == 1) {
            nombreOperacion = "Modificar";
        }
    }

    public void cancelar() {
        producto = new Producto_TO();
        productos = serviciosProducto.consultarProductos();
        operacion = 0;
        nombreOperacion = "Registrar";
    }
}
