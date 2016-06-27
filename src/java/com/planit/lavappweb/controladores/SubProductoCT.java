/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planit.lavappweb.controladores;

import com.planit.lavappweb.modelos.SubProducto_TO;
import com.planit.lavappweb.webservices.implementaciones.ServicioSubProductos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Desarrollo_Planit
 */

public class SubProductoCT implements Serializable{

    private SubProducto_TO subproducto;
    private List<SubProducto_TO> subproductos;
    private ServicioSubProductos clienteSubProducto;

    public SubProductoCT() {
        subproducto = new SubProducto_TO();
        subproductos = new ArrayList<>();
        clienteSubProducto = new ServicioSubProductos();
    }

    @PostConstruct
    public void init() {
        
        subproductos = clienteSubProducto.consultarSubProductos();
    }

    //Getter & Setter
    public SubProducto_TO getSubproducto() {
        return subproducto;
    }

    public void setSubproducto(SubProducto_TO subproducto) {
        this.subproducto = subproducto;
    }

    public List<SubProducto_TO> getSubproductos() {
        return subproductos;
    }

    public void setSubproductos(List<SubProducto_TO> subproductos) {
        this.subproductos = subproductos;
    }

    public ServicioSubProductos getClienteSubProducto() {
        return clienteSubProducto;
    }

    public void setClienteSubProducto(ServicioSubProductos clienteSubProducto) {
        this.clienteSubProducto = clienteSubProducto;
    }

    //Metodos
    public void registrar() {
        try {
            clienteSubProducto.registrarSubproductos(subproducto.getNombre(), subproducto.getDescripcion(), subproducto.getProducto().getIdProducto());
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
    }

    public void eliminar() {
    }
}
